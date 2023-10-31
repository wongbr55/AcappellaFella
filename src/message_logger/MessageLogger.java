package message_logger;
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

import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicReference;

public class MessageLogger extends ListenerAdapter {
    final private String TOKEN = System.getenv("DISCORD_TOKEN");
    final private String GUILD_ID = "1168619453492236421";
    final private EnumSet<GatewayIntent> intents = EnumSet.of(
            // Enables MessageReceivedEvent for guild (also known as servers)
            GatewayIntent.GUILD_MESSAGES,
            // Enables access to message.getContentRaw()
            GatewayIntent.MESSAGE_CONTENT
    );
    private JDA jda;
    private Guild guild;
    private TextChannel channel;

    public static void main(String[] args) {
        MessageLogger logger = new MessageLogger();
    }

    public MessageLogger() {
        try
        {
            // By using createLight(token, intents), we use a minimalistic cache profile (lower ram usage)
            // and only enable the provided set of intents. All other intents are disabled, so you won't receive events for those.
            this.jda = JDABuilder.createLight(TOKEN, intents)
                    // On this builder, you are adding all your event listeners and session configuration
                    .addEventListeners(new MessageLogger())
                    // Once you're done configuring your jda instance, call build to start and login the bot.
                    .build();
            // get main guild
            guild = this.jda.getGuildById(GUILD_ID);
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
        }
        catch (InterruptedException e)
        {
            // Thrown if the awaitReady() call is interrupted
            e.printStackTrace();
        }
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        MessageChannelUnion channel = event.getChannel();
        Message message = event.getMessage();

        if (channel.getId().equals(channel.getId())) {
            System.out.println(message.getContentRaw());
        }
    }

    public void sendMessage(String content) {
        channel.sendMessage(content).queue();
    }

    public String createChannel(String name) {
        // literally no idea what this does lol
        AtomicReference<String> res = new AtomicReference<>("");
        guild.createTextChannel(name).queue(channel -> {
            res.set(channel.getId());
        });
        return res.get();
    }

    public void setChannel(String id) {
        channel = guild.getTextChannelById(id);
    }
}
