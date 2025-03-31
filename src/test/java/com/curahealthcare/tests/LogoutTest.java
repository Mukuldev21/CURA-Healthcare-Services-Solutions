package com.curahealthcare.tests;

import com.curahealthcare.pages.LoginPage;
import com.curahealthcare.pages.MenuBarPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest{

    private String username;
    private String password;

    @BeforeMethod(dependsOnMethods = "setUp")
    public void initLogoutTest(){
        // Initialize login credentials from the validLoginData JsonObject
        username = validLoginData.get("username").getAsString();
        password = validLoginData.get("password").getAsString();
    }

    @Test(priority = 1, description = "Verify Logout Functionality")
    public void logout(){

        // First login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginIntoCURA(username, password);

        //Click on Menu Bar and Click on Logout
        MenuBarPage menuBarPage = new MenuBarPage(driver);
        menuBarPage.clickOnMenuBarToggle();
        menuBarPage.clickOnLogoutButton();
        menuBarPage.verifyHomepage();
    }
}
