package com.app.fantasycostco;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class StoreActivity extends AppCompatActivity {
    @Bind(R.id.itemsListView) ListView mItemsListView;

    String[] inventory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        ButterKnife.bind(this);

        inventory = getResources().getStringArray(R.array.item_names);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, inventory);
        mItemsListView.setAdapter(adapter);

        mItemsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(StoreActivity.this, "Clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
