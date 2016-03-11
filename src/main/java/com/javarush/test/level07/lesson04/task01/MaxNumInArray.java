package com.javarush.test.level07.lesson04.task01;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxNumInArray {
    final static Logger logger = Logger.getLogger(MaxNumInArray.class);
    static int[] arrayInit = new int[5];

    public static void main(String[] args) throws IOException {
        initializeArray();
        System.out.println("The Max value is: " + max(arrayInit));
    }

    public static void initializeArray() throws IOException {
        logger.info("Running initializeArray method: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String line = reader.readLine();
            arrayInit[i] = Integer.parseInt(line);
        }
    }

    public static int max(int[] array) {
        int maxValue = 0;
        for (int i : array) {
            if (maxValue < i) {
                maxValue = i;
            }
        }
        return maxValue;
    }
}
