package com.example.oop_project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText panjang, lebar;
    private Button btnPersegi, btnSegitiga, btnLingkaran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        // get ui or xml
        setContentView(R.layout.activity_main);

        // Initialize UI elements variable
//        displayHasil = findViewById(R.id.displayHasil);
        panjang = findViewById(R.id.panjang);
        lebar = findViewById(R.id.lebar);
        btnPersegi = findViewById(R.id.btnPersegi);
        btnSegitiga = findViewById(R.id.btnSegitiga);
        btnLingkaran = findViewById(R.id.btnLingkaran);

        btnPersegi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        btnSegitiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        btnLingkaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }
}