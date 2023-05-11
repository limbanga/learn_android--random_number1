package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random random;

    TextView textViewResult;
    EditText editTextMinValue;
    EditText editTextMaxValue;
    Button buttonGenerate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        random = new Random();
        getView();

        buttonGenerate.setOnClickListener(view -> {

            String minString = editTextMinValue.getText().toString();
            String maxString = editTextMaxValue.getText().toString();

            if (minString.isEmpty()) {
                Toast.makeText(MainActivity.this, "Bạn phải nhập giá trị tối thiểu.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (maxString.isEmpty()) {
                Toast.makeText(MainActivity.this, "Bạn phải nhập giá trị tối đa.", Toast.LENGTH_SHORT).show();
                return;
            }

            int minValue = Integer.parseInt(minString);
            int maxValue = Integer.parseInt(maxString);

            if (minValue > maxValue) {
                Toast.makeText(MainActivity.this, "Giá trị tối thiểu không thể lớn hơn giá trị tối đa.", Toast.LENGTH_SHORT).show();
                return;
            }

            int result =  random.nextInt((maxValue - minValue) + 1) + minValue;
            String textResult = "Result: "+ result;
            textViewResult.setText(textResult);
            Toast.makeText(MainActivity.this, "Sinh số thành công.", Toast.LENGTH_SHORT).show();
        });

    }

    private void getView() {
        textViewResult = findViewById(R.id.textViewResult);
        editTextMinValue = findViewById(R.id.editTextNumberSignedMinValue);
        editTextMaxValue = findViewById(R.id.editTextNumberSignedMaxValue);
        buttonGenerate = findViewById(R.id.buttonGenerate);
    }
}