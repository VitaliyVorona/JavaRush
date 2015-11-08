package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() {
        //implement this method - реализуйте этот метод
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        PrintWriter writer = new PrintWriter(outputStream);
        Iterator iterator = properties.entrySet().iterator();
        String keyValue = new String();
        while (iterator.hasNext()){
            Map.Entry pair = (Map.Entry) iterator.next();
            keyValue = pair.getKey() + "=" + pair.getValue();
            writer.println(keyValue);
        }
        writer.flush();
        writer.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String keyValue = reader.readLine();
        String key = keyValue.substring(0, keyValue.indexOf("="));
        String value = keyValue.substring(keyValue.indexOf(""));
        properties.put(key, value);
    }

    public static void main(String[] args) throws Exception {
//        Map map = new HashMap<String, String>();
        properties.put("1", "a");
        properties.put("2", "b");
        properties.put("3", "c");

        Solution s = new Solution();
        File f = new File("H:\\Programming\\Samples\\testOut.txt");
        FileOutputStream fos = new FileOutputStream(f);
        s.save(fos);
    }
}
