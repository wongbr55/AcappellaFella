package interface_adapter.ReceiveMessage;

import entity.Message;
import interface_adapter.Chat.ChatState;
import interface_adapter.Chat.ChatViewModel;
import use_case.ReceiveMessage.ReceiveMessageOutputBoundary;
import use_case.ReceiveMessage.ReceiveMessageOutputData;

import java.awt.*;

public class ReceiveMessagePresenter implements ReceiveMessageOutputBoundary {
    private final ChatViewModel chatViewModel;

    public ReceiveMessagePresenter(ChatViewModel chatViewModel) {
        this.chatViewModel = chatViewModel;
    }

    @Override
    public void prepareSuccessView(ReceiveMessageOutputData receiveMessageOutputData) {
        if (!receiveMessageOutputData.isShowMessage()) {
            // if not showing the message, do nothing
            return;
        }
        Message message = receiveMessageOutputData.getMessage();
        ChatState chatState = chatViewModel.getState();

        // format the message to html
        // todo finalize formatting

        Font font = new Font("Arial", Font.PLAIN, 4);

        String content = switch (message.getType()) {
            case ALL -> String.format("<font face = \\%s\\ size=\\%o\\>%s: %s</font><br>",
                    font.getFamily(),
                    font.getSize(),
                    message.getAuthor().getName(),
                    message.getContent());
            case SYSTEM -> String.format("<font face = \\%s\\ size=\\%o\\><b>%s</b></font><br>",
                    font.getFamily(),
                    font.getSize(),
                    message.getContent());
            case GUESSED -> String.format("<font face = \\%s\\ size=\\%o\\><i>%s: %s</i></font><br>",
                    font.getFamily(),
                    font.getSize(),
                    message.getAuthor().getName(),
                    message.getContent());
        };

        String chatHistory = chatState.getMessageHistory().concat(content);
        chatState.setMessageHistory(chatHistory);
        chatViewModel.setState(chatState);
        chatViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        // todo
    }
}
