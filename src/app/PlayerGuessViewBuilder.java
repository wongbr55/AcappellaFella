package app;

import interface_adapter.PlayerGuess.PlayerGuessViewModel;
import view.ChatView;
import view.PlayerGuessView;
import view.ScoreboardView;

public class PlayerGuessViewBuilder {
    private PlayerGuessViewBuilder() {
    }

    public static PlayerGuessView createView(ScoreboardView scoreboardView, ChatView chatView, PlayerGuessViewModel playerGuessViewModel) {
        return new PlayerGuessView(scoreboardView, chatView, playerGuessViewModel);
    }

}
