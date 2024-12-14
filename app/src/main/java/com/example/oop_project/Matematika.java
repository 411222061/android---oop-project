package com.example.oop_project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Matematika extends AppCompatActivity {

    // define variable edittext, textview, button
    EditText inputSisi, inputJariJari, inputTinggi;

    TextView hasilLuasPersegi, hasilVolumeKerucut, hasilLuasSegitiga;

    Button hitungLuas, hitungVolume, hitungSegitiga;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.matematika);

        inputSisi = findViewById(R.id.inputsisi);
        inputJariJari = findViewById(R.id.inputJariJari);
        inputTinggi = findViewById(R.id.inputTinggi);
        hasilLuasPersegi= findViewById(R.id.hasilLuasPersegi);
        hasilVolumeKerucut= findViewById(R.id.hasilVolumeKerucut);
        hasilLuasSegitiga= findViewById(R.id.hasilLuasSegitiga);
        hitungLuas= findViewById(R.id.hitungLuas);
        hitungVolume= findViewById(R.id.hitungVolume);
        hitungSegitiga= findViewById(R.id.hitungSegitiga);

        // hitung luas persegi
        hitungLuas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double sisi = Double.parseDouble(inputSisi.getText().toString());
                double luasPersegi = Math.pow(sisi, 2);
                hasilLuasPersegi.setText("Luas Persegi: " + luasPersegi);
            }
        });

        // hitung volume kerucut
        hitungVolume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double jariJari = Double.parseDouble(inputJariJari.getText().toString());
                double tinggi = Double.parseDouble(inputTinggi.getText().toString());
                double volumeKerucut = (1.0 / 3) * Math.PI * Math.pow(jariJari, 2 ) * tinggi;
                hasilVolumeKerucut.setText("Volume Kerucut: " + volumeKerucut);
            }
        });

        // hitung luas segitiga
        hitungSegitiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double jariJari = Double.parseDouble(inputJariJari.getText().toString());
                double tinggi = Double.parseDouble(inputTinggi.getText().toString());
                double luasSegitiga = 0.5 * jariJari * tinggi;
                hasilLuasSegitiga.setText("Luas Segitiga: " + luasSegitiga);
            }
        });
    }
}