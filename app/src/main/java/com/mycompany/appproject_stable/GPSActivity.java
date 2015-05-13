package com.mycompany.appproject_stable;


import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * Created by ED on 05/13/2015.
 */
public class GPSActivity extends Activity implements LocationListener {

    private LocationManager lm;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gpsClick (View view) {
        getLocation();
    }

    public void getLocation() {
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 500, 1, this);
    }

    @Override
    public void onLocationChanged(Location arg0) {
        String lat = String.valueOf(arg0.getLatitude());
        String lon = String.valueOf(arg0.getLongitude());
        Log.e("GPS", "location changed: lat="+lat+", lon="+lon);
    }
    public void onProviderDisabled(String arg0) {
        Log.e("GPS", "provider disabled " + arg0);
    }
    public void onProviderEnabled(String arg0) {
        Log.e("GPS", "provider enabled " + arg0);
    }
    public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
        Log.e("GPS", "status changed to " + arg0 + " [" + arg1 + "]");
    }
}