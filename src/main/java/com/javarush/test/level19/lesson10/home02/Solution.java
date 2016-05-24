package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, Double> map = getMostReach(args[0]);
        double maxMapValue = Collections.max(map.values());
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            if (entry.getValue() == maxMapValue) {

                System.out.print(entry.getKey() + " ");
            }
        }
    }

    public static Map<String, Double> getMostReach(String filePath) throws IOException {
        File file = new File(filePath);
        HashMap<String, Double> valuesMap = new HashMap<String, Double>();

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while (null != (line = br.readLine())) {
            double amount = Double.parseDouble(line.substring(line.indexOf(" ") + 1, line.length()));
            double amountMap;
            if (!valuesMap.containsKey(line.substring(0, line.indexOf(" ")))) {
                valuesMap.put(line.substring(0, line.indexOf(" ")), amount);
            } else {
                amountMap = valuesMap.get(line.substring(0, line.indexOf(" ")));
                valuesMap.put(line.substring(0, line.indexOf(" ")), amountMap += amount);
            }
        }
        br.close();
        return valuesMap;

    }
}
