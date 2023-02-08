package com.esigelec.myactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button goToSecondButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getString(R.string.main_activity_title));
        editText = findViewById(R.id.editText);
        goToSecondButton = findViewById(R.id.goToSecondButton);
        goToSecondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                String s = editText.getText().toString();
                Singleton.getInstance().message = s;
                startActivity(intent);
            }
        });
    }
    ImageView imageView;
    @Override
    protected void onResume() {
        super.onResume();
        imageView = findViewById(R.id.imageView);
        if(Singleton.getInstance().switchImage){
            imageView.setImageResource(R.drawable.rick);
        }else{
            imageView.setImageResource(R.drawable.morty);
        }

    }
}