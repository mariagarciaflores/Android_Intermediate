package com.example.grissgarcia.justdoit;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.parse.ParseException;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

/**
 * Created by Griss Garcia on 20/08/2015.
 */
@Table (name = "Challenges")
public class BDChallenges extends Model {
    @Column (name = "type")
    public String type;
    @Column (name = "description")
    public String description;

    public BDChallenges() {
        super();
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public void saveLocally() {
        save();
    }

    public static BDChallenges fromParseObject(ParseObject p) {
        BDChallenges challenge = new BDChallenges();
        challenge.type = p.getString("type");
        challenge.description = p.getString("description");
        return challenge;
    }
}
