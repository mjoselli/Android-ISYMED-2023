package com.esigelec.myrecyclerview;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProductDAO {
    @Insert
    void insertAll(Product... products);
    @Update
    void updateAll(Product... products);
    @Delete
    void delete(Product product);
    @Query("Select * from Product")
    List<Product> getAll();
    @Query("Select * from Product where name like :name")
    List<Product> findProductByName(String name);
}
