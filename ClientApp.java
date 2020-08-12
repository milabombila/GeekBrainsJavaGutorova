import java.util.Scanner;

public class ClientApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Client client = new Client();
        do {
            String text = scan.nextLine();
            client.SendMessage(text);
            if (text.equalsIgnoreCase("/stop")) {
                break;
            }
            scan.reset();
        } while (true);

    }
}
