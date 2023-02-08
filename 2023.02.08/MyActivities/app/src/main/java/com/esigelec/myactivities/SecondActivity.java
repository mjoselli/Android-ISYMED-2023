package com.esigelec.myactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;

public class SecondActivity extends AppCompatActivity {
    Button goToThirdButton;
    Switch switch1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle(Singleton.getInstance().message);
        goToThirdButton = findViewById(R.id.goToThirdButton);
        goToThirdButton.setOnClickListener(view -> {
            Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
            startActivity(intent);
        });
        switch1 = findViewById(R.id.switch1);
    }

    @Override
    public void onBackPressed() {
        Singleton.getInstance().switchImage = switch1.isChecked();
        finish();
    }
}