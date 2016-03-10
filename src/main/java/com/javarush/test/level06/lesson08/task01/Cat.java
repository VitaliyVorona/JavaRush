package com.javarush.test.level06.lesson08.task01;

public class Cat {
    static int catCount;
    static int setCatCount(int num){return Cat.catCount = num;};
    static int getCatCount(){return Cat.catCount;};


    public Cat(){
        Cat.catCount++;
    }

    public static void main(String[] args) {
        System.out.println(Cat.getCatCount());
        Cat cat1 = new Cat();
        System.out.println(Cat.getCatCount());
        System.out.println(Cat.setCatCount(23));
        System.out.println(Cat.getCatCount());

    }
}
