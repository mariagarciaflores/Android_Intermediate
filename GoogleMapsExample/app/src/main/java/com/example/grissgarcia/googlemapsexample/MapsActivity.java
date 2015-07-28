package com.example.grissgarcia.googlemapsexample;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseAnalytics;
import com.parse.ParseCrashReporting;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private boolean mapExist = false;
    private TextView txtPharmacyName;
    private TextView txtCity;
    private TextView txtAdress;
    private TextView txtHoursOfOperation;
    private static final String CLASS_NAME = "Pharmacy";
    private List<ParseObject> pharmacies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        txtPharmacyName = (TextView) findViewById(R.id.txt_pharma_name);
        txtCity         = (TextView) findViewById(R.id.txt_city);
        txtAdress       = (TextView) findViewById(R.id.txt_address);
        txtHoursOfOperation = (TextView) findViewById(R.id.txt_hours);

        ParseAnalytics.trackAppOpenedInBackground(getIntent());
        Parse.enableLocalDatastore(this);
        Parse.initialize(this);

        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();

        try {
            pharmacies = getUpdateList();
            setUpMapIfNeeded();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                for (ParseObject pharma : pharmacies) {
                    LatLng pharmaPosition = new LatLng(pharma.getParseGeoPoint("location").getLatitude(), pharma.getParseGeoPoint("location").getLongitude());
                    if (marker.getPosition().equals(pharmaPosition)) {
                        marker.setTitle(pharma.getString("pharmacyName"));
                        txtPharmacyName.setText("Farmacia: " + pharma.getString("pharmacyName"));
                        txtCity.setText("Ciudad: " + pharma.getString("city"));
                        txtAdress.setText("Direccion :" + pharma.getString("address"));
                        txtHoursOfOperation.setText("Horario de At: " + pharma.getString("hoursOfOperation"));
                        return true;
                    }
                }
                return false;
            }
        });


    }

    public List<ParseObject> getUpdateList() throws com.parse.ParseException {
        ParseQuery<ParseObject> query = ParseQuery.getQuery(CLASS_NAME);
        query.whereEqualTo("Activated", true);
        final List<ParseObject> pharmaList = query.find();
        return pharmaList;
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            mMap.setBuildingsEnabled(true);
            mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            mMap.setMyLocationEnabled(true);

            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                mapExist = true;
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        for (ParseObject place : pharmacies) {
            LatLng location = new LatLng(place.getParseGeoPoint("location").getLatitude(), place.getParseGeoPoint("location").getLongitude());
            String pharmaName = place.getString("pharmacyName");
            mMap.addMarker(new MarkerOptions().position(location).snippet(pharmaName).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).alpha(0.7f));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 14f));
        }
        animateToPlace(pharmacies.get(0));
    }

    private void animateToPlace(ParseObject pharma) {
        String name = pharma.getString("pharmacyName");
        String city = pharma.getString("city");
        String address = pharma.getString("address");
        String atencion = pharma.getString("hoursOfOperation");
        txtPharmacyName.setText("Farmacia: " + name);
        txtCity.setText("Ciudad: " + city);
        txtAdress.setText("Direccion: " + address);
        txtHoursOfOperation.setText("Horario de At: " + atencion);
    }

}
