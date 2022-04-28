package org.example;

import org.example.Models.AppUser;

import java.util.ArrayList;
import java.util.List;

public class AppUserDAOImplement implements AppUserDAO {

    public List<AppUser> listOfUsers;

    public AppUserDAOImplement() {
        listOfUsers = new ArrayList<>();

    }

    @Override
    public AppUser persist(AppUser user) {
        if (user == null) throw new IllegalArgumentException("user to add was null");
        if (listOfUsers == null) listOfUsers = new ArrayList<>();
        if (findByUserName(user.getUsername()) != null)
            throw new IllegalArgumentException("Username: " + user.getUsername() + " already exists");

        if (listOfUsers.add(user))
            return user;

        return null;
    }

    private AppUser findById(String userId) {
        if (userId == null) throw new IllegalArgumentException("userId was null");

        for (AppUser user : listOfUsers) {
            if (user.getId().equals(userId))
                return user;
        }
        return null;
    }

    @Override
    public AppUser findByUserName(String name) {
        if (name == null) throw new IllegalArgumentException("name to find was null");
        for (AppUser user : listOfUsers) {
            if (user.getUsername().equalsIgnoreCase(name))
                return user;
        }
        return null;
    }

    @Override
    public List<AppUser> findAll() {
        return listOfUsers;
    }

    @Override
    public boolean remove(String userId) {
        if (userId == null) throw new IllegalArgumentException("user id was null");
        AppUser user = findById(userId);
        if (user == null) throw new IllegalArgumentException("user to remove was not found");
        return listOfUsers.remove(user);
    }


}