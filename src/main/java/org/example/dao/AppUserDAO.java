package org.example.dao;

import org.example.model.AppUser;

public interface AppUserDAO extends CrudInterface<AppUser, String>{

    AppUser findByUserName(String name);

}
