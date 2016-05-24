package com.javarush.test.level18.lesson03.task03;

import java.io.*;
import java.util.*;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName = getConsoleValue(System.in);
        HashMap<Integer, Integer> map = (HashMap)processInputValues(fileName);
        printValues(map);
    }
    public static String getConsoleValue(InputStream inputStream) throws IOException {
        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        return  line = reader.readLine();
    }
    public static Map processInputValues(String fileName) throws IOException {
        TreeMap<Integer, Integer> values = new TreeMap<>();
        HashMap<Integer, Integer> maxValue = new HashMap<Integer, Integer>();
        File file = new File(fileName);
        FileInputStream reader = new FileInputStream(file);
        int readValue = 0;

        while (reader.available() > 0){
            readValue = reader.read();
            if (!values.containsKey(readValue)){
                values.put(readValue, 1);
            }
            else {
                int counter = values.get(readValue);
                values.put(readValue, counter+1);}
        }
        reader.close();

        int maxMapValue = (Collections.max(values.values()));
        for (Map.Entry<Integer, Integer> entry : values.entrySet()){
            if (entry.getValue() == maxMapValue){
                maxValue.put(entry.getKey(), entry.getValue());
            }
        }
        return maxValue;
    }
    public static void printValues(Map<Integer, Integer> values){
        HashMap map = new HashMap<Integer, Integer>();
        int maxValue = 0;
        for (Map.Entry<Integer, Integer> entry : values.entrySet()){
            map.put(entry.getKey(), entry.getValue());
            System.out.print(entry.getKey() + " ");
        }
    }
}
