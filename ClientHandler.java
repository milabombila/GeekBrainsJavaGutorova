import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Objects;

public class ClientHandler extends JFrame {
    private Users record;
    private Server server;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;


    public ClientHandler(Server server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        doAuth();
                        readMessage();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        closeConnection();
                    }
                }
            })
                    .start();

        } catch (IOException e) {
            throw new RuntimeException("Client handler was not created");
        }
    }


    public void doAuth() throws IOException {
        while (true) {
            System.out.println("Waiting for auth...");
            String message = in.readUTF();
            if (message.startsWith("/auth")) {
                String[] credentials = message.split("\\s");
                Users possibleUser = DbAuthService.findUser(credentials[1], credentials[2]);
                if (possibleUser != null) {
                    if (!server.isOccupied(possibleUser)) {
                        record = possibleUser;
                        sendMessage("/authok ");
                        server.broadcastMessage("Logged-in " + record.getNickname());
                        server.subscribe(this);
                        break;
                    }
                }
            } else {
                sendMessage(String.format("User no found"));
            }
        }
    }

    public Users getRecord() {
        return record;
    }

//    public void doAuth() throws IOException {
//        while (true) {
//            System.out.println("Waiting for auth...");
//            String message = in.readUTF();
//            if (message.startsWith("/auth")) {
//                String[] credentials = message.split("\\s");
//                AuthService.Record possibleRecord = server.getAuthService().findRecord(credentials[1], credentials[2]);
//                if (possibleRecord != null) {
//                    if (!server.isOccupied(possibleRecord)) {
//                        record = possibleRecord;
//                        sendMessage("/authok " + record.getName());
//                        server.broadcastMessage("Logged-in " + record.getName());
//                        server.subscribe(this);
//                        break;
//                    } else {
//                        sendMessage(String.format("Current user [%s] is already occupied", possibleRecord.getName()));
//                    }
//                } else {
//                    sendMessage(String.format("User no found"));
//                }
//            }
//        }
//    }

    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readMessage() throws IOException {
        while (true) {
            String message = in.readUTF();
            System.out.println(String.format("Incoming message from : %s", record.getNickname(), message));
            if (message.equals("/end")) {
                return;
            }
            server.broadcastMessage(String.format("%s: %s", record.getNickname(), message));
        }
    }


    public void closeConnection() {
        server.unsubscribe(this);
        server.broadcastMessage(record.getNickname() + " left chat");
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientHandler that = (ClientHandler) o;
        return record.equals(that.record) &&
                server.equals(that.server) &&
                socket.equals(that.socket) &&
                in.equals(that.in) &&
                out.equals(that.out);
    }


    @Override
    public int hashCode() {
        return Objects.hash(record, server, socket, in, out);
    }
}
