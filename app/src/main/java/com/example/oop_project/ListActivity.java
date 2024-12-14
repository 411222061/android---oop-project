package com.example.oop_project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

import android.util.Log;

public class ListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NameAdapter nameAdapter;
    private List<String> nameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        // Inisialisasi RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Inisialisasi ArrayList dengan data
        nameList = new ArrayList<>();
        nameList.add("Liverpool");
        nameList.add("Manchester City");
        nameList.add("Chelsea");
        nameList.add("Arsenal");

        Log.d(String.valueOf(nameList.size()), "show length array");

        // Inisialisasi dan Set Adapter
        nameAdapter = new NameAdapter(nameList);
        recyclerView.setAdapter(nameAdapter);
    }


    class NameAdapter extends RecyclerView.Adapter<NameAdapter.NameViewHolder> {
        private List<String> names;

        // Constructor
        NameAdapter(List<String> names) {
            this.names = names;
        }

        public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            // Perbaikan pada penggunaan LayoutInflater dan list_item layout
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item, parent, false);
            return new NameViewHolder(view);
        }

        public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
            // Menampilkan data pada TextView
            holder.textView.setText(names.get(position));
        }

        public int getItemCount() {
            return (names != null) ? names.size() : 0; // Penanganan NullPointerException
        }

        class NameViewHolder extends RecyclerView.ViewHolder {
            TextView textView;

            NameViewHolder(View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.textView); // Pastikan ID TextView sesuai dengan list_item.xml
            }
        }
    }
}