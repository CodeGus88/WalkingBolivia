package com.codegus.walkingbolivia.interfaces.user;

import com.codegus.walkingbolivia.models.user.User;

import java.util.ArrayList;
import java.util.List;

public interface ReadUserInterface {

    interface View{
        void showUser(User user);
        void showUserList(List<User> user);
    }

    interface Presenter{
        void showUser(User  user);
        void showUserList(ArrayList<User> userList);
        void searchUser(String id);
        void loadUserList();
    }

    interface Model{
        void searchUser(String id);
        void loadAllUsers();
    }

}
