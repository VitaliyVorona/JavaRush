package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap hashMap = new HashMap<String, String>();
        hashMap.put("Ivanov", "Stepan");
        hashMap.put("Panov", "Valeriy");
        hashMap.put("Ianov", "Stepa");
        hashMap.put("Ivvanov", "Steppan");
        hashMap.put("Ioganov", "Stepan");
        hashMap.put("Iffanov", "Stefan");
        hashMap.put("Iov", "Stefan");
        hashMap.put("Iv", "Steban");
        hashMap.put("Iannov", "Stphepan");
        hashMap.put("Ibanov", "Stepan");
        return hashMap;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //напишите тут ваш код
        HashMap<String, String> initMap = new HashMap<String, String>(map);
        HashMap<String, String> processedMap = new HashMap<String, String>();
        for (Map.Entry<String, String> pair: initMap.entrySet()){
            removeItemFromMapByValue(map, pair.getValue());

        };
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
