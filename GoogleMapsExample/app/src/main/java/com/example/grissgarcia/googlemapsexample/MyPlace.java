package com.example.grissgarcia.googlemapsexample;

import com.google.android.gms.maps.model.LatLng;
import com.parse.ParseGeoPoint;

/**
 * Created by Griss Garcia on 14/07/2015.
 */
public class MyPlace {
    private String name;
    private LatLng latlng;

    public MyPlace(String name, double lat, double lng) {
        this.name = name;
        this.latlng = new LatLng(lat, lng);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LatLng getLatlng() {
        return latlng;
    }

    public void setLatlng(LatLng latlng) {
        this.latlng = latlng;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MyPlace {");
        sb.append("name='").append(name).append('\'');
        sb.append(", latLng=").append(latlng.latitude).append(",").append(latlng.longitude);
        sb.append('}');
        return sb.toString();
    }
}

