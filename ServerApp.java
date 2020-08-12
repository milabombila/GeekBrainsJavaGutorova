import java.util.Scanner;

public class ServerApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Server serv = new Server();
        do {
            String text = scan.nextLine();
            serv.SendMessage(text);
            if (text.equalsIgnoreCase("/stop")) {
                break;
            }
            scan.reset();
        } while (true);
    }
}
