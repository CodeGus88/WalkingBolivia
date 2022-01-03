package com.codegus.walkingbolivia.ui.maps;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.codegus.walkingbolivia.R;
import com.codegus.walkingbolivia.databinding.ActivitySetLocationMapBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Hashtable;

public class SetLocationMapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
//    private ActivityMapsBinding binding;
    private ActivitySetLocationMapBinding binding;
    private Spinner spMapSelector;
    private Button btnSet, btnBack;

    //

    private Marker marker;

    private String json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        binding = ActivitySetLocationMapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        if(getIntent().getExtras().containsKey("json")){
            json = getIntent().getStringExtra("json");
        }else json = "";

        initComponents();

    }

    private void initComponents(){
        spMapSelector = findViewById(R.id.spMapSelector);
        btnSet = findViewById(R.id.btnSet);
        btnBack = findViewById(R.id.btnBack);
        // iniciar opciones del spinner
        String [] options = {
//                "",// getString(GoogleMap.MAP_TYPE_NONE), // (0)
                getString(R.string.sp_normal_option), // getString(GoogleMap.MAP_TYPE_NORMAL),  // (1)
                getString(R.string.sp_satellite_option), // getString(GoogleMap.MAP_TYPE_SATELLITE), (2)
                getString(R.string.sp_terrain_option), // getString(GoogleMap.MAP_TYPE_TERRAIN), // (3)
                getString(R.string.sp_hibrid_option)// getString(GoogleMap.MAP_TYPE_HYBRID) // (4)
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_item, options);
        spMapSelector.setAdapter(adapter);

        spMapSelector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                id++;
                Log.d("mapType", id + "");
                if(id == GoogleMap.MAP_TYPE_NONE)
                    mMap.setMapType(GoogleMap.MAP_TYPE_NONE);
                else if(id == GoogleMap.MAP_TYPE_NORMAL)
                    mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                else if(id == GoogleMap.MAP_TYPE_SATELLITE)
                    mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                else if(id == GoogleMap.MAP_TYPE_TERRAIN)
                    mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                else if(id == GoogleMap.MAP_TYPE_HYBRID)
                    mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    private void configureMap(){
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setMapToolbarEnabled(false);
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
        LatLng searchLocation = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(searchLocation).icon(getBitMap(this, R.drawable.location_icon)).title(getString(R.string.marker_set_location_title)).draggable(true));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(searchLocation));
        configureMap();
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(searchLocation, 16.5F));
    }


    /**
     * Crear un bitmap a partir de un recurso
     * @param context
     * @param vectorResId
     * @return bitmap
     */
    private BitmapDescriptor getBitMap(Context context, int vectorResId) {
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
}