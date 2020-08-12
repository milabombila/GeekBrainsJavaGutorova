
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {

    private DataInputStream in;
    private DataOutputStream out;
    private Socket socket;

    public Client() {
        open();
    }

    private void open() {
        try {
            socket = new Socket("127.0.0.1", 8888);
            System.out.println("Welcome to server: " + socket);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            if (socket.isClosed()) {
                                break;
                            }
                            String message = in.readUTF();
                            if (message.equalsIgnoreCase("/stop")) {
                                break;
                            }
                            System.out.println("Server: " + message);
                        } catch (IOException e) {
                            System.out.println("Server is closed");
                        }
                    }
                }
            })
                    .start();
        } catch (IOException e) {
            System.out.println("Server is down");
        }
    }

    public void SendMessage(String message){
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
