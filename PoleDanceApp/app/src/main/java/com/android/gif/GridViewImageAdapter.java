package com.android.gif;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by Griss Garcia on 16/08/2015.
 */
public class GridViewImageAdapter extends BaseAdapter {
    private Context mContext;
    private Set<Integer> poleimages = MapCreator.getInstance().getPoleImageVideos().keySet();
    private ArrayList<Integer> listPhoto = new ArrayList<>();

    public GridViewImageAdapter(Context c){
        mContext = c;
        fillGrid();
    }

    private void fillGrid() {
        poleimages.toArray();
        for (Integer i : poleimages) {
            listPhoto.add(i);
        }
    }

    @Override
    public int getCount() {

        return listPhoto.size();
    }

    @Override
    public Object getItem(int position) {
        return listPhoto.get(position);
    }



    @Override
    public long getItemId(int position) {
        return 0;
    }

    public int getImageId(int position) {
        return listPhoto.get(position);
    }

    @Override
    public View getView(int position, View view, ViewGroup viewgroup) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(listPhoto.get(position));
        imageView.setScaleType( ImageView.ScaleType.CENTER_CROP );
        imageView.setLayoutParams(new GridView.LayoutParams(250, 250));
        return imageView;
    }


}
