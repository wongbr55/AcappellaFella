package app;

import interface_adapter.PlayerGuess.PlayerGuessViewModel;
import view.ChatView;
import view.PlayerGuessView;

public class PlayerGuessViewBuilder {
    private PlayerGuessViewBuilder() {
    }

    public static PlayerGuessView createView(ChatView chatView, PlayerGuessViewModel playerGuessViewModel) {
        return new PlayerGuessView(chatView, playerGuessViewModel);
    }

}
