import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    private final JTextField textField;
    private final StringBuilder sb = new StringBuilder();

    public ButtonListener(JTextField textField) {
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton currentButton = (JButton) e.getSource();

        sb.append(textField.getText());
//        if (!textField.getText().isBlank()) {
//            sb.append(" + ");
//        }
        sb.append(currentButton.getText());

        this.textField.setText(sb.toString());

        sb.setLength(0);

        System.out.println("Pushed the button...");
    }
}
