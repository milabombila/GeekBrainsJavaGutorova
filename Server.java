import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    DataInputStream in;
    DataOutputStream out;

    public Server() {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("Server is running on 8888");

            Socket client = serverSocket.accept();
            System.out.println(client);
            System.out.println(String.format("Client connected: %s", client.getLocalSocketAddress()));

            in = new DataInputStream(client.getInputStream());
            out = new DataOutputStream(client.getOutputStream());
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        String message = null;
                        try {
                            if (client.isClosed()) {
                                break;
                            }
                            message = in.readUTF();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (message.equalsIgnoreCase("/stop")) {
                            break;
                        }
                        System.out.println("Client: " + message);
                    }
                }
            })
                    .start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
