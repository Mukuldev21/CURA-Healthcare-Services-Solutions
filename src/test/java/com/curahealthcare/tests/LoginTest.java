package com.curahealthcare.tests;

import com.curahealthcare.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    private String username;
    private String password;
    private String invalidUsername;
    private String invalidPassword;

    @BeforeMethod(dependsOnMethods = "setUp")
    public void initCredentials() {
        // Load valid credentials from JSON file
        username = validLoginData.get("username").getAsString();
        password = validLoginData.get("password").getAsString();

        // Load invalid credentials from a different JSON file
        invalidUsername = invalidLoginData.get("invalidUsername").getAsString();
        invalidPassword = invalidLoginData.get("invalidPassword").getAsString();
    }

    @Test(priority = 1, description = "Verify Homepage Accessibility")
    public void testHomepageAccessibility() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyHomepage();
    }


    @Test(priority = 2, description = "Verify Login Functionality")
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyHomepage();
        loginPage.loginIntoCURA(username, password);
    }

    @Test(priority = 3, description = "Verify Login Failure with Invalid Credentials")
    public void testFailedLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyHomepage();
        loginPage.loginIntoCURAWithInvalidCredentials(invalidUsername, invalidPassword);
    }

}
