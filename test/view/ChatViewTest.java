package view;

import interface_adapter.Chat.ChatViewModel;
import interface_adapter.CheckGuess.CheckGuessController;
import org.junit.Before;
import org.junit.Test;
import use_case.CheckGuess.CheckGuessInputBoundary;
import use_case.CheckGuess.CheckGuessInputData;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static org.junit.Assert.*;

public class ChatViewTest {

    private ChatView chatView;
    private ChatViewModel chatViewModel;
    @Before
    public void setUp() {
        CheckGuessInputBoundary checkGuessInputBoundary = new CheckGuessInputBoundary() {
            @Override
            public void execute(CheckGuessInputData checkGuessInputData) {

            }
        };
        CheckGuessController checkGuessController = new CheckGuessController(checkGuessInputBoundary);
        chatViewModel = new ChatViewModel();
        chatView = new ChatView(chatViewModel, checkGuessController);
    }

    @Test
    public void actionPerformed() {
    }

    @Test
    public void propertyChange() {

        chatViewModel.getState().setMessageHistory("Hi");
        chatViewModel.firePropertyChanged();

        for (KeyListener key: chatView.getMessageInputField().getKeyListeners()){
            key.keyTyped(new KeyEvent(chatView.getSend(), 1, 20, Event.SHIFT_MASK, 10, '\n'));
            key.keyReleased(new KeyEvent(chatView.getSend(), 1, 20, Event.SHIFT_MASK, 10, 'a'));
        }

        for (FocusListener focusListener: chatView.getMessageInputField().getFocusListeners()){
            focusListener.focusGained(new FocusEvent(chatView.getMessageInputField(), 1));
            focusListener.focusLost(new FocusEvent(chatView.getMessageInputField(), 1));
        }

        chatView.getSend().doClick();
    }
}