package org.example;

import org.example.Models.AppUser;
import org.junit.Assert;
import org.junit.Test;

public class AppUserTest {
    @Test
    public void _valid_param_should_be_successfully(){
        String username = "Micke";
        String password = "pasword123";
        AppUser appUser;
        try {
            appUser = new AppUser(username, password, AppRole.APP_ROLE_ADMIN);
            Assert.assertNotNull(appUser);
            Assert.assertEquals(appUser.getUsername(), username);
            Assert.assertEquals(appUser.getRole(), AppRole.APP_ROLE_ADMIN);
        }catch (Exception e){}


    }
    @Test
    public void _set_username_should_return_new_name(){
        AppUser appUser = new AppUser("micke", "password", AppRole.APP_ROLE_USER);
        String newUserName = "Kalle";
        appUser.setUsername(newUserName);
        Assert.assertEquals(appUser.getUsername(), newUserName);
    }
    @Test
    public void _set_user_role_should_return_new_role(){
        AppUser appUser = new AppUser("micke", "password", AppRole.APP_ROLE_USER);
        AppRole role = AppRole.APP_ROLE_ADMIN;
        appUser.setRole(role);
        Assert.assertEquals(appUser.getRole(), role);
    }
    @Test
    public void _set_password_should_return_new_password(){
        AppUser appUser = new AppUser("micke", "password", AppRole.APP_ROLE_USER);
        String password = "newPassword213";
        appUser.setPassword(password);
        Assert.assertEquals(appUser.getPassword(), password);
    }
    @Test(expected = IllegalArgumentException.class)
    public void _null_values_should_be_declined_in_constructor_param_1() {
        AppUser appUser = new AppUser(null, "password", AppRole.APP_ROLE_USER);
    };

    @Test(expected = IllegalArgumentException.class)
    public void _null_values_should_be_declined_in_constructor_param_2() {
        AppUser appUser = new AppUser("username", null, AppRole.APP_ROLE_USER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void _null_values_should_be_declined_in_constructor_param_3() {
        AppUser appUser = new AppUser("username", "password", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void _empty_values_should_be_declined_in_constructor_param_1() {
        AppUser appUser = new AppUser("", "password", AppRole.APP_ROLE_USER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void _empty_values_should_be_declined_in_constructor_param_2() {
        AppUser appUser = new AppUser("username", "", AppRole.APP_ROLE_USER);
    }
}