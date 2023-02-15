package com.esigelec.myrecyclerview;

import java.util.ArrayList;

public class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton(){

    }
    public static Singleton getInstance(){
        return instance;
    }
    public ArrayList<Product>productsList = new ArrayList<>();
    public int selectedIndex = -1;
}
