package com.example.grissgarcia.justdoit;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/**
 * Created by Griss Garcia on 20/08/2015.
 */
public class ListChallenges extends Activity {

    private ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        list = (ListView) findViewById(R.id.challenges_list);
        updateList();
    }

    private void updateList() {
        Intent i = getIntent();
        String[] challengesList = i.getStringArrayExtra("challengesList");
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(getApplicationContext(), R.layout.list_itemview, challengesList);
        list.setAdapter(adaptador);
    }
}
