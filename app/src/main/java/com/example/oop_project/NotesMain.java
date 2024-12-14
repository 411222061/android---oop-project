package com.example.oop_project;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class NotesMain extends AppCompatActivity {
    private DatabaseHelper dbHelper;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> notes;
    private ArrayList<Integer> noteIds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notes_main);
        listView = findViewById(R.id.listView); dbHelper = new DatabaseHelper(this);
        loadNotes();

        listView.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id ) -> {
            Intent intent = new Intent(NotesMain.this, NotesAdd.class);
            intent.putExtra("id", noteIds.get(position));
            startActivity(intent);
        });

        findViewById(R.id.addButton).setOnClickListener(v -> {
            Intent intent = new Intent(NotesMain.this, NotesAdd.class);
            startActivity(intent);
        });
    }

    private void loadNotes() {
        notes = new ArrayList<>();
        noteIds = new ArrayList<>();
        Cursor cursor = dbHelper.getAllNotes();
        if (cursor.moveToFirst()) {
            do {
                noteIds.add(cursor.getInt(cursor.getColumnIndex("id")));
                notes.add(cursor.getString(cursor.getColumnIndex("title")));
            } while (cursor.moveToNext());
        }
        cursor.close();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notes);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadNotes();
    }
}
