package com.esigelec.myrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProductArrayAdapter adapter = new ProductArrayAdapter();
    Button addButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(MainActivity.this)
        );
        for (int i = 0; i < 20; i++) {
            Singleton.getInstance().productsList.add(
                    new Product("Item "+i,i)
            );
        }
        addButton = findViewById(R.id.button);
        addButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,ProductDetailActivity.class);
            Singleton.getInstance().selectedIndex = -1;
            startActivity(intent);
        });
        adapter.setOnClickListener(new ProductArrayAdapter.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {
               Intent intent = new Intent(MainActivity.this,ProductDetailActivity.class);
               Singleton.getInstance().selectedIndex = position;
               startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Singleton.getInstance().productsList.remove(position);
                adapter.notifyItemRemoved(position);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}