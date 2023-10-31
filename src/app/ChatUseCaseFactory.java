package app;

import interface_adapter.Chat.ChatViewModel;
import interface_adapter.SingerChoose.SingerChooseViewModel;
import interface_adapter.ViewManagerModel;
import view.ChatView;

public class ChatUseCaseFactory {
    public static ChatView create(ChatViewModel chatViewModel) {
        return new ChatView(chatViewModel);
    }
}
