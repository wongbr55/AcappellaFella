package logger;

import interface_adapter.AddMainPlayer.AddMainPlayerLoggerModel;
import interface_adapter.AddMainPlayer.AddMainPlayerState;
import interface_adapter.EnterChooseName.HostEnterChooseName.HostEnterChooseNameController;
import interface_adapter.EnterChooseName.JoinEnterChooseName.JoinEnterChooseNameController;
import interface_adapter.InitializePlayers.InitializePlayersController;
import interface_adapter.JoinLobby.JoinLobbyLoggerModel;
import interface_adapter.JoinLobby.JoinLobbyState;
import interface_adapter.ReceiveMessage.ReceiveMessageController;
import interface_adapter.SendMessage.SendMessageLoggerModel;
import interface_adapter.SendMessage.SendMessageState;
import interface_adapter.StartLobby.StartLobbyLoggerModel;
import interface_adapter.StartLobby.StartLobbyState;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.jetbrains.annotations.NotNull;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

public class MessageLogger extends ListenerAdapter implements PropertyChangeListener {
    final private String TOKEN = System.getenv("DISCORD_TOKEN");
    final private String GUILD_ID = "1168619453492236421";
    final private EnumSet<GatewayIntent> intents = EnumSet.of(
            // Enables MessageReceivedEvent for guild (also known as servers)
            GatewayIntent.GUILD_MESSAGES,
            // Enables access to message.getContentRaw()
            GatewayIntent.MESSAGE_CONTENT
    );
    private SendMessageLoggerModel sendMessageLoggerModel;
    private StartLobbyLoggerModel startLobbyLoggerModel;
    private JoinLobbyLoggerModel joinLobbyLoggerModel;
    private AddMainPlayerLoggerModel addMainPlayerLoggerModel;
    private ReceiveMessageController receiveMessageController;
    private InitializePlayersController initializePlayersController;
    private HostEnterChooseNameController hostEnterChooseNameController;
    private JoinEnterChooseNameController joinEnterChooseNameController;
    private JDA jda;
    private Guild guild;
    private TextChannel playerLists;
    private static TextChannel mainChannel;

    private MessageLogger(ReceiveMessageController receiveMessageController) {
        this.receiveMessageController = receiveMessageController;
    }

    public MessageLogger(SendMessageLoggerModel sendMessageLoggerModel,
                         StartLobbyLoggerModel startLobbyLoggerModel,
                         JoinLobbyLoggerModel joinLobbyLoggerModel,
                         AddMainPlayerLoggerModel addMainPlayerLoggerModel,
                         InitializePlayersController initializePlayersController,
                         ReceiveMessageController receiveMessageController,
                         HostEnterChooseNameController hostEnterChooseNameController,
                         JoinEnterChooseNameController joinEnterChooseNameController) {
        this.sendMessageLoggerModel = sendMessageLoggerModel;
        sendMessageLoggerModel.addPropertyChangeListener(this);
        this.startLobbyLoggerModel = startLobbyLoggerModel;
        startLobbyLoggerModel.addPropertyChangeListener(this);
        this.joinLobbyLoggerModel = joinLobbyLoggerModel;
        joinLobbyLoggerModel.addPropertyChangeListener(this);
        this.addMainPlayerLoggerModel = addMainPlayerLoggerModel;
        addMainPlayerLoggerModel.addPropertyChangeListener(this);

        this.initializePlayersController = initializePlayersController;
        this.hostEnterChooseNameController = hostEnterChooseNameController;
        this.joinEnterChooseNameController = joinEnterChooseNameController;

        try {
            // By using createLight(token, intents), we use a minimalistic cache profile (lower ram usage)
            // and only enable the provided set of intents. All other intents are disabled, so you won't receive events for those.
            this.jda = JDABuilder.createLight(TOKEN, intents)
                    // On this builder, you are adding all your event listeners and session configuration
                    .addEventListeners(new MessageLogger(receiveMessageController))
                    // Once you're done configuring your jda instance, call build to start and login the bot.
                    .build();
            // Here you can now start using the jda instance before its fully loaded,
            // this can be useful for stuff like creating background services or similar.

            // The queue(...) means that we are making a REST request to the discord API server!
            // Usually, this is done asynchronously on another thread which handles scheduling and rate-limits.
            // The (ping -> ...) is called a lambda expression, if you're unfamiliar with this syntax it is HIGHLY recommended to look it up!
            jda.getRestPing().queue(ping ->
                    // shows ping in milliseconds
                    System.out.println("Logged in with ping: " + ping)
            );

            // If you want to access the cache, you can use awaitReady() to block the main thread until the jda instance is fully loaded
            jda.awaitReady();

            // Now we can access the fully loaded cache and show some statistics or do other cache dependent things
            System.out.println("Guilds: " + jda.getGuildCache().size());

            // Get main guild
            guild = this.jda.getGuildById(GUILD_ID);
            playerLists = guild.getTextChannelById("1180784527291985952");
        } catch (InterruptedException e) {
            // Thrown if the awaitReady() call is interrupted
            e.printStackTrace();
        }
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        MessageChannelUnion channel = event.getChannel();
        Message message = event.getMessage();
        if (mainChannel != null && channel.getId().equals(mainChannel.getId())) {
            receiveMessageController.execute(message.getContentRaw());
        }
    }

    private void sendMessage(String content) {
        mainChannel.sendMessage(content).complete();
    }

    private TextChannel createChannel(String name) {
        return guild.createTextChannel(name).complete();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() instanceof SendMessageState state) {
            sendMessage(state.getLastMessage());
        } else if (evt.getNewValue() instanceof StartLobbyState state) {
            Message playerList = playerLists.sendMessage(":D").complete();
            mainChannel = createChannel(playerList.getId());
            playerLists.editMessageById(mainChannel.getName(), "lobby id: " + mainChannel.getId()).complete();

            hostEnterChooseNameController.execute(mainChannel.getId());
        } else if (evt.getNewValue() instanceof JoinLobbyState state) {
            boolean channelExists = false;

            try {
                mainChannel = guild.getTextChannelById(state.getLobbyID());
            } catch (Exception e) {
                // do nothing
            }

            if (mainChannel != null) {
                channelExists = true;
            }

            if (!channelExists) {
                joinEnterChooseNameController.execute("");
                return;
            }

            joinEnterChooseNameController.execute(state.getLobbyID());

            String playerList = playerLists.retrieveMessageById(mainChannel.getName()).complete().getContentRaw();
            String[] playerNamesArray = playerList.split("\\r?\\n");
            List<String> playerNamesList = new ArrayList<>(Arrays.asList(playerNamesArray)).subList(1, playerNamesArray.length);
            initializePlayersController.execute(playerNamesList);
        } else if (evt.getNewValue() instanceof AddMainPlayerState state) {
            String playerList = playerLists.retrieveMessageById(mainChannel.getName()).complete().getContentRaw();
            playerLists.editMessageById(mainChannel.getName(), playerList + "\n" + state.getPlayerName()).complete();
        }
    }
}
