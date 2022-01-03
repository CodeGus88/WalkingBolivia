package com.codegus.walkingbolivia.interfaces.user;

import com.google.firebase.auth.FirebaseUser;

public interface AuthUserInterface {

    void signInSuccess(FirebaseUser user);

}
