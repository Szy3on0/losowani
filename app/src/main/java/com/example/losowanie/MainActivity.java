package com.example.losowanie;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText minValue, maxValue;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Połączenie z elementami interfejsu
        minValue = findViewById(R.id.minValue);
        maxValue = findViewById(R.id.maxValue);
        result = findViewById(R.id.result);
        Button buttonGenerate = findViewById(R.id.buttonGenerate);

        // Obsługa kliknięcia przycisku
        buttonGenerate.setOnClickListener(v -> generateRandomNumber());
    }

    private void generateRandomNumber() {
        try {
            // Pobranie wartości z pól tekstowych
            int min = Integer.parseInt(minValue.getText().toString());
            int max = Integer.parseInt(maxValue.getText().toString());

            if (min > max) {
                result.setText("Błąd: Min > Max");
                return;
            }

            // Losowanie liczby
            int randomNum = new Random().nextInt((max - min) + 1) + min;
            result.setText("Wylosowana liczba: " + randomNum);

        } catch (NumberFormatException e) {
            // Obsługa błędów wprowadzania danych
            result.setText("Wprowadź poprawne liczby!");
        }
    }
}