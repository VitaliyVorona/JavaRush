package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args)
    {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = null;
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> listEven = new ArrayList<Integer>();
        String currentLine;
        try
        {
            System.out.println("Please enter the file path:... ");
            String filePath = reader.readLine();
            fileReader = new BufferedReader(new FileReader(filePath));

            while ((currentLine = fileReader.readLine()) != null)
            {
                list.add(Integer.parseInt(currentLine));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        for (int i : list)
        {
            if (i % 2 == 0)
            {
                listEven.add(i);
            }
        }

        Integer[] arrayEven = new Integer[listEven.size()];
        listEven.toArray(arrayEven);

        for (int i = 0; i < arrayEven.length - 1; i++)
        {
            for (int j = 1; j < arrayEven.length - i; j++)
            {
                if (arrayEven[j-1] > arrayEven[j]){
                    int temp = arrayEven[j];
                    arrayEven[j] = arrayEven[j-1];
                    arrayEven[j-1] = temp;
                }
            }
        }

        for (int i : arrayEven)
        {
            System.out.println(i);
        }
    }
}
