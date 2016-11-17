package com.app.fantasycostco;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.DialogFragment;
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

public class StoreActivity extends AppCompatActivity implements ItemDetailFragment.OnFragmentInteractionListener {
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
                DialogFragment newDetail = new ItemDetailFragment();
                Bundle args = new Bundle();
                args.putString("itemName", parent.getItemAtPosition(position).toString());
                newDetail.setArguments(args);
                newDetail.show(getSupportFragmentManager(), "detail");
                //Toast.makeText(StoreActivity.this, "Clicked: " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
