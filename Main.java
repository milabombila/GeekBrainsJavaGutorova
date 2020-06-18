package geekbrains;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

//  System.out.println(Arrays.toString(arr));
public class Main {


    public static void main(String[] args) {
        int[] changeOneToZero = new int[]{1, 1, 1, 0, 0, 0};
        for (int i = 0; i < changeOneToZero.length; i++) {
            if (changeOneToZero[i] == 0) {
                changeOneToZero[i] = 1;
            } else {
                changeOneToZero[i] = 0;
            }
        }
        System.out.println(Arrays.toString(changeOneToZero));

        int[] putTheNumbers = new int[8];
        for (int i = 0; i < putTheNumbers.length; i++) {
            putTheNumbers[i] = i * 3;
            System.out.println(Arrays.toString(putTheNumbers));
        }

        int[] checkTheNumbers = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < checkTheNumbers.length; i++) {
            if (checkTheNumbers[i] < 6) {
                checkTheNumbers[i] = checkTheNumbers[i] * 2;
            } else {
                checkTheNumbers[i] = checkTheNumbers[i];
            }
            System.out.println(Arrays.toString(checkTheNumbers));
        }
        int[][] matrix = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == matrix[0][0]) {
                    matrix[i][j] = 1;
                } else if (matrix[i][j] == matrix[0][2]) {
                    matrix[i][j] = 1;
                } else if (matrix[i][j] == matrix[1][1]) {
                    matrix[i][j] = 1;
                } else if (matrix[i][j] == matrix[2][0]) {
                    matrix[i][j] = 1;
                } else if (matrix[i][j] == matrix[2][2]) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = matrix[i][j];
                }
            }
        }
        System.out.println(matrix[0][0]);
        System.out.println(matrix[1][1]);
        System.out.println(matrix[0][2]);
        System.out.println(matrix[2][0]);
        System.out.println(matrix[2][2]);

        int[] methodFindMaxAndMin = new int[]{1,90,4};
        int max = 0;
        int min = 0;
            if (methodFindMaxAndMin[0] < methodFindMaxAndMin[1]) {
                    max = methodFindMaxAndMin[1];
                    min = methodFindMaxAndMin[0];
            } else if (methodFindMaxAndMin[0] < methodFindMaxAndMin[2]) {
                max = methodFindMaxAndMin[1];
                min = methodFindMaxAndMin[0];
            } else if (methodFindMaxAndMin[1] < methodFindMaxAndMin[2]){
                min = methodFindMaxAndMin[1];
            }
            System.out.println(max);
            System.out.println(min);
        }

    }

