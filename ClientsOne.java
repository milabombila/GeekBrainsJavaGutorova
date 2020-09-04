import Archive.Archive;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class ClientsOne extends JFrame {
    private DataInputStream in;
    private DataOutputStream out;
    private JTextArea chatArea;
    private JTextField msgInputField;
    private Socket socket;
    private Archive log;
    private String nickname;

    public ClientsOne() {
        log = new Archive("D:\\Java\\Java-3\\Homework\\Gb-Java3-Homework-3\\Archive\\archiveClient1.txt");
        open();
        prepareGUI();
        loadMessages();
    }

    private void open() {
        try {
            socket = new Socket("localhost", 4566);
            System.out.println("Connected to server: " + socket);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        out.writeUTF("/auth l3 p3");
                        while (true) {
                            String message = in.readUTF();
                            if (message.startsWith("/authok")) {
                                String[] credentials = message.split("\\s");
                                nickname = credentials[1];
                                System.out.println("Authorized");
                                break;
                            }else {
                                System.out.println("Cannot get authorization");
                            }
                        }

                        while (true) {
                            String message = in.readUTF();
                            chatArea.append(message);
                            chatArea.append("\n");
                            try {
                                log.writeLog(String.format("\n %s: %s", nickname, message));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            if (message.equals("/end")) {
                                System.out.println("Session closed. Cau!");
                                break;
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            });
            thread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void prepareGUI() {

        setBounds(600, 300, 500, 500);
        setTitle("Chat1");
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
                sendMsg();
            }
        });

        setVisible(true);
    }

    private void loadMessages(){
        try {
            ArrayList<String> list = log.loadMessages(100);
            for (String s: list) {
                chatArea.append(s);
                chatArea.append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void sendMsg() {
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
