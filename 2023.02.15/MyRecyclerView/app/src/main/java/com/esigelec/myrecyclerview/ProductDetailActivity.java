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
            Product p = Singleton.getInstance().productsList.get(
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
        Product p = new Product(name, quantity);
        if(Singleton.getInstance().selectedIndex < 0) {
            Singleton.getInstance().productsList.add(p);
        }else{
            Singleton.getInstance().productsList.set(
                    Singleton.getInstance().selectedIndex,
                    p
            );
        }
        super.onBackPressed();
    }
}