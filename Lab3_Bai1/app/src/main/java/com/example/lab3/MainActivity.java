package com.example.lab3;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private EditText editText;
    private Button btnAdd, btnEdit, btnDelete;
    private java.util.ArrayList<String> items;
    private CustomAdapter adapter;
    private int selectedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        editText = findViewById(R.id.editText);
        btnAdd = findViewById(R.id.btnAdd);
        btnEdit = findViewById(R.id.btnEdit);
        btnDelete = findViewById(R.id.btnDelete);

        items = new java.util.ArrayList<>();
        items.add("Item 1");
        items.add("Item 2");
        items.add("Item 3");

        adapter = new CustomAdapter(this, R.layout.custom_list_item, items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedPosition = position;
                editText.setText(items.get(position));
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = editText.getText().toString().trim();
                if (!newItem.isEmpty()) {
                    items.add(newItem);
                    adapter.notifyDataSetChanged();
                    editText.setText("");
                    Toast.makeText(MainActivity.this, "Item added", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Please enter an item", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedPosition != -1) {
                    String updatedItem = editText.getText().toString().trim();
                    if (!updatedItem.isEmpty()) {
                        items.set(selectedPosition, updatedItem);
                        adapter.notifyDataSetChanged();
                        editText.setText("");
                        selectedPosition = -1;
                        Toast.makeText(MainActivity.this, "Item updated", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Please enter an item", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please select an item to edit", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedPosition != -1) {
                    items.remove(selectedPosition);
                    adapter.notifyDataSetChanged();
                    editText.setText("");
                    selectedPosition = -1;
                    Toast.makeText(MainActivity.this, "Item deleted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Please select an item to delete", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}