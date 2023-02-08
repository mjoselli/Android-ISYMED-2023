package com.esigelec.myactivities;

public class Singleton {
    static final private Singleton instance = new Singleton();
    private Singleton(){


    }
    public static Singleton getInstance(){
        return instance;
    }
    public String message = "";
    public boolean switchImage = false;
}
