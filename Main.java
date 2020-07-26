package geekbrains;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[][] array = new String[][] {
                {"4","4","4","4"},
                {"4","4","4","4"},
                {"4","4","4","4"},
                {"4","4","4","b"}
        };
        try {
            changeTheArray(array);
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }

    }

    static void createTheArray(int a) {
        String[][] newArray = new String[a][a];
    }

    static void checkTheArray(String[][] array)  {
        int a = array.length;
        int b = array[0].length;
        if (a != b && a != 4) {
            throw new MyArrayException("Invalid size");
        }
    }

    static void changeTheArray(String[][] array) throws MyArrayDataException {
        int sumOfArray = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                try {
                    Integer i2 = Integer.valueOf(array[i][j]);
                    sumOfArray += i2;
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException("Incorrect data format in " + (j + 1) + " string " + (i + 1) + " colon");
                }
            }
        }
        System.out.println("Summ is " + sumOfArray);
    }
}