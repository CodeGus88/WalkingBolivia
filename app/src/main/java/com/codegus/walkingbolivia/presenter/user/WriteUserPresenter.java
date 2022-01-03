package com.codegus.walkingbolivia.presenter.user;

import com.codegus.walkingbolivia.R;
import com.codegus.walkingbolivia.interfaces.user.WriteUserInterface;
import com.codegus.walkingbolivia.models.Value;
import com.codegus.walkingbolivia.models.user.User;
import com.codegus.walkingbolivia.models.user.WriteUserModel;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;

import java.util.Date;
import java.util.Map;

public class WriteUserPresenter implements WriteUserInterface.Presenter {


    private WriteUserInterface.View view;
    private WriteUserInterface.Model model;

    public WriteUserPresenter(WriteUserInterface.View view){
        this.view = view;
        model = new WriteUserModel(this);
    }


    @Override
    public void userExistRequest(String id) {
        model.userExistRequest(id);
    }

    @Override
    public void showUserRequest(Task<DocumentSnapshot> task) {
        User oldUser = new User();
        if(task.getResult().exists()){
            Map<String, Object> usr = task.getResult().getData();
            if(usr.containsKey("id")) oldUser.setId(usr.get("id").toString());
            if(usr.containsKey("name")) oldUser.setName(usr.get("name").toString());
            if(usr.containsKey("email")) oldUser.setEmail(usr.get("email").toString());
            if(usr.containsKey("role")) oldUser.setRole(usr.get("role").toString());
            if(usr.containsKey("photoUrl")) oldUser.setPhotoUrl(usr.get("photoUrl").toString());
            if(usr.containsKey("date")) oldUser.setDate(Long.parseLong(usr.get("date").toString()));
            if(usr.containsKey("update")) oldUser.setUpdate(Long.parseLong(usr.get("update").toString()));

        }
        view.userExist(task.getResult().exists(), oldUser);
    }

    @Override
    public void showSuccess(int actionCode) {
        if(actionCode == Value.CREATE)
            view.showSuccess(R.string.create_user_success);
        else if(actionCode == Value.UPDATE)
            view.showSuccess(R.string.update_user_success);
        else if(actionCode == Value.DELETE){
            view.showSuccess(R.string.delete_user_success);
        }
    }

    @Override
    public void showError(int actionCode, String exceptionError) {
        if(Value.CREATE == actionCode)
            view.showError(R.string.create_user_error, exceptionError);
        else if(Value.UPDATE == actionCode)
            view.showError(R.string.update_user_error, exceptionError);
        else if(Value.DELETE == actionCode)
            view.showError(R.string.delete_user_error, exceptionError);
    }

    @Override
    public void createUser(User user) {
        user.setDate(new Date().getTime());
        model.createUser(user);
    }

    @Override
    public void updateUser(User user) {
        user.setUpdate(new Date().getTime());
        model.updateUser(user);
    }

    @Override
    public void updateUser(User user, User oldUser) {
        if(oldUser != null){
            if( !user.getName().equals(oldUser.getName())
                    || !user.getEmail().equals(oldUser.getEmail())
                    || !user.getPhotoUrl().equals(oldUser.getPhotoUrl())
            ){
                user.setDate(oldUser.getDate());
                user.setUpdate(new Date().getTime());
                model.updateUser(user);
            }
        }
    }

    @Override
    public void deleteUser(String id) {
        model.deleteUser(id);
    }
}
