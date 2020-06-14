package osnovy.programmirovaniya;

import java.io.InputStream;

public class Main {

    public static void main(String[] args) {
        byte k = 8;
        short l = 16;
        int m = 32;
        long n = 64;
        float o = (float) 32.1;
        double p = 64.0000002;
        char q = 'e';
        boolean r = false;
        checkTheNumber(5,13);
        IsPositive(-10);
    }
//public class result {
//Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
//где a, b, c, d – аргументы этого метода, имеющие тип float.

            public static float methodFindE(float a1, float b1, float c1, float d1, float e1) {
                a1 = (float) 1.0;
                b1 = (float) 2.0;
                c1 = (float) 3.0;
                d1 = (float) 4.0;
                return e1 = a1 * (b1 + (c1 / d1));
            }

            //Написать метод, принимающий на вход два целых числа и проверяющий,
            // что их сумма лежит в пределах от 10 до 20 (включительно),
            // если да – вернуть true, в противном случае – false.
            public static boolean checkTheNumber(int a2, int b2){
            int c2 = a2 + b2;
            if (10 <= c2 && c2 <= 20) {
                return true;
            } else {
                return false;
            }
        }
//Написать метод, которому в качестве параметра передается целое число,
//метод должен напечатать в консоль,
//положительное ли число передали или отрицательное.
//Замечание: ноль считаем положительным числом.
            public static void IsPositive(int a3) {
                    if (a3 <=0) {
                        System.out.println( a3 + " is negative");
                    } else {
                        System.out.println( a3 + " is positive");
                    }
        }
        // Написать метод, которому в качестве параметра передается целое число.
    // Метод должен вернуть true, если число отрицательное.
    public static boolean isNegative (int a4) {
        if (a4 <= 0) {
            return true;
        } else {
            return false;
        }
        }
        //Написать метод, которому в качестве параметра передается строка, обозначающая имя.
    // Метод должен вывести в консоль сообщение «Привет, указанное_имя!»
    public static void greeting (String your_name){
        System.out.println("Привет, " + your_name);
    }


    //*Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
    // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
        /*  передать вводимое из консоли число
        поделить на четыре - исключить каждый 100 кроме 400
         */
    public static void isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 && year % 400 == 0) {
            System.out.println("Год високосный");
        } else {
            System.out.println("Год не високосный");
        }
    }
    }
