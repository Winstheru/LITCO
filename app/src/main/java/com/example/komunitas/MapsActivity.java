package com.example.komunitas;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,
        GoogleMap.OnInfoWindowClickListener,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

    private GoogleMap mMap;
    SupportMapFragment mapFragment;
    SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        searchView = findViewById(R.id.sv_location);
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String location = searchView.getQuery().toString();
                List<Address> addressList = null;

                if (location != null || !location.equals("")) {
                    Geocoder geocoder = new Geocoder(MapsActivity.this);
                    try {
                        addressList = geocoder.getFromLocationName(location, 1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Address address = addressList.get(0);
                    LatLng latlng = new LatLng(address.getLatitude(), address.getLongitude());
                    mMap.addMarker(new MarkerOptions().position(latlng).title(location));
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 13));
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        mapFragment.getMapAsync(this);


//        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
//            @Override
//            public View getInfoWindow(Marker arg0) {
//                View v = getLayoutInflater().inflate(R.layout.custom_info_window, null);
//                return v;
//            }
//
//            @Override
//            public View getInfoContents(Marker arg0) {
//                return null;
//            }
//        });
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
        mMap.addMarker(new MarkerOptions().position(uph).title("Universitas Pelita Harapan Medan").snippet("Jl. Imam Bonjol No. 6, Lippo Plaza Lantai 5 - 7")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.icon48)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(uph));

        //marker dilo medan
        LatLng dilo = new LatLng(3.571, 98.67);
        mMap.addMarker(new MarkerOptions().position(dilo).title("DILO Medan").snippet("Jl. Monginsidi No.6")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.icon48)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(dilo));

        //marker Cradle
        LatLng cradle = new LatLng(3.585, 98.66);
        mMap.addMarker(new MarkerOptions().position(cradle).title("Cradle Event & Co-working Space").snippet("Jl. S. Parman No 217")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.icon48)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cradle));

        //marker Time Dev Club
        LatLng timedev = new LatLng(3.586, 98.68);
        mMap.addMarker(new MarkerOptions().position(timedev).title("Time Developer Club").snippet("Jl. Merbabu No.32 aa-bb")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.icon48)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(timedev));

        LatLng MEDAN = new LatLng(3.594977, 98.674294);
        mMap.addMarker(new MarkerOptions()
                .position(MEDAN)
                .title("Medan")
                .snippet("Beberapa Komunitas IT yang aktif adalah Kongkow IT Medan, DevC Medan, Cloud Study Jam Medan")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.icon48))
                .zIndex(1.0f));
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(MEDAN, 17);
        mMap.animateCamera(update);

//        LatLng BALI = new LatLng(-8.316677, 115.089341);
//        mMap.addMarker(new MarkerOptions()
//                .position(BALI)
//                .title("Bali")
//                .snippet("Beberapa Komunitas IT yang aktif adalah Bali JS, Bali Dev")
//                .icon(BitmapDescriptorFactory.fromResource(R.drawable.icon48)));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(BALI));

        //marker Time Dev Club
        LatLng bali = new LatLng(-8.316677, 115.089341);
        mMap.addMarker(new MarkerOptions().position(bali).title("BALI").snippet("Beberapa Komunitas IT yang aktif adalah Bali JS, Bali Dev")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.icon48)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bali));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mMap.setMyLocationEnabled(true);
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Toast.makeText(this, "Info click ",
                Toast.LENGTH_SHORT).show();
    }
}
