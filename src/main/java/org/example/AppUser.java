package org.example;

public class AppUser {

    private String username;
    private String password;
    private AppRole role;

    public AppUser(String username, String password, AppRole role) {
        setUsername(username);
        setPassword(password);
        setRole(role);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if(username == null || username.equals("")) throw new IllegalArgumentException("username cannot be empty or null");
        this.username = username;
    }


    public void setPassword(String password) {
        if(password == null || password.equals("")) throw new IllegalArgumentException("password cannot be empty or null");
        this.password = password;
    }

    public AppRole getRole() {
        return role;
    }

    public void setRole(AppRole role) {
        if(role == null ) throw new IllegalArgumentException("Role cannot be null");
        this.role = role;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "usernane='" + username + '\'' +
                ", role=" + role +
                '}';
    }
}
