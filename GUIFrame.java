import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIFrame extends JFrame {
    public GUIFrame() {
        setTitle("Calc");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 500);

        GridLayout gridLayout = new GridLayout(4, 4);
        setLayout(gridLayout);

        JTextField textField = new JTextField();
        add(textField);
        ButtonListener buttonListener = new ButtonListener(textField);

        for (int i = 1; i <= 9; i++) {
            JButton jButton = new JButton(String.valueOf(i));
            jButton.addActionListener(buttonListener);
            add(jButton);
        }

        JButton pushButton = new JButton("Enter");
        pushButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
               String[] splitted = text.split( " \\+ ");
                int val = 0;
                for (int i = 0; i < splitted.length; i++) {
                    int digit = Integer.parseInt(splitted[i]);

                    val += digit;
                }

                try {
                    textField.setText(Calculation.Evaluate(textField.getText()));
                } catch (ScriptException scriptException) {
                    scriptException.printStackTrace();
                }
            }

        });
        JButton increaseButton = new JButton(" + ");
        increaseButton.addActionListener(buttonListener);
        JButton decreaseButton = new JButton(" - ");
        decreaseButton.addActionListener(buttonListener);
        JButton multiButton = new JButton(" * ");
        multiButton.addActionListener(buttonListener);
        JButton divisionButton = new JButton(" / ");
        divisionButton.addActionListener(buttonListener);
        JButton resetButton = new JButton (" Reset ");
        resetButton.addActionListener(buttonListener);


        add(pushButton);
        add(increaseButton);
        add(decreaseButton);
        add(multiButton);
        add(divisionButton);
        add(resetButton);

        setVisible(true);
    }
}
