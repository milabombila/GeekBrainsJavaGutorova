import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatRoom extends JFrame {
    public ChatRoom(String title) {
        setTitle(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(0, 0, 600, 500);

        JPanel chatPanel = new JPanel(new BorderLayout());
        JTextArea charTextArea = new JTextArea();
        charTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(charTextArea);
        chatPanel.add(scrollPane);

        add(chatPanel);

        JPanel controlPanel = new JPanel(new BorderLayout());

        JTextField inputField = new JTextField();
        inputField.addActionListener(new ActionListener() {
            private StringBuilder sb = new StringBuilder();

            @Override
            public void actionPerformed(ActionEvent e) {
                if (inputField.getText().isBlank()) {
                    return;
                }
                sb.append(charTextArea.getText());
                sb.append("\n")
                        .append(inputField.getText());
                charTextArea.setText(sb.toString());
                inputField.setText("");
                sb.setLength(0);
            }
        });
        controlPanel.add(inputField);

        JButton clearBtn = new JButton("Clear");
        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                charTextArea.setText("");
            }
        });
        controlPanel.add(clearBtn, BorderLayout.WEST);

        JButton submitBtn = new JButton("Submit");
        submitBtn.addActionListener(new SubmitButtonListener(inputField, charTextArea));
        controlPanel.add(submitBtn, BorderLayout.EAST);

        add(controlPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
