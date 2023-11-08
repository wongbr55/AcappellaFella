package app;

import interface_adapter.CheckGuess.CheckGuessViewModel;
import view.ChatView;
import view.PlayerGuessView;

public class PlayerGuessViewBuilder {
    private PlayerGuessViewBuilder() {
    }

    public static PlayerGuessView createView(ChatView chatView, CheckGuessViewModel checkGuessViewModel) {
        return new PlayerGuessView(chatView, checkGuessViewModel);
    }

}
