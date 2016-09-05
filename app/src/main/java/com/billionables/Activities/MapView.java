package com.billionables.Activities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import com.billionables.Maps.Coordinates;
import com.billionables.Maps.MapUtils;
import com.billionables.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapView extends AppCompatActivity implements OnMapReadyCallback, Coordinates {

    private static final int REQUEST_LOCATION = 1000;
    public double latitude;
    public double longitude;
    private GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_view);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // Check Permissions Now
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        } else {
            // permission has been granted, continue as usual
            getLocation(null);
          /*  MapUtils.requestCoordinates(MapView.this);*/
            this.googleMap.setMyLocationEnabled(true);

        }
    }

    @Override
    public void getLocation(Location location) {
        double latitude = 28.6369691;
        double longitude = 77.2859136;
        CameraUpdate center = CameraUpdateFactory.newLatLng(new LatLng(latitude, longitude));
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(17);
        googleMap.moveCamera(center);
        googleMap.animateCamera(zoom);
        setMarker(latitude, longitude);

    }

    private void setMarker(double latitude, double longitude) {
        final MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(new LatLng(latitude, longitude));
        markerOptions.title("V3S Mall");
        googleMap.addMarker(markerOptions);
    }
}
