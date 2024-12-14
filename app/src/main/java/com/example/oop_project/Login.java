package com.example.oop_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Login  extends AppCompatActivity {

    private EditText usernameEdit, passwordEdit;
    private Button loginButton;

      Intent intentInt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        // get ui or xml
        setContentView(R.layout.login);

        usernameEdit = findViewById(R.id.usernameEdit);
        passwordEdit = findViewById(R.id.passwordEdit);
        loginButton  = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLogin();
            }
        });
    }

    private void handleLogin() {
        String username = usernameEdit.getText().toString();
        String password = passwordEdit.getText().toString();

        try {
            validateCredentials(username, password);
            Toast.makeText(Login.this, "Nah bisa kan", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Login.this, ListActivity.class);
            Login.this.startActivity(intent);
            finish();
        } catch (InvalidCredentialsException e) {
            Toast.makeText(Login.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(Login.this, "Maaf terjadi kesalahan" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void validateCredentials(String username, String password) throws InvalidCredentialsException {
       if(username.isEmpty() || password.isEmpty()){
           throw new InvalidCredentialsException("Username atau password tidak boleh kosong");
       }
        if(!username.equals("admin") || !password.equals("12345")){
            throw new InvalidCredentialsException("Username atau password Salah");
        }
    }


}