package com.codegus.walkingbolivia.presenter.maps;

import android.content.Context;
import android.content.Intent;

import com.codegus.walkingbolivia.ui.maps.SetLocationMapActivity;

import java.util.Hashtable;

public class MapNavigation {

    public static void showSetLocation(Context context, String json){
        Intent intent = new Intent(context, SetLocationMapActivity.class);
        intent.putExtra("json", json);
        context.startActivity(intent);
    }

}
