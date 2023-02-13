package com.esigelec.mygallery;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton(){
    }
    public static Singleton getInstance(){
        return instance;
    }
    private ArrayList<ImageDetails> myImages = new ArrayList<>();
    public void addImageDetail(String title,int id){
        myImages.add(new ImageDetails(title,id));
    }
    public ImageDetails getImage(int index){
        return myImages.get(index);
    }
    public int getImageArraySize(){
        return myImages.size();
    }
}
