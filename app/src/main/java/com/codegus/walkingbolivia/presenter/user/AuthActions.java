package com.codegus.walkingbolivia.presenter.user;

import android.widget.Toast;

import androidx.annotation.NonNull;

import com.codegus.walkingbolivia.MainActivity;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

/**
 * extends AppCompatActivity es para que se pueda sobreescribir el método onActivityResult
 */
public class AuthActions{

    private final MainActivity context;

     // seguda forma de iniciar sesión
     private FirebaseAuth firebaseAuth;
     private FirebaseAuth.AuthStateListener authStateListener;
    private static final int REQUEST_CODE = 1001;
    private final List<AuthUI.IdpConfig> provider = Arrays.asList(
         new AuthUI.IdpConfig.EmailBuilder().build(),
         new AuthUI.IdpConfig.FacebookBuilder().build(),
         new AuthUI.IdpConfig.GoogleBuilder().build()
     ); // contendrá los tipos de inicio de sesión que tendrá ala aplicación

    public AuthActions(final MainActivity context){
        this.context = context;
    }

    public void init(){
         firebaseAuth = FirebaseAuth.getInstance();
         authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){
                    context.signInSuccess(user);
                }else {
                    context.startActivityForResult(AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setAvailableProviders(provider)
                    .setIsSmartLockEnabled(false)
                    .build(),
                    REQUEST_CODE
                    );
                }
            }
        };

    }

    public void onResume(){
        firebaseAuth.addAuthStateListener(authStateListener);
    }

    public void onPause(){
        firebaseAuth.removeAuthStateListener(authStateListener);
    }

    public void signOut(){
        AuthUI.getInstance()
                .signOut(context)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(context, "", Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
