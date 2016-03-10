package com.javarush.test.level07.lesson04.task04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxNumInArray {
    static int[] arrayInit = new int[2];

    public static void main(String[] args) throws IOException {
        initializeArray();
        for (int i : arrayInit){
            System.out.println(" Then num is: " + i);
        }
    }

    public static void initializeArray() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 2; i++) {
            String line = reader.readLine();
            arrayInit[i] = Integer.parseInt(line);
        }

    }
}
