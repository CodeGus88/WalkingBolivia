package com.codegus.walkingbolivia.models.user;
import android.util.Log;

import androidx.annotation.NonNull;

import com.codegus.walkingbolivia.interfaces.user.WriteUserInterface;
import com.codegus.walkingbolivia.models.Collection;
import com.codegus.walkingbolivia.models.Value;
import com.codegus.walkingbolivia.presenter.user.WriteUserPresenter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class WriteUserModel implements WriteUserInterface.Model {

    private final String TAG = "USER PROCCESS";
    private FirebaseFirestore db;
    private WriteUserInterface.Presenter presenter;

    public WriteUserModel(WriteUserPresenter presenter){
        this.db = FirebaseFirestore.getInstance();
        this.presenter = presenter;
    }

    @Override
    public void userExistRequest(String id) {
        db.collection(Collection.USERS).document(id).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                presenter.showUserRequest(task);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                presenter.showError(0, e.getMessage());
            }
        });
    }

    @Override
    public void createUser(User user) {
//        Map<String, Object> usr = new HashMap<>();
//        usr.put("id", user.getId());
//        usr.put("name", user.getName());
//        usr.put("email", user.getEmail());
//        usr.put("photoUrl", user.getPhotoUrl());
//        usr.put("role", user.getRole());
//        usr.put("date", user.getDate());
//        usr.put("update", user.getUpdate());
        db.collection(Collection.USERS)
                .document(user.getId())
                .set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        presenter.showSuccess(Value.CREATE);
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                presenter.showError(Value.CREATE, e.getMessage());
                Log.d("USER_ADD_ERROR", e.getMessage());
            }
        });
    }

    public void updateUser(User user){
        DocumentReference document = db.collection(Collection.USERS).document(user.getId());
        Map<String, Object> usr = new HashMap<>();
        usr.put("id", user.getId());
        usr.put("name", user.getName());
        usr.put("email", user.getEmail());
        usr.put("photoUrl", user.getPhotoUrl());
        usr.put("role", user.getRole());
        usr.put("date", user.getDate());
        usr.put("update", user.getUpdate());
        document.update(usr).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                presenter.showSuccess(Value.UPDATE);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                presenter.showError(Value.UPDATE, e.getMessage());
            }
        });

    }

    @Override
    public void deleteUser(String id) {
        db.collection(Collection.USERS).document(id)
                .delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        presenter.showSuccess(Value.DELETE);
                        Log.d(TAG, "DocumentSnapshot successfully deleted!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        presenter.showError(Value.DELETE, e.getMessage());
                        Log.w(TAG, "Error deleting document", e);
                    }
                });
    }

}
