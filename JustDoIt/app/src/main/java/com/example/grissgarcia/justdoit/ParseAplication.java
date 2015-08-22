package com.example.grissgarcia.justdoit;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseCrashReporting;
import com.parse.ParseUser;

/**
 * Created by Griss Garcia on 20/08/2015.
 */
public class ParseAplication extends com.activeandroid.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ActiveAndroid.initialize(this);

        Parse.enableLocalDatastore(this);
        ParseCrashReporting.enable(this);


        Parse.initialize(this);



        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
    }
}
