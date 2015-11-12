package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Groovy on 12-Jul-15.
 */
public class Main{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        HashMap<String, String> map = solution.createMap();
        for (Map.Entry<String, String> pair: map.entrySet()){
            System.out.println(pair.getKey());
        }

        System.out.println(" =============================== ");

        solution.removeItemFromMapByValue(map, "Stepan");

        for (Map.Entry<String, String> pair: map.entrySet()){
            System.out.println(pair.getKey());
        }
    }
}
