package com.codegus.walkingbolivia;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.codegus.walkingbolivia.databinding.ActivityMainBinding;
import com.codegus.walkingbolivia.interfaces.user.AuthUserInterface;
import com.codegus.walkingbolivia.interfaces.user.WriteUserInterface;
import com.codegus.walkingbolivia.models.user.User;
import com.codegus.walkingbolivia.presenter.user.AuthActions;
import com.codegus.walkingbolivia.presenter.user.UserClick;
import com.codegus.walkingbolivia.presenter.user.WriteUserPresenter;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.AlertDialog;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseUser;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements AuthUserInterface, WriteUserInterface.View {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    // instancias
    private AuthActions authActions;
    private UserClick userClick;
    private FirebaseUser user;

    private ImageView imageView;
    private TextView tvUserName, tvMail;

    // opciones del alert
    private AlertDialog alertDialog;
    private ImageView ivAvatar;
    private TextView tvId, tvFulname, tvEmail, btnOk, btnSignOut;

    // Presentadores
    private WriteUserPresenter writeUserPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        binding.appBarMain.fab.setOnClickListener((View view)->{
            Snackbar.make(view, "Replace with your own action - > ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
        });

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_places, R.id.nav_travel_agencies,
                R.id.nav_hotels, R.id.nav_meal, R.id.nav_restaurants, R.id.nav_saved,
                R.id.nav_options, R.id.nav_about_as)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        // iniciar instancias
        userClick = new UserClick(this);
        initComponents();
        authActions = new AuthActions(this);
        authActions.init();

         // inicializar presentador
        writeUserPresenter = new WriteUserPresenter(this);

    }


    private void initComponents(){
        NavigationView navigationView =  findViewById(R.id.nav_view);
        View header =  navigationView.getHeaderView(0);
        imageView = header.findViewById(R.id.imageView);
        imageView.setOnClickListener(userClick);

        tvUserName = header.findViewById(R.id.tvUserName);
        tvMail = header.findViewById(R.id.tvEmail);

        // inicializar componentes del alert
        View viewAlert = getLayoutInflater().inflate(R.layout.alert_user_sesion, null);
        ivAvatar = viewAlert.findViewById(R.id.ivUserImage);
        tvId = viewAlert.findViewById(R.id.tvID);
        tvFulname = viewAlert.findViewById(R.id.tvFulName);
        tvEmail = viewAlert.findViewById(R.id.tvUserEmail);
        btnOk = viewAlert.findViewById(R.id.btnOk);
        btnSignOut = viewAlert.findViewById(R.id.btnSignOut);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(viewAlert);
        alertDialog = builder.create();
//        ivAvatar.setOnClickListener(userClick);
        btnSignOut.setOnClickListener(userClick);
        btnOk.setOnClickListener(userClick);

    }

    public void showAlert(boolean acction){
        if(acction){
            Glide.with(MainActivity.this).load(user.getPhotoUrl()).into(ivAvatar);
            tvId.setText(user.getUid());
            tvFulname.setText(user.getDisplayName());
            tvEmail.setText(user.getEmail());
            alertDialog.show();
        }else
            alertDialog.dismiss();
    }


    @Override
    protected void onResume() {
        super.onResume();
        authActions.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        authActions.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void signInSuccess(FirebaseUser user) {
        User u = new User(
            user.getUid(),
            user.getDisplayName(),
            user.getEmail(),
            "Admin",
            user.getPhotoUrl().toString()
        );
        writeUserPresenter.userExistRequest(u.getId());
        Glide.with(MainActivity.this).load(user.getPhotoUrl()).into(imageView);
        this.user = user;
        tvUserName.setText(user.getDisplayName());
        tvMail.setText(user.getEmail());
    }

    public void signOut(){
        authActions.signOut();
    }


    @Override
    public void userExist(boolean exist, User oldUser) {
        User u = new User(
                user.getUid(),
                user.getDisplayName(),
                user.getEmail(),
                "Admin",
                user.getPhotoUrl().toString()
        );
        if(!exist){
            u.setDate(new Date().getTime());
            writeUserPresenter.createUser(u);
        }else
            writeUserPresenter.updateUser(u, oldUser);
    }

    @Override
    public void showSuccess(int messageCode) {
        Toast.makeText(this, getString(messageCode), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(int messageCode, String explicidError) {
//        Toast.makeText(this, getString(messageCode) + "\n" + explicidError, Toast.LENGTH_SHORT).show();
    }
}