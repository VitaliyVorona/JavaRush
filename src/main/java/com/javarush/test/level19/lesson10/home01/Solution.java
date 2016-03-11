package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {
    public static SortedMap<String, Double> countedNumMap;

    public static void main(String[] args) throws IOException {
        File test = new File(args[0]);
        String line;
        countedNumMap = (TreeMap<String, Double>) countPersonsValues(test);
        for (Map.Entry<String, Double> i : countedNumMap.entrySet()){
            System.out.println(i.getKey() + " " + i.getValue());
        }
    }

    public static Map<String, Double> countPersonsValues(File inputValues) throws IOException {
        countedNumMap = new TreeMap<>();
        String line;
            BufferedReader reader = new BufferedReader(new FileReader(inputValues));
            while ((line = reader.readLine())!= null){
                String[] inputValue = line.split(" ");
                if (!countedNumMap.containsKey(inputValue[0])){
                    countedNumMap.put(inputValue[0], Double.parseDouble(inputValue[1]));
                }
                else {countedNumMap.put(inputValue[0], countedNumMap.get(inputValue[0]) + Double.parseDouble(inputValue[1]));}

            }
        reader.close();
        return  countedNumMap;
    }
}
