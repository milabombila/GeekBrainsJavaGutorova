import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientOne extends JFrame {
    private DataInputStream in;
    private DataOutputStream out;
    private JTextArea chatArea;
    private JTextField msgInputField;
    private Socket socket;

    public ClientOne() {
        open();
        prepareGUI();
    }
    public void open() {
        try {
            socket = new Socket("localhost", Server.PORT);
            System.out.println("Connected to server: " + socket);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        out.writeUTF("/auth l1 p1");
                        while (true) {
                            String message = in.readUTF();
                            if (message.startsWith("/authok")) {
                                System.out.println("Authorized");
                                break;
                            }
                        }

                        while (true) {
                            String message = in.readUTF();
                            chatArea.append(in.readUTF());
                            chatArea.append("\n");
                            if (message.equals("/end")) {
                                System.out.println("Session closed. Cau!");
                                break;
                            }
                            System.out.println(message);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            });thread.start();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
    public void prepareGUI() {

        setBounds(600, 300, 500, 500);
        setTitle("Клиент");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        add(new JScrollPane(chatArea), BorderLayout.CENTER);


        JPanel bottomPanel = new JPanel(new BorderLayout());
        JButton btnSendMsg = new JButton("Отправить");
        bottomPanel.add(btnSendMsg, BorderLayout.EAST);
        msgInputField = new JTextField();
        add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.add(msgInputField, BorderLayout.CENTER);
        btnSendMsg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMes();
            }
        });

        setVisible(true);
    }
    public void sendMes() {
        if (!msgInputField.getText().trim().isEmpty()) {
            try {
                out.writeUTF(msgInputField.getText());
                msgInputField.setText("");
                msgInputField.grabFocus();
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Ошибка отправки сообщения");
            }
        }
    }
}
