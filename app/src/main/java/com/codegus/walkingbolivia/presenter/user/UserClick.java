package com.codegus.walkingbolivia.presenter.user;

import android.view.View;
import android.widget.Toast;

import com.codegus.walkingbolivia.MainActivity;
import com.codegus.walkingbolivia.R;

public class UserClick implements View.OnClickListener {

    private MainActivity context;

    public UserClick(MainActivity context){
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageView:
                context.showAlert(true);
                break;
            case R.id.btnOk:
                context.showAlert(false);
                break;
            case R.id.btnSignOut:
                context.showAlert(false);
                context.signOut();
                break;
            default:
                Toast.makeText(context, R.string.alert_invalid_option, Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
