package com.company;

import java.lang.reflect.Array;

public class Main {

    public static void main(String[] args) {
        checkArray1();
        checkArray2();
    }

    public static void checkArray1() {
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время выполнения 1 метода: " + (System.currentTimeMillis() - a));
    }
    public static void checkArray2() {
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        float[] a1 = new float[h];
        float[] a2 = new float[h];

        new Thread(new Runnable() {
            @Override
            public void run() {
                long a = System.currentTimeMillis();
                for (int i = 0; i < a1.length; i++) {
                    a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                long b = System.currentTimeMillis();
                System.arraycopy(a1, 0, a1, 0, h);
                System.out.println("Время выполнения 2 метода: " + (System.currentTimeMillis() - a));
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                long a = System.currentTimeMillis();
                for (int i = 0; i < a2.length; i++) {
                    a2[i] = (float) (a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                long b = System.currentTimeMillis();
                System.arraycopy(a2, 0, a2, 0, h);
                System.out.println(System.currentTimeMillis() - a);
            }

        });


        System.arraycopy(a2, 0, arr, h, h);

    }
}


