package com.esigelec.myrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ProductDetailActivity extends AppCompatActivity {
    EditText nameEditText;
    EditText quantityEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        nameEditText = findViewById(R.id.nameEditText);
        quantityEditText = findViewById(R.id.quantityEditText);
        if(Singleton.getInstance().selectedIndex >= 0) {
            Product p = Singleton.getInstance().getProductList().get(
                    Singleton.getInstance().selectedIndex
            );
            nameEditText.setText(p.name);
            quantityEditText.setText("" + p.quantity);
        }
    }

    @Override
    public void onBackPressed() {
        String name = nameEditText.getText().toString();
        int quantity = Integer.valueOf(quantityEditText.getText().toString());
        if(Singleton.getInstance().selectedIndex == -1) {
            Product p = new Product();
            p.name = name;
            p.quantity = quantity;
            Singleton.getInstance().addProduct(p);
        }else{
            Product p = Singleton.getInstance().getProductList().get(
                    Singleton.getInstance().selectedIndex
            );
            p.name = name;
            p.quantity = quantity;
            Singleton.getInstance().updateProduct(p);
        }
        super.onBackPressed();
    }
}