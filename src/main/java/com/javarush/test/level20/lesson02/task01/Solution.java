package com.javarush.test.level20.lesson02.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Читаем и пишем в файл: Human
Реализуйте логику записи в файл и чтения из файла для класса Human
Поле name в классе Human не может быть пустым
В файле your_file_name.tmp может быть несколько объектов Human
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution
{
    public static void main(String[] args)
    {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try
        {

            File your_file_name = File.createTempFile("your_file_name", ".txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны

            System.out.println(ivanov.equals(somePerson));
            inputStream.close();

        }
        catch (IOException e)
        {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        }
        catch (Exception e)
        {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Human
    {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human()
        {
        }

        public Human(String name, Asset... assets)
        {
            this.name = name;
            if (assets != null)
            {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception
        {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            int assetsCounter = 0;

            String isAssetPresent = assets != null ? "yes" : "no";
            writer.println(isAssetPresent);
            if (isAssetPresent.equals("yes"))
            {
                assetsCounter = assets.size();
                writer.println(assetsCounter);
            }
            writer.println(name);

            if (assets != null)
            {
                for (Asset a : assets)
                {
                    writer.println(a.getName());
                    writer.println(a.getPrice());
                }
            }
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception
        {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String isAssetPresent = reader.readLine();
            if (isAssetPresent.equals("yes"))
            {
                int assetsNumber = Integer.parseInt(reader.readLine());
                String humanName = reader.readLine();
                this.name = humanName;
                for (int i = 0; i < assetsNumber; i++)
                {
                    String name = reader.readLine();
                    double price = Double.parseDouble(reader.readLine());
                    assets.add(i, new Asset(name));
                    assets.get(i).setPrice(price);
                }
            }
            reader.close();
        }

        public boolean equals(Human h)
        {
            boolean result = false;
            if (h != null)
            {
                if (this.name.equals(h.name))
                {
                    if (this.assets.size() == h.assets.size())
                    {
                        for (int i = 0; i < assets.size(); i++)
                        {
                            if (this.assets.get(i).getName().equals(h.assets.get(i).getName()) &&
                                    this.assets.get(i).getPrice() == (h.assets.get(i).getPrice())){
                                result = true;
                            }
                        }
                        }
                    }
                }
            else result = false;
            return result;
            }
        }
    }
