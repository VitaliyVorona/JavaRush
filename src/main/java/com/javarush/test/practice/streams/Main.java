package com.javarush.test.practice.streams;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by vitaliy.vorona on 5/20/2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\Git\\LearningCurve\\JavaRush\\src\\test.txt");

        long sum = 0;
        while (fis.available() > 0){
            int data = fis.read();
            sum+=data;
            System.out.println("value is: " + data);
            System.out.println("sum is: " + sum);
        }
        fis.close();
        System.out.println(sum);
    }
}
