package com.example.doan.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.doan.R;
import com.google.android.gms.maps.GoogleMap;


public class LienHeActivity extends AppCompatActivity {

    private GoogleMap mMap;
    Toolbar toolbarLienhe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lien_he);
        toolbarLienhe = (Toolbar) findViewById(R.id.toolbarContact);
        ActionBar();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
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
    private void ActionBar() {
        setSupportActionBar(toolbarLienhe);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarLienhe.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        // Add a marker in Sydney, Australia,
//        // and move the map's camera to the same location.
//        LatLng sydney = new LatLng(15.975248, 108.253216);
//        googleMap.addMarker(new MarkerOptions()
//                .position(sydney)
//                .title("Trường Đại học CNTT và TT Việt - Hàn")
//                .snippet("470 Đường Trần Đại Nghĩa, Hoà Hải, Ngũ Hành Sơn, Đà Nẵng")
//                .icon(BitmapDescriptorFactory.defaultMarker()));
//        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
//        CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(15).build();
//        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
//    }
}