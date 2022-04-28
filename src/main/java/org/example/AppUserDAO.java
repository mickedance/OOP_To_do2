package org.example;

import org.example.Models.AppUser;

public interface AppUserDAO extends CrudInterface<AppUser, String>{

    AppUser findByUserName(String name);

}
