package view;

import interface_adapter.Chat.ChatViewModel;
import interface_adapter.CheckGuess.CheckGuessController;
import interface_adapter.PlayerGuess.PlayerGuessViewModel;
import interface_adapter.Scoreboard.ScoreboardViewModel;
import org.junit.Before;
import org.junit.Test;
import use_case.CheckGuess.CheckGuessInputBoundary;
import use_case.CheckGuess.CheckGuessInputData;

import static org.junit.Assert.*;

public class PlayerGuessViewTest {

    private PlayerGuessView playerGuessView;
    private PlayerGuessViewModel playerGuessViewModel;
    @Before
    public void setUp() {
        ScoreboardView scoreboardView = new ScoreboardView(new ScoreboardViewModel());
        CheckGuessInputBoundary checkGuessInputBoundary = new CheckGuessInputBoundary() {
            @Override
            public void execute(CheckGuessInputData checkGuessInputData) {

            }
        };
        CheckGuessController checkGuessController = new CheckGuessController(checkGuessInputBoundary);
        ChatView chatView = new ChatView(new ChatViewModel(), checkGuessController);

        playerGuessViewModel = new PlayerGuessViewModel();
        playerGuessView = new PlayerGuessView(scoreboardView, chatView, playerGuessViewModel);
    }

    @Test
    public void propertyChange() {

        playerGuessViewModel.firePropertyChanged();
    }
}