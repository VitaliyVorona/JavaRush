package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", ".txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("Alex");
            user.setLastName("Ivanov");
//            user.setCountry(User.Country.UKRAINE);
            user.getBirthDate();
            javaRush.users.add(user);
            javaRush.save(outputStream);
            outputStream.flush();


            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);

            String isUserPresent = users != null ? "yes" : "no";
            writer.println(isUserPresent);

            int usersNumber = users.size();
            writer.println(usersNumber);

            for (int i = 0; i < usersNumber; i++) {
                User user = users.get(i);
                if (user.getFirstName() != null) {
                    writer.println(user.getFirstName());
                } else writer.println("null");

                if (user.getLastName() != null) {
                    writer.println(user.getLastName());
                } else writer.println("null");

                if (user.getBirthDate() != null) {
                    writer.println(user.getBirthDate());
                } else writer.println("null");

                writer.println(user.isMale());

                if (user.getCountry() != null) {
                    writer.println(user.getCountry());
                } else writer.println("null");
            }
            writer.println("End of Users");
            writer.flush();
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String isUserPresent = reader.readLine();
            String isEndOfUsers = "End of Users";

            if (isUserPresent.equals("yes")) {
                String line = reader.readLine();
                int usersNumber = Integer.parseInt(line);

                while (!line.equals(isEndOfUsers)) {

                    for (int i = 0; i < usersNumber; i++) {
                        this.users.add(i, new User());

                        line = reader.readLine();
                        if (!line.equals("null")) {
                            this.users.get(i).setFirstName(line);
                        } else this.users.get(i).setFirstName("null");

                        line = reader.readLine();
                        if (!line.equals("null")) {
                            this.users.get(i).setLastName(line);
                        } else this.users.get(i).setLastName("null");

                        line = reader.readLine();
                        if (!line.equals("null")) {
                            this.users.get(i).setBirthDate(new Date(line));
                        } else this.users.get(i).setBirthDate(null);

                        line = reader.readLine();
                        if (line.equals(true)) {
                            this.users.get(i).setMale(true);
                        } else this.users.get(i).setMale(false);

                        line = reader.readLine();
                        if (!line.equals(null) && line.equals("UKRAINE")) {
                            this.users.get(i).setCountry(User.Country.UKRAINE);
                        }
                        if (!line.equals(null) && line.equals("RUSSIA")) {
                            this.users.get(i).setCountry(User.Country.RUSSIA);
                        }
                        if (!line.equals(null) && line.equals("OTHER")) {
                            this.users.get(i).setCountry(User.Country.OTHER);
                        }
                        if (line.equals(null) || line.equals("null")) {
                            this.users.get(i).setCountry(null);
                        }
                    }
                    line = reader.readLine();
                }
            }
            reader.close();
        }

        public boolean equals(JavaRush rush) {
            boolean result = false;
            if (rush != null) {
                if (rush.users != null) {
                    int usersNum = users.size();
                    if (this.users.size() == rush.users.size()) {
                        for (int i = 0; i < usersNum; i++) {
                                result = this.users.get(i).getFirstName().equals(rush.users.get(i).getFirstName()) &&
                                        this.users.get(i).getLastName().equals(rush.users.get(i).getLastName()) &&
                                        this.users.get(i).getBirthDate() == rush.users.get(i).getBirthDate() &&
                                        this.users.get(i).isMale() == rush.users.get(i).isMale() &&
                                        this.users.get(i).getCountry() == rush.users.get(i).getCountry();
                        }
                    }
                }
            }
            return result;
        }
    }
}