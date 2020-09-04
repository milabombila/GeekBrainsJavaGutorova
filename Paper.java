package GeekBrains;


public class Paper {
    private volatile char test = 'A';


    public synchronized void print(char letter, char nextLetter) {

        try {
            while (test != letter){
                wait();
            }
            System.out.println(letter);
            test = nextLetter;
            notifyAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
