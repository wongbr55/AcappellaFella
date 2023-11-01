package view;

import interface_adapter.Chat.ChatState;
import interface_adapter.Chat.ChatViewModel;
import interface_adapter.SendMessage.SendMessageController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ChatView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "logger";
    public ChatViewModel chatViewModel;
    private final SendMessageController sendMessageController;
    private final JTextField messageInputField;
    private final JTextArea pastMessages;
    private final JButton send;

    public ChatView(ChatViewModel chatViewModel, SendMessageController sendMessageController) {
        this.chatViewModel = chatViewModel;
        this.sendMessageController = sendMessageController;
        chatViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(ChatViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        messageInputField = new JTextField(ChatViewModel.TYPE_LABEL, 15);
        send = new JButton(ChatViewModel.SEND_BUTTON_LABEL);
        // Create a JTextArea for displaying past messages
        pastMessages = new JTextArea(20, 15);
        pastMessages.setOpaque(false); // Make it transparent
        pastMessages.setEditable(false); // Make it non-editable
        pastMessages.setLineWrap(true); // Enable word wrap
        pastMessages.setWrapStyleWord(true); // Wrap text at word boundaries

        // Add the JTextArea to a JScrollPane for scrolling
        JScrollPane scrollMessages = new JScrollPane(pastMessages);

        JPanel messageField = new JPanel();
        messageField.add(messageInputField);
        messageField.add(send);

        JPanel chat = new JPanel();
        chat.setLayout(new BoxLayout(chat, BoxLayout.Y_AXIS));
        chat.add(scrollMessages);
        chat.add(messageField);

        // todo add event actions
        // Add a FocusListener to make it editable when focused
        messageInputField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                ChatState currentState = chatViewModel.getState();
                messageInputField.setText(currentState.getTypingContent());
            }

            @Override
            public void focusLost(FocusEvent e) {
                ChatState currentState = chatViewModel.getState();
                if (currentState.getTypingContent().isEmpty()) {
                    messageInputField.setText(ChatViewModel.TYPE_LABEL);
                }
            }
        });

        messageInputField.addKeyListener(
            new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                    if (e.getKeyChar() == '\n') {
                        ChatState currentState = chatViewModel.getState();
                        sendMessageController.execute(currentState.getTypingContent());
                        // clear the messageField after sending the message
                        currentState.setTypingContent("");
                        chatViewModel.setState(currentState);
                        messageInputField.setText("");
                    }
                }

                @Override
                public void keyPressed(KeyEvent e) {

                }

                @Override
                public void keyReleased(KeyEvent e) {
                    ChatState currentState = chatViewModel.getState();
                    currentState.setTypingContent(messageInputField.getText());
                    chatViewModel.setState(currentState);
                }
            }
        );

        send.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    if (evt.getSource().equals(send)) {
                        ChatState currentState = chatViewModel.getState();
                        sendMessageController.execute(currentState.getTypingContent());
                        // clear the messageField after sending the message
                        currentState.setTypingContent("");
                        chatViewModel.setState(currentState);
                        messageInputField.setText(ChatViewModel.TYPE_LABEL);
                    }
                }
            }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.add(chat);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() instanceof ChatState) {
            ChatState state = (ChatState) evt.getNewValue();
            pastMessages.setText(state.getMessageHistory());
        }
    }
}
