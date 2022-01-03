package com.codegus.walkingbolivia.presenter.places;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.codegus.walkingbolivia.R;
import com.codegus.walkingbolivia.presenter.maps.MapNavigation;

public class CreatePlaceActivityEvents implements View.OnClickListener {

    private final Context context;

    public CreatePlaceActivityEvents(final Context contex){
        this.context = contex;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId() ){
            case R.id.btnSetLocate:
                MapNavigation.showSetLocation(context, "json");
                break;
            case R.id.btnSelectPhoto:
                Toast.makeText(context, "Presionaste el botón btnSelectPhoto", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnCancel:
                Toast.makeText(context, "Presionaste el botón btnCancel", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnStore:
                Toast.makeText(context, "Presionaste el botón btnStore", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(context, "Invalid option!", Toast.LENGTH_SHORT).show();
        }
    }
}
