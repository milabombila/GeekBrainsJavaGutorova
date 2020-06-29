package geekbrains;
import java.util.Random;
import java.util.Scanner;
public class Main {

        public static void main(String[] args) {
            playGame();
        }
        static void playGame() {
            System.out.println("Hello!");
            System.out.println("There is the TicTacToe game!");
            System.out.println("===============");

            int fieldSize = 3;
            char[][] field;

            Scanner scanner = new Scanner(System.in);
            boolean isProceed;
            boolean isWin;
            char playerSign = 'X';
            char computerSign = 'O';
            char currentPlayer;

            do {
                field = getField(fieldSize);
                drawField(field);

                currentPlayer = playerSign;
                boolean isDraw;

                do {
                    doMove(field, fieldSize, currentPlayer);
                    isWin = checkWin(field, fieldSize, currentPlayer);

                    System.out.println("Updating...");
                    System.out.println("===============");
                    drawField(field);
                    if (isWin) break;

                    currentPlayer = changePlayer(currentPlayer);
                    isDraw = isDraw(field);
                } while (!isDraw);

                String winnerName = currentPlayer == 'X' ? "Player" : "Computer";
                System.out.println(String.format("Congratulations, [%s] are winner", winnerName));

                System.out.println("Do you to proceed?");
                isProceed = scanner.nextBoolean();
            } while (isProceed);
        }

        static boolean isDraw(char[][] field) {
            int count = field.length*3;
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    if (field[i][j] != '-') {
                        count--;
                    }
                }
            }
            return count == 0;
        }

        static void drawField(char[][] field) {
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    System.out.print(field[i][j]);
                }
                System.out.print("\n");
            }
        }

        static char[][] getField(int size) {
            char[][] field = new char[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    field[i][j] = '-';
                }
            }
            return field;
        }

        static char changePlayer(char sign) {

            return sign == 'X' ? 'O' : 'X';
        }

        static void doMove(char[][] field, int fieldSize, char sign) {
            int x, y;
            if (sign == 'X') {
                Scanner scanner = new Scanner(System.in);
                System.out.println(String.format("Please write down X-Axis value from 1 to %s", fieldSize));
                x = scanner.nextInt();
                System.out.println(String.format("Please write down Y-Axis value from 1 to %s", fieldSize));
                y = scanner.nextInt();

                x = checkCoordinate(x, fieldSize);
                y = checkCoordinate(y, fieldSize);

                putValueByCoordinates(field, x, y, fieldSize, sign);
            } else {
                Random random = new Random();
                x = random.nextInt(fieldSize);
                y = random.nextInt(fieldSize);
                putValueByCoordinates(field, x, y, fieldSize, sign);
            }
        }

        static boolean checkWin(char[][] field, int fieldSize, char sign) {
            int check = 0;
            for (int j = 0; j < fieldSize; j++) {
                if(field[j][j] == sign){
                    check++;
                }
            }
            if (check == 3){
                return true;
            }
            check = 0;
            for (int j = 0; j < fieldSize; j++) {
                if(field[j][fieldSize-j-1] == sign){
                    check++;
                }
            }
            if (check == 3){
                return true;
            }
            check = 0;
            for (int i = 0; i < fieldSize; i++) {

                for (int j = 0; j < fieldSize; j++) {
                    if(field[i][j] == sign){
                        check++;
                    }
                }
                if (check == 3){
                    return true;
                }
                check = 0;
                for (int j = 0; j < fieldSize; j++) {
                    if(field[j][i] == sign){
                        check++;
                    }
                }
                if (check == 3){
                    return true;
                }
                check = 0;
            }

            return false;
        }

        static int checkCoordinate(int coordinate, int fieldSize) {
            while (coordinate < 1 || coordinate > fieldSize) {
                System.out.println(String.format("[X|Y]-Axis: %s is incorrect. Correct range from 1 to %s", coordinate, fieldSize));
                coordinate = reInputCoordinate(fieldSize);
            }
            return coordinate;
        }

        static int reInputCoordinate(int fieldSize) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(String.format("Please write down [X|Y]-Axis value from 1 to %s", fieldSize));
            return scanner.nextInt();
        }

        static void putValueByCoordinates(char[][] field, int x, int y, int fieldSize, char sign) {
            if (sign == 'X') {
                putValueAsPlayer(field, x, y, fieldSize);
            } else {
                putValueAsComputer(field, x, y, fieldSize);
            }
        }

        static void putValueAsComputer(char[][] field, int x, int y, int fieldSize) {
            Random random = new Random();
            while (field[x][y] != '-') {
                x = random.nextInt(fieldSize);
                y = random.nextInt(fieldSize);
            }
            System.out.println(String.format("Computer puts value to [x: %s, y:%s]", x, y));
            field[x][y] = 'O';
        }

        static void putValueAsPlayer(char[][] field, int x, int y, int fieldSize) {
            while (field[x - 1][y - 1] != '-') {
                System.out.println(String.format("X-Axis: %s, Y-Axis: %s already occupied", x, y));
                x = reInputCoordinate(fieldSize);
                x = checkCoordinate(x, fieldSize);

                y = reInputCoordinate(fieldSize);
                y = checkCoordinate(y, fieldSize);
            }
            System.out.println(String.format("Putting value to [x: %s, y:%s]", x, y));
            field[x - 1][y - 1] = 'X';
        }
        static boolean CheckWin(char[][] field, int fieldSize, char sign){
            int check = 0;
            for (int j = 0; j < fieldSize; j++) {
                if(field[j][j] == sign){
                    check++;
                }
            }
            if (check == 4){
                return true;
            }
            check = 0;
            for (int j = 0; j < fieldSize-1; j++) {
                if(field[j+1][j] == sign){
                    check++;
                }
            }
            if (check == 4){
                return true;
            }
            check = 0;
            for (int j = 1; j < fieldSize; j++) {
                if(field[j-1][j] == sign){
                    check++;
                }
            }
            if (check == 4){
                return true;
            }
            check = 0;
            for (int j = 0; j < fieldSize; j++) {
                if(field[j][fieldSize-j-1] == sign){
                    check++;
                }
            }
            if (check == 4){
                return true;
            }
            check = 0;
            for (int j = 0; j < fieldSize-1; j++) {
                if(field[j][fieldSize-j] == sign){
                    check++;
                }
            }
            if (check == 4){
                return true;
            }
            check = 0;
            for (int j = 1; j < fieldSize; j++) {
                if(field[j][fieldSize-j-2] == sign){
                    check++;
                }
            }
            if (check == 4){
                return true;
            }
            check = 0;
            for (int i = 0; i < fieldSize; i++) {
                for (int j = 0; j < fieldSize; j++) {
                    if(field[i][j] == sign){
                        check++;
                    }
                }
                if (check == 4){
                    return true;
                }
                check = 0;
                for (int j = 1; j < fieldSize; j++) {
                    if(field[i][j] == sign){
                        check++;
                    }
                }
                if (check == 4){
                    return true;
                }
                check = 0;
                for (int j = 0; j < fieldSize; j++) {
                    if(field[j][i] == sign){
                        check++;
                    }
                }
                if (check == 4){
                    return true;
                }
                check = 0;
                for (int j = 1; j < fieldSize; j++) {
                    if(field[j][i] == sign){
                        check++;
                    }
                }
                if (check == 4){
                    return true;
                }
                check = 0;
            }

            return false;
        }
    }


