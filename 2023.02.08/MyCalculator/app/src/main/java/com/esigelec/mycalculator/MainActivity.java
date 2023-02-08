package com.esigelec.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText firstNumberEditText;
    EditText secondNumberEditText;
    TextView resultTextView;
    Button plusButton;
    Button minusButton;
    Button multButton;
    Button divButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstNumberEditText = findViewById(R.id.firstNumberEditText);
        secondNumberEditText = findViewById(R.id.secondNumberEditText);
        resultTextView = findViewById(R.id.resultTextView);
        plusButton = findViewById(R.id.plusButton);
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doOperation(view.getId());
            }
        });
        minusButton = findViewById(R.id.minusButton);
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doOperation(view.getId());
            }
        });
        multButton = findViewById(R.id.multButton);
        multButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doOperation(view.getId());
            }
        });
        divButton = findViewById(R.id.divButton);
        divButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doOperation(view.getId());
            }
        });
    }
    private void doOperation(int id){
        double num1 = getDoubleFromEditText(firstNumberEditText);
        double num2 = getDoubleFromEditText(secondNumberEditText);
        double result = 0.0;
        switch (id){
            case R.id.plusButton:
                result = num1+num2;
                break;
            case R.id.minusButton:
                result = num1-num2;
                break;
            case R.id.multButton:
                result = num1*num2;
                break;
            case R.id.divButton:
                result = num1/num2;
                break;
        }
        resultTextView.setText(getString(R.string.result)+result);
    }
    private double getDoubleFromEditText(EditText editText){
        String aux = editText.getText().toString();
        try {
            return Double.valueOf(aux);
        }catch (Exception e){
            Toast.makeText(this, getString(R.string.error_input), Toast.LENGTH_SHORT).show();
        }
        return 0.0;
    }
}