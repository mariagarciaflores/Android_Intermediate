package com.example.grissgarcia.justdoit;

import com.activeandroid.query.Select;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Griss Garcia on 20/08/2015.
 */
public class ControllerBDChallenges {

    public void addChallenge(BDChallenges challenge) {
        challenge.saveLocally();
    }

    private void getChallengeLocally(ChallengeInterface callback) {
        List<BDChallenges> challenges = new Select()
                .from(BDChallenges.class).execute();
                callback.getChallenges(challenges);
    }

    public void getChallenges(ChallengeInterface callback) {
        getChallengeLocally(callback);
    }
}
