package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.zip.CheckedInputStream;

public class Main {

    public static void main(String[] args) {
//        1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
        Object[] newOne = new Object[]{new Object(), new Object(), new Object()};
        for (int i = 0; i < newOne.length; i++) {
            System.out.println(newOne[i]);
        }
        ChangeArray(newOne, 1, 2);
        for (int i = 0; i < newOne.length; i++) {
            System.out.println(newOne[i]);
        }

    }

    //    2. Написать метод, который преобразует массив в ArrayList
    private static ArrayList EvaluateArray(Object[] mySecondArray) {
        ArrayList myArrayList = new ArrayList();
        for (int i = 0; i < mySecondArray.length; i++) {
            myArrayList.add(mySecondArray[i]);
        }
        return myArrayList;
    }

    public static void ChangeArray(Object [] nazvanie, int a, int b) {
        Object temp = nazvanie[a];
        nazvanie[a] = nazvanie[b];
        nazvanie[b] = temp;

    }
}
