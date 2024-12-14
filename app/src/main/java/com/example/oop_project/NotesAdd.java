package com.example.oop_project;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor; // Pastikan ini diimpor
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class NotesAdd extends AppCompatActivity {
    private DatabaseHelper dbHelper;
    private EditText titleEditText, contentEditText;
    private int noteId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notes_add);

        titleEditText = findViewById(R.id.titleEditText);
        contentEditText = findViewById(R.id.contentEditText);
        Button saveButton = findViewById(R.id.saveButton);
        dbHelper = new DatabaseHelper(this);

        // Ambil data dari Intent
        Intent intent = getIntent();
        if (intent.hasExtra("id")) {
            noteId = intent.getIntExtra("id", -1);
            loadNote();
        }
        saveButton.setOnClickListener(v -> saveNote());
    }


    private void loadNote () {
        // Ambil data catatan dari database berdasarkan ID
        Cursor cursor = dbHelper.getReadableDatabase().rawQuery("SELECT * FROM notes WHERE id = ?", new String[]{String.valueOf(noteId)});
            if (cursor.moveToFirst()) {
                titleEditText.setText(cursor.getString(cursor.getColumnIndexOrThrow("title")));
                contentEditText.setText(cursor.getString(cursor.getColumnIndexOrThrow("content")));
            }
        cursor.close();
    }
    private void saveNote () {
        String title = titleEditText.getText().toString();
        String content = contentEditText.getText().toString();

        if (noteId == -1) {
            // Tambahkan catatan baru
            dbHelper.insertNote(title, content);
            Intent intent = new Intent(NotesAdd.this, NotesMain.class);
            startActivity(intent);
        } else {
            // Perbarui catatan yang ada
            dbHelper.updateNote(noteId, title, content);
            finish();
        }
    }
}

