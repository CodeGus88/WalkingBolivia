package com.codegus.walkingbolivia.ui.places;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.codegus.walkingbolivia.R;
import com.codegus.walkingbolivia.models.Country.BolivianDepartaments;
import com.codegus.walkingbolivia.presenter.places.CreatePlaceActivityEvents;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

public class CreatePlaceActivity extends AppCompatActivity {

    // COMPONENTES DE LA VISTA POR CAMPOS
    private TextInputLayout tilPlaceName;
    private EditText etPlaceName;
    //..................
    private TextInputLayout tilPlaceResume;
    private EditText etPlaceResume;
    //..................
    private TextInputLayout tilContent;
    private EditText etContent;
    //..................
    private TextInputLayout tilKeywords;
    private EditText etKeywords;
    //..................
    private TextInputLayout tilAddess;
    private EditText etAddress;
    //..................
    private SearchableSpinner spDepartaments;
    private SearchableSpinner spProvinces;
    //..................
    private ImageButton btnSetLocate;
    private TextView tvLatitude;
    private TextView tvLongitude;
    //...................
    private Button btnSelectPhoto;
    private ImageView ivPhoto;
    //...................
    private Button btnCancel;
    private Button btnStore;

    private Gson json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_place);

        initComponents();
    }

    private void initComponents(){
        etPlaceName = findViewById(R.id.etPlaceName);
        etPlaceResume = findViewById(R.id.etPlaceResume);
        etContent = findViewById(R.id.etContent);
        etKeywords = findViewById(R.id.etKeywords);
        etAddress = findViewById(R.id.etAddress);
        spDepartaments = (SearchableSpinner) findViewById(R.id.spDepartaments);
        spProvinces = (SearchableSpinner) findViewById(R.id.spProvinces);
        btnSetLocate = findViewById(R.id.btnSetLocate);
        tvLatitude = findViewById(R.id.tvLatitude);
        tvLongitude = findViewById(R.id.tvLongitude);
        btnSelectPhoto = findViewById(R.id.btnSelectPhoto);
        ivPhoto = findViewById(R.id.ivPhoto);
        btnCancel = findViewById(R.id.btnCancel);
        btnStore = findViewById(R.id.btnStore);

        // Llenar los datos en los spinners
        BolivianDepartaments regions = new BolivianDepartaments();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_item, regions.getDepartamentVector(false));
        spDepartaments.setAdapter(adapter);

        spDepartaments.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(CreatePlaceActivity.this, adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
                loadProvinces(adapterView.getItemAtPosition(i).toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        // Eventos
        CreatePlaceActivityEvents createPlaceActivityEvents = new CreatePlaceActivityEvents(this);
        btnSetLocate.setOnClickListener(createPlaceActivityEvents);
        btnSelectPhoto.setOnClickListener(createPlaceActivityEvents);
        btnCancel.setOnClickListener(createPlaceActivityEvents);
        btnStore.setOnClickListener(createPlaceActivityEvents);
    }

    private void loadProvinces(String country){
        BolivianDepartaments regions = new BolivianDepartaments();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_item, regions.getDepartamentSubregionsVector(country, true));
        spProvinces.setAdapter(adapter);
        spProvinces.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(CreatePlaceActivity.this, regions.getDepartamentSubregionsVector(country, false)[i], Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


}