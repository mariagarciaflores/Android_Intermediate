package com.example.grissgarcia.googlemapsexample;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseCrashReporting;
import com.parse.ParseUser;

/**
 * Created by Griss Garcia on 26/07/2015.
 */
public class ParseAplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize Crash Reporting.
        ParseCrashReporting.enable(this);

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        // Add your initialization code here
        Parse.initialize(this);
        //Parse.initialize( this , "ZWOvQXy7M5LkdAJJvy9jxtcG4IV3cdL18062qLNF" , "cJlWyzoEGI3WyqQ8mUwo0VORAAVtRoXMdwiRBZnw" );



        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        //Optionally enable public read access.
        defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
    }
}
