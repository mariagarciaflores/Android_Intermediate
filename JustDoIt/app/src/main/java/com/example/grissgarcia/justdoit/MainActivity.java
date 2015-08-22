package com.example.grissgarcia.justdoit;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;
import java.util.Random;

/**
 * Created by Griss Garcia on 20/08/2015.
 */
public class MainActivity extends Activity {

    private ImageButton easyButon;
    private ImageButton hardButton;
    private ImageButton daringButton;
    private List<ParseObject> challenges;
    private LayoutInflater inflate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        loadReferences();
        ParseAnalytics.trackAppOpenedInBackground(getIntent());

        easyButon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChooserChallenge_Activity.class);
                intent.putExtra("typeOfChallenge", "easy");
                startActivity(intent);

            }
        });

        hardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChooserChallenge_Activity.class);
                intent.putExtra("typeOfChallenge", "hard");
                startActivity(intent);
            }
        });

        daringButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChooserChallenge_Activity.class);
                intent.putExtra("typeOfChallenge", "daring");
                startActivity(intent);
            }
        });
    }

    private void loadReferences() {
        easyButon = (ImageButton) findViewById(R.id.easy_btn);
        hardButton = (ImageButton) findViewById(R.id.hard_btn);
        daringButton = (ImageButton) findViewById(R.id.daring_btn);
    }

}
