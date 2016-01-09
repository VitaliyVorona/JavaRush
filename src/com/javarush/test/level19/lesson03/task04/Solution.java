package com.javarush.test.level19.lesson03.task04;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner{
        private String line;
        public Person person;
        private String[] list;
        private Scanner scanner;
        public PersonScannerAdapter(Scanner scanner)
        {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException
        {
            line = scanner.nextLine();
                list = line.split(" ");
                Date birthDate = new GregorianCalendar(Integer.parseInt(list[5]), Integer.parseInt(list[4])-1, Integer.parseInt(list[3])).getTime();
            person = new Person(list[1], list[2], list[0], birthDate);
            return person;
        }

        @Override
        public void close() throws IOException
        {
            scanner.close();
        }
    }

   public static void main(String[] args) throws IOException
    {

        Scanner scanner = new Scanner(System.in);
        PersonScannerAdapter adapter = new PersonScannerAdapter(scanner);
        Person p = adapter.read();
        Person pp = adapter.read();
        System.out.println(p.toString());
        System.out.println(pp.toString());
        adapter.close();
    }
}
