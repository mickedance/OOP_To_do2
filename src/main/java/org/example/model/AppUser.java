package org.example.model;

import org.example.util.Validation;

import java.util.Objects;
import java.util.UUID;

public class AppUser implements Validation {
    private String id;
    private String username;
    private String password;
    private AppRole role;

    public AppUser(String username, String password, AppRole role) {
        setUsername(username);
        setPassword(password);
        setRole(role);
        setId();
    }

    public String getId() {
        return id;
    }
    private void setId(){
        this.id = UUID.randomUUID().toString();
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        Validation.stringIsNotNullAndNotEmpty.accept(username, "userName");
        this.username = username;
    }


    public void setPassword(String password) {
        Validation.stringIsNotNullAndNotEmpty.accept(password, "password");
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public AppRole getRole() {
        return role;
    }

    public void setRole(AppRole role) {
        Validation.AppRoleIsNotEmpty.accept(role, "AppRole");
        this.role = role;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "usernane='" + username + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return username.equals(appUser.username) && role == appUser.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, role);
    }
}
