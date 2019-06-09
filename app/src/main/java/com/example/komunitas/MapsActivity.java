package com.example.komunitas;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        //marker uph
        LatLng uph = new LatLng(3.59, 98.67);
        mMap.addMarker(new MarkerOptions().position(uph).title("Universitas Pelita Harapan Medan").snippet("Jl. Imam Bonjol No. 6, Lippo Plaza Lantai 5 - 7"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(uph));

        //marker dilo medan
        LatLng dilo = new LatLng(3.571, 98.67);
        mMap.addMarker(new MarkerOptions().position(dilo).title("DILO Medan").snippet("Jl. Monginsidi No.6"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(dilo));

        //marker Cradle
        LatLng cradle = new LatLng(3.585, 98.66);
        mMap.addMarker(new MarkerOptions().position(cradle).title("Cradle Event & Co-working Space").snippet("Jl. S. Parman No 217"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cradle));

        LatLng MEDAN = new LatLng(3.58, 98.67);
        Marker medan = mMap.addMarker(new MarkerOptions()
                .position(MEDAN)
                .title("Medan")
                .snippet("Ibu kota dari Provinsi Sumatera Utara"));
    }
}
