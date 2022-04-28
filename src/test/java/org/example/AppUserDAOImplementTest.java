package org.example;

import junit.framework.TestCase;
import org.example.Models.AppUser;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.awt.*;

public class AppUserDAOImplementTest {

    private AppUser user1 = new AppUser("username1", "paswword1", AppRole.APP_ROLE_USER);
    private AppUser user2 = new AppUser("username2", "paswword2", AppRole.APP_ROLE_USER);
    private AppUserDAOImplement appUserDAO = new AppUserDAOImplement();


    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnException_PersistWithNullValue() {
        appUserDAO.persist(null);
    }

    @Test
    public void shouldReturnObject_PersistWithValue() {
        Assert.assertNotNull(appUserDAO.persist(user1));
    }

    @Test
    public void shouldReturnObject_PersistWithTwoDifferentValues() {
        AppUser userTmp = new AppUser("usernametmp", "passtmp", AppRole.APP_ROLE_USER);
        AppUser au1 = appUserDAO.persist(user1);
        AppUser au2 = appUserDAO.persist(userTmp);
        Assert.assertNotNull(appUserDAO.persist(user2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnException_PersistDuplicateValues() {
        appUserDAO.persist(user1);
        appUserDAO.persist(user1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnException_findByUsernameWithNullValue() {
        appUserDAO.findByUserName(null);
    }

    @Test
    public void shouldReturnAnObject_findByUsernameWithValue() {
        AppUser userTmp = new AppUser("username---", "passt---", AppRole.APP_ROLE_USER);
        appUserDAO.persist(userTmp);
        Assert.assertNotNull(appUserDAO.findByUserName(userTmp.getUsername()));
    }

    @Test
    public void shouldReturnListOfAppUsers() {
        Assert.assertNotNull(appUserDAO.findAll());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnException_removeWithNullValue() {
        Assert.assertTrue(appUserDAO.remove(null));
    }

    @Test
    public void shouldReturnTrue_removeWithValue() {
        AppUser userTmp = new AppUser("username---2", "passt---2", AppRole.APP_ROLE_USER);
        appUserDAO.persist(userTmp);
        Assert.assertTrue(appUserDAO.remove(userTmp.getId()));
    }

    @Test
    public void shouldReturnNull_removeWithValue() {
        AppUser userTmp = new AppUser("username---2", "passt---2", AppRole.APP_ROLE_USER);
        appUserDAO.persist(userTmp);
        appUserDAO.remove(userTmp.getId());
        Assert.assertNull(appUserDAO.findByUserName(userTmp.getUsername()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnException_removeWithNonExistingValue() {
        appUserDAO.remove("--");
    }
}