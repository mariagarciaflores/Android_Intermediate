package com.android.gif;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Griss Garcia on 16/08/2015.
 */
public class GalleryActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_layout);
        //---------->Nuevo codigo
        GridView gridView = (GridView) findViewById( R.id.GridView1 );
        final GridViewImageAdapter adapter = new GridViewImageAdapter(this);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int image = adapter.getImageId(i);
                Intent intent = new Intent(GalleryActivity.this, PoleVideos.class);
                intent.putExtra("imageId", image);
                startActivity(intent);
            }
        });
        gridView.setAdapter(adapter);
        //---------->fin
    }
}
