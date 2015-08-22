package com.example.grissgarcia.justdoit;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Griss Garcia on 20/08/2015.
 */
public class ChooserChallenge_Activity extends Activity {

    private Button addChallengeBtn;
    private Button showListBtn;
    private ControllerBDChallenges data;
    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.challenge_layout);
        data = new ControllerBDChallenges();
        loadReferences();

        addChallengeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(ChooserChallenge_Activity.this);
                builder.setTitle("Add Challenge");
                View view = inflater.inflate(R.layout.message_add_layout, null);
                final EditText addChallengeTxt = (EditText) view.findViewById(R.id.challenge_editxt);
                builder.setView(view);
                builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String challengeAdded = addChallengeTxt.getText().toString();
                        doSave(challengeAdded);
                    }
                });
                builder.setNegativeButton("Cancel", null);
                builder.create().show();
            }
        });

        showListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChallenges();
            }
        });
        inflater = this.getLayoutInflater();
    }

    private void loadReferences() {
        addChallengeBtn = (Button) findViewById(R.id.add_btn);
        showListBtn = (Button) findViewById(R.id.show_btn);
    }

    private void doSave(String challengeAdded) {
        Intent intent = getIntent();
        String typeOfChallenge = intent.getStringExtra("typeOfChallenge");
        String type = typeOfChallenge;
        if (type.equals("") || typeOfChallenge.equals("")) {
            Toast toast1 =
                    Toast.makeText(getApplicationContext(),
                            "Ingrese una penitencia!", Toast.LENGTH_SHORT);

            toast1.show();
        } else {
            BDChallenges dataBaseChallenges = new BDChallenges();
            dataBaseChallenges.type = type;
            dataBaseChallenges.description = challengeAdded;
            data.addChallenge(dataBaseChallenges);
        }
    }

    public void getChallenge(View view) {
        data.getChallenges(new ChallengeInterface() {

            Random r = new Random();
            @Override
            public void getChallenges(List<BDChallenges> challenges) {
                final Intent intent = getIntent();
                String typeOfChallenge = intent.getStringExtra("typeOfChallenge");
                String currentChallenge = "";
                final AlertDialog.Builder message = new AlertDialog.Builder(ChooserChallenge_Activity.this);
                message.setTitle("Just Do It!!");
                View view = inflater.inflate(R.layout.challenge_show_layout, null);
                TextView justDoIt = (TextView) view.findViewById(R.id.challenge_show_message);
                final List<String> list = new ArrayList<>();
                for (BDChallenges chall : challenges) {
                    if (chall.getType().equals(typeOfChallenge)) {
                        list.add(chall.getDescription());
                    }
                }
                int position = (int) (r.nextDouble() * list.size() + 0);
                currentChallenge = list.get(position);
                justDoIt.setText(currentChallenge);
                message.setView(view);
                message.setPositiveButton("Cumplir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                message.create().show();
            }
        });
    }



    private void showChallenges() {
        data.getChallenges(new ChallengeInterface() {

            @Override
            public void getChallenges(List<BDChallenges> challenges) {
                final Intent intent = getIntent();
                String typeOfChallenge = intent.getStringExtra("typeOfChallenge");
                String currentChallenge = "";
                final List<String> list = new ArrayList<>();
                for (BDChallenges chall : challenges) {
                    if (chall.getType().equals(typeOfChallenge)) {
                        list.add(chall.getDescription());
                    }
                }
                String[] allChallenges = new String[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    allChallenges[i] = list.get(i);
                }
                Intent intent1 = new Intent(ChooserChallenge_Activity.this, ListChallenges.class);
                intent1.putExtra("challengesList", allChallenges);
                startActivity(intent1);
            }
        });
    }
}
