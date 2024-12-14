package com.example.oop_project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Diskon extends AppCompatActivity {
    EditText inputHarga, inputDiskon;

    TextView hasil;

    Button btnHitung;
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.diskon);

        inputHarga = findViewById(R.id.inputHarga);
        inputDiskon = findViewById(R.id.inputDiskon);
        hasil = findViewById(R.id.hasil);
        btnHitung= findViewById(R.id.btnHitung);

        //  calculate price and discount
        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double harga = Double.parseDouble(inputHarga.getText().toString());
                double diskon = Double.parseDouble(inputDiskon.getText().toString());
                double calculateDiscount = harga * diskon / 100;
                double calculatePrice = harga - calculateDiscount;
                hasil.setText("Harga Akhir: " + calculatePrice);
            }
        });
    }
}
