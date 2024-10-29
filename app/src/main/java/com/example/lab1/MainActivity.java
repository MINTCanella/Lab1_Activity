package com.example.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView greetingTextView;
    private Button openSecondActivityButton;
    private ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        greetingTextView = findViewById(R.id.greetingTextView);
        openSecondActivityButton = findViewById(R.id.openSecondActivityButton);

        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            String name = data.getStringExtra("name"); // Получаем имя
                            String greetingMessage = "Привет, " + name + "!";
                            greetingTextView.setText(greetingMessage);
                            openSecondActivityButton.setText("Сменить имя"); // Имя уже ввели, но его можно сменить
                        }
                    }
                }
        );

        // Обработка кнопки первой активити
        openSecondActivityButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("greeting", "Привет, "); // Передача текста приветствия
            activityResultLauncher.launch(intent); // Запуск второй активности
        });
    }


}