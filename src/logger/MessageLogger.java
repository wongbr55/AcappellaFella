package logger;

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
import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicReference;

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
    private ReceiveMessageController receiveMessageController;
    private JDA jda;
    private Guild guild;
    private TextChannel channel;

    private MessageLogger(ReceiveMessageController receiveMessageController) {
        this.receiveMessageController = receiveMessageController;
    }

    public MessageLogger(SendMessageLoggerModel sendMessageLoggerModel, StartLobbyLoggerModel startLobbyLoggerModel, ReceiveMessageController receiveMessageController) {
        this.sendMessageLoggerModel = sendMessageLoggerModel;
        sendMessageLoggerModel.addPropertyChangeListener(this);
        this.startLobbyLoggerModel = startLobbyLoggerModel;
        startLobbyLoggerModel.addPropertyChangeListener(this);

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

            // Get main guild
            guild = this.jda.getGuildById(GUILD_ID);

            // Now we can access the fully loaded cache and show some statistics or do other cache dependent things
            System.out.println("Guilds: " + jda.getGuildCache().size());
        } catch (InterruptedException e) {
            // Thrown if the awaitReady() call is interrupted
            e.printStackTrace();
        }
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        MessageChannelUnion channel = event.getChannel();
        Message message = event.getMessage();

        if (channel.getId().equals(channel.getId())) {
            receiveMessageController.execute(message.getContentRaw());
        }
    }

    private void sendMessage(String content) {
        channel.sendMessage(content).queue();
    }

    public String createChannel() {
        TextChannel textChannel = guild.createTextChannel("lobby").complete();
        return textChannel.getId();
    }

    public void setChannel(String id) {
        channel = guild.getTextChannelById(id);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() instanceof SendMessageState state) {
            sendMessage(state.getLastMessage());
        } else if (evt.getNewValue() instanceof StartLobbyState state) {
            String lobbyID = createChannel();
            // todo call some presenter and propagate the id back into the interactor layer
        }
    }
}
