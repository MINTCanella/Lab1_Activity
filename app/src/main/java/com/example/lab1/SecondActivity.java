package com.example.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private EditText nameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView greetingTextView = findViewById(R.id.greetingTextView);
        nameEditText = findViewById(R.id.nameEditText);
        Button sendButton = findViewById(R.id.sendButton);

        String greeting = getIntent().getStringExtra("greeting"); // Приняли приветственное сообщение
        greetingTextView.setText(greeting);

        // Обработка кнопки второй активити
        sendButton.setOnClickListener(v -> {
            String name = nameEditText.getText().toString();
            Intent intent = new Intent();
            intent.putExtra("name", name);
            setResult(RESULT_OK, intent);
            finish(); // Завершаем активити
        });;
    }
}