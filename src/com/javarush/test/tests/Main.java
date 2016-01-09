package com.javarush.test.tests;

/**
 * Created by Groovy on 03-Nov-15.
 */
public class Main
{

    public static void main(String[] args)
    {
        System.out.println(qcd(280,10));
    }

    public static int qcd(int p, int q)
    {
        if (q == 0) return p;
        int r = p%q;
        return qcd(q, r);
    }
}

