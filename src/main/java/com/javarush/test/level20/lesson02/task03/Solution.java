package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.*;

/*
 Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/


public class Solution {
    public static Map<String, String> properties = new HashMap<>();

   /* public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
//        solution.fillInPropertiesMap();
        FileInputStream fos = new FileInputStream("D:\\users\\vitaliy.vorona\\PROGRAMMING\\JAVA\\Samples\\testOut.txt");
        solution.load(fos);
        System.out.println(properties.entrySet());
    }*/

    public void fillInPropertiesMap() throws IOException {
        //implement this method - реализуйте этот метод
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();
        Properties prop = new Properties();
        System.out.println(filePath);

        File propertiesFile = new File(filePath);
        FileReader fis = new FileReader(propertiesFile);

        prop.load(fis);

        BufferedReader reader = new BufferedReader(fis);
        String propLine = reader.readLine();

        for (Map.Entry<Object, Object> entry : prop.entrySet()){
            properties.put((String)entry.getKey(), (String)entry.getValue());
        }

        fis.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        String propertyLine;
        PrintWriter writer = new PrintWriter(outputStream);
        Iterator iterator = properties.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry pair = (Map.Entry)iterator.next();
            writer.println(pair.getKey() + "=" + pair.getValue());
        }
        writer.flush();
        writer.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = reader.readLine();
        String key, value;

        while (line != null){
            key = line.substring(0, line.indexOf("="));
            value = line.substring(line.indexOf("=")+1);
            properties.put(key, value);
            line = reader.readLine();
        }
        reader.close();
    }
}
