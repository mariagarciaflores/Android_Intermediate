package com.android.gif;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

class ImageGifCreate extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(View view) {
        if (false) { // set to true to test Picture
            ViewGroup vg = new ImageGifLayout(this);
            vg.addView(view);
            view = vg;
        }
        
        super.setContentView(view);
    }
}

