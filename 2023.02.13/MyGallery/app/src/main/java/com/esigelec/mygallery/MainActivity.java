package com.esigelec.mygallery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView titleTextView;
    Button leftButton;
    Button rightButton;
    ImageView imageView;
    TextView indexTextView;
    int imageIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleTextView = findViewById(R.id.titleTextView);
        leftButton = findViewById(R.id.leftButton);
        leftButton.setOnClickListener(view -> {
            imageIndex--;
            updateImageDetails();
        });

        rightButton = findViewById(R.id.rightButton);
        rightButton.setOnClickListener(view -> {
            imageIndex++;
            updateImageDetails();
        });
        imageView = findViewById(R.id.imageView);
        indexTextView = findViewById(R.id.indexTextView);
        Singleton.getInstance().addImageDetail("Sponge Bob",R.drawable.bob);
        Singleton.getInstance().addImageDetail("Patrick Star",R.drawable.patrick);
        Singleton.getInstance().addImageDetail("Squid",R.drawable.lula);
        updateImageDetails();
    }
    void updateImageDetails(){
        if(imageIndex < 0){
            imageIndex = Singleton.getInstance().getImageArraySize()-1;
        }
        if(imageIndex >= Singleton.getInstance().getImageArraySize()){
            imageIndex = 0;
        }
        ImageDetails im = Singleton.getInstance().getImage(imageIndex);
        titleTextView.setText(im.title);
        imageView.setImageResource(im.id);
        indexTextView.setText(""+(imageIndex+1)+"/"+Singleton.getInstance().getImageArraySize());
    }
}