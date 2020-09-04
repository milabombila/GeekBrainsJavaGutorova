package GeekBrains;

public class PrintLetter implements Runnable {

    private char letter;
    private char nextLetter;
    private Paper paper;


    public PrintLetter(char letter, char previousLetter, Paper paper) {
        this.letter = letter;
        this.nextLetter = previousLetter;
        this.paper = paper;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            paper.print(letter, nextLetter);
        }
    }

}
