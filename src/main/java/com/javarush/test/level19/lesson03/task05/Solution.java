package com.javarush.test.level19.lesson03.task05;

import java.util.HashMap;
import java.util.Map;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {
    private static Map<String,String> countries = new HashMap<String,String>();

    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA"," Canada");
    }

    public static class DataAdapter implements  RowItem{
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode()
        {
            String countryName = customer.getCountryName();
            for (Map.Entry entry : countries.entrySet()){
                if (entry.getValue().equals(countryName)){
                    countryName = (String) entry.getKey();
                }
            }
            return countryName;
        }

        @Override
        public String getCompany()
        {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName()
        {
            return contact.getName().substring(contact.getName().lastIndexOf(" ")+1, contact.getName().length());
        }

        @Override
        public String getContactLastName()
        {
            return contact.getName().substring(0, contact.getName().indexOf(","));
        }

        @Override
        public String getDialString()
        {
            String phn = contact.getPhoneNumber();
            String phone = phn.substring(0, phn.indexOf("("))+phn.substring(phn.indexOf("(")+1,phn.indexOf(")"))+
                    phn.substring(phn.indexOf(")")+1,phn.indexOf("-"))+phn.substring(phn.indexOf("-")+1, phn.lastIndexOf("-"))+phn.substring(phn.lastIndexOf("-")+1)+
                    phn.substring(phn.length());
            return "callto://"+ phone;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
   /* public static class CustomerInit implements Customer{
        String companyName;
        String countryName;

        public CustomerInit(String companyName, String countryName)
        {
            this.companyName = companyName;
            this.countryName = countryName;
        }

        @Override
        public String getCompanyName()
        {
            return companyName;
        }

        @Override
        public String getCountryName()
        {
            return countryName;
        }
    }
    public static class ContactInit implements Contact{
        String name;
        String phoneNumber;

        public ContactInit(String name, String phoneNumber)
        {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        @Override
        public String getName()
        {
            return name;
        }

        @Override
        public String getPhoneNumber()
        {
            return phoneNumber;
        }
    }

    public static void main(String[] args)
    {
        ContactInit contactInit = new ContactInit("Ivanov, Ivan", "+38(050)123-45-67");
        CustomerInit customerInit = new CustomerInit("GL", "Ukraine");
        DataAdapter dataAdapter = new DataAdapter(customerInit, contactInit);
        System.out.println(dataAdapter.getCountryCode());
        System.out.println(dataAdapter.getCompany());
        System.out.println(dataAdapter.getContactFirstName());
        System.out.println(dataAdapter.getContactLastName());
        System.out.println(dataAdapter.getDialString());
    }
*/
}