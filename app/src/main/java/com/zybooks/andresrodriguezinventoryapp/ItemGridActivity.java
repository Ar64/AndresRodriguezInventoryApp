package com.zybooks.andresrodriguezinventoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import java.util.ArrayList;

public class ItemGridActivity extends AppCompatActivity {

    GridView gridViewItems;
    ArrayList<Item> arrayItem = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_grid);

        updateGridView();
    }

    public void onTapAddItemFAB(View view) {
        // Go to Add Item Activity
        Intent goToAddItemActivty = new Intent(getApplicationContext(), AddItemActivity.class);
        startActivity(goToAddItemActivty);
    }

    public void updateGridView() {
        ItemDatabase itemDatabase = new ItemDatabase(this);
        arrayItem = itemDatabase.getAllItems();

        gridViewItems = findViewById(R.id.gridViewItems);
        ItemAdapter itemAdapter = new ItemAdapter(this, R.id.gridViewItemLayout, arrayItem);
        gridViewItems.setAdapter(itemAdapter);
    }
}