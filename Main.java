package GeekBrains;

public class Main {

    public static void main(String[] args) {
        Paper paper = new Paper();
        PrintLetter a = new PrintLetter('A', 'B', paper);
        PrintLetter b = new PrintLetter('B', 'C', paper);
        PrintLetter c = new PrintLetter('C', 'A', paper);

        new Thread(a).start();
        new Thread(b).start();
        new Thread(c).start();
    }
}

