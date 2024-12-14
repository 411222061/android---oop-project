package com.example.oop_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class RootMain extends AppCompatActivity {

    Button intent, toMath, toHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        // get ui or xml
        setContentView(R.layout.rootmain);

        intent = findViewById((R.id.btnIntent));
        toHome = findViewById((R.id.btnHome));
        toMath = findViewById((R.id.btnMath));

        intent.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                Intent intent = new Intent(RootMain.this, MainActivity.class);
                intent.putExtra("homeInfo", "Hallo saya bukan derry!");
                startActivity(intent);
            }
        });

        toHome.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                Intent intentHome = new Intent(RootMain.this, HomeActivity.class);
                startActivity(intentHome);
            }
        });

        toMath.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                Intent intent = new Intent(RootMain.this, Matematika.class);
                startActivity(intent);
            }
        });
    }
}
