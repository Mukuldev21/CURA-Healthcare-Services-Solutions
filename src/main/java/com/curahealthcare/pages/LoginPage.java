package com.curahealthcare.pages;

import com.curahealthcare.utils.ExtentReportManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage {

    //locators

    @FindBy(id="btn-make-appointment")
    private WebElement appointmentButton;

    @FindBy(css="input[id='txt-username']")
    private WebElement userNameField;

    @FindBy(css="input[id='txt-password']")
    private WebElement passwordField;

    @FindBy(id="btn-login")
    private WebElement loginButton;

    @FindBy(xpath="//p[contains(text(), 'Login failed!')]")
    private WebElement errorMessage;

    @FindBy(xpath="//h2[text()='Make Appointment']")
    private WebElement makeAppointmentHeader;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void verifyHomepage(){
        Assert.assertTrue(appointmentButton.isDisplayed(),"Appointment button is not displayed");
        ExtentReportManager.getTest().info("Verified homepage is displayed");
        ExtentReportManager.getTest().pass("Homepage displayed successfully");;
    }

    public void loginIntoCURA(String username, String password){

        ExtentReportManager.getTest().info("Attempting to login with valid credentials");
        appointmentButton.click();

        ExtentReportManager.getTest().info("Entering valid username: ");
        userNameField.sendKeys(username);

        ExtentReportManager.getTest().info("Entering valid password: ");
        passwordField.sendKeys(password);

        ExtentReportManager.getTest().info("Clicking login button");
        loginButton.click();

        ExtentReportManager.getTest().info("Verify Make Appointment Header is visible ");
        Assert.assertTrue(makeAppointmentHeader.isDisplayed(), "Header is not displayed !");
        ExtentReportManager.getTest().pass("Successfully logged in");

    }

    public void loginIntoCURAWithInvalidCredentials(String invalidUsername, String invalidPassword) {

        ExtentReportManager.getTest().info("Attempting to login with invalid credentials");
        appointmentButton.click();

        ExtentReportManager.getTest().info("Entering invalid username: " + invalidUsername);
        userNameField.sendKeys(invalidUsername);

        ExtentReportManager.getTest().info("Entering invalid password: " + invalidPassword);
        passwordField.sendKeys(invalidPassword);

        ExtentReportManager.getTest().info("Clicking login button");
        loginButton.click();
        Assert.assertTrue(errorMessage.isDisplayed(),"Error message is not displayed");
        ExtentReportManager.getTest().pass("Login failed as expected with error message displayed");

    }

}
