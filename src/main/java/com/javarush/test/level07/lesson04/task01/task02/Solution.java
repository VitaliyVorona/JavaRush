package com.javarush.test.level07.lesson04.task01.task02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        readFromConsole();
        for (String s : array) {
            System.out.println(s);
        }
    }

    static String[] array = new String[10];

    public static void readFromConsole() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 8; i++) {
            System.out.format("Please input your %d value: " , i);
            array[i] = reader.readLine();
        }
    }

}
