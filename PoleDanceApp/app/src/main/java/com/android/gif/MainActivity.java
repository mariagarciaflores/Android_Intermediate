package com.android.gif;


import java.io.InputStream;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.graphics.*;
import android.widget.Toast;

public class MainActivity extends ImageGifCreate {
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GIFView(this));
    }
    private class GIFView extends View{
    	
    	Movie movie, movie1, movie2, movie3;
    	InputStream is = null, is1 = null, is2 = null, is3 = null;
    	long moviestart;
    	long moviestart1;
        long moviestart2;
        long moviestart3;
		public GIFView(Context context) {
			super(context);
			is=context.getResources().openRawResource(R.drawable.poledancetitle);
			is1=context.getResources().openRawResource(R.drawable.poledance);
            is2=context.getResources().openRawResource(R.drawable.poledeadpol);
            is3=context.getResources().openRawResource(R.drawable.poleturtle);
			movie=Movie.decodeStream(is);
			movie1=Movie.decodeStream(is1);
            movie2=Movie.decodeStream(is2);
            movie3=Movie.decodeStream(is3);
		}
		
    	@Override
    	protected void onDraw(Canvas canvas) {
    		canvas.drawColor(0xff000000);
    		super.onDraw(canvas);
    		long now=android.os.SystemClock.uptimeMillis();
    		System.out.println("now="+now);
    		 if (moviestart == 0) {   // first time
                 moviestart = now;
                 
             }
    		 if(moviestart1==0)
    		 {
    			 moviestart1=now;
    		 }
            if(moviestart2==0)
            {
                moviestart2=now;
            }
            if(moviestart3==0)
            {
                moviestart3=now;
            }
    		 System.out.println("\tmoviestart="+moviestart);
    		 int relTime = (int)((now - moviestart) % movie.duration()) ;
    		 int relTime1=(int)((now - moviestart1)% movie1.duration());
            int relTime2=(int)((now - moviestart2)% movie2.duration());
            int relTime3=(int)((now - moviestart3)% movie3.duration());
    		 System.out.println("time=" + relTime + "\treltime=" + movie.duration());
            movie.setTime(relTime);
            movie1.setTime(relTime1);
            movie2.setTime(relTime2);
            movie3.setTime(relTime3);
            movie.draw(canvas, 30, 30);
            movie1.draw(canvas, 80, 200);
            movie2.draw(canvas, 0, 490);
            //movie3.draw(canvas, 90, 470);
            this.invalidate();

			setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast toast1 =
                            Toast.makeText(getContext(),
                                    "Let's learn!!!!", Toast.LENGTH_SHORT);
                    toast1.show();
                    Intent intent = new Intent(MainActivity.this, GalleryActivity.class);
                    startActivity(intent);
				}
			});
    	}
    }
}