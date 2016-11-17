package com.app.fantasycostco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class StoreActivity extends AppCompatActivity {
    @Bind(R.id.itemsListView) ListView mItemsListView;
    private String[] inventory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        ButterKnife.bind(this);

        inventory = getResources().getStringArray(R.array.item_names);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, inventory);
        mItemsListView.setAdapter(adapter);
    }
}
