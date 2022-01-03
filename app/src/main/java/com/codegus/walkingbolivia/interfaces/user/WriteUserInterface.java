package com.codegus.walkingbolivia.interfaces.user;

import com.codegus.walkingbolivia.models.user.User;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;


public interface WriteUserInterface {

    interface View{
        void userExist(boolean exist, User oldUser);
        void showSuccess(int messageCode);
        void showError(int messageCode, String explicidError);

    }

    interface Presenter{
        void userExistRequest(String id);
        void showUserRequest(Task<DocumentSnapshot> task);
        void showSuccess(int actionCode);
        void showError(int actionCode, String message);
        void createUser(User user);
        void updateUser(User user);
        void updateUser(User user, User oldUser);
        void deleteUser(String id);
    }

    interface Model{
        void userExistRequest(String id);
        void createUser(User user);
        void updateUser(User user);
        void deleteUser(String id);
    }

}
