package geekbrains;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки
        // угадать это число. При каждой попытке компьютер должен сообщить,
        // больше ли указанное пользователем число, чем загаданное, или меньше.
        // После победы или проигрыша выводится запрос
        // – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).

    }

    public static void playTheGame() {
        int playAgain;
        do {
            int min = -10;
            int max = 10;
            int x = (int) (Math.random() * (max - min) + min);
            int c = 3;
            System.out.println(x);
            System.out.println("Try to guess the number x. Hint № 1: -10 < x < 10. You have three try");
            int a = scanner.nextInt();
            for (int b = 0; c > b; b++)
                if (a < x) {
                    System.out.println("Nope. Try one more time. Hint № 2: x bigger than your number");
                    a = scanner.nextInt();
                } else if (a > x) {
                    System.out.println("Nope. Try one more time. Hint № 2: x less than your number");
                    a = scanner.nextInt();
                } else {
                    System.out.println("Yep. You are right!");
                    break;
                }
            System.out.println("Sorry =(");
            System.out.println("Do you wanna play again? 1 – yes / 0 – no");
            playAgain = scanner.nextInt();
        } while (playAgain == 1);
    }
}

