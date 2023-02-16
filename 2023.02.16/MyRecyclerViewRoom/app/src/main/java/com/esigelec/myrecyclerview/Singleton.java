package com.esigelec.myrecyclerview;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton(){

    }
    public static Singleton getInstance(){
        return instance;
    }
    public int selectedIndex = -1;
    ProductDAO dao;
    public void createDatabase(Context context){
        dao = AppDatabase.getInstance(context).
                productDAO();
    }
    public List<Product> getProductList(){
        return dao.getAll();
    }
    public void addProduct(Product p){
        dao.insertAll(p);
    }
    public void updateProduct(Product p){
        dao.updateAll(p);
    }
    public void removeProduct(int position){
        Product p = getProductList().get(position);
        dao.delete(p);
    }
}

