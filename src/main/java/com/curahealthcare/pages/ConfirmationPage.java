package com.curahealthcare.pages;

import com.curahealthcare.utils.ExtentReportManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ConfirmationPage extends LoginPage {

    //locators

    @FindBy(xpath = "//h2[text()='Appointment Confirmation']")
    private WebElement appointmentHeader;

    @FindBy(css = "p#facility")
    private WebElement facilityInfo;

    @FindBy(css = "p#hospital_readmission")
    private WebElement hospitalReadmission;

    @FindBy(css = "p#program")
    private WebElement healthcareProgram;

    @FindBy(css = "p#visit_date")
    private WebElement visitDateField;

    @FindBy(css = "p#comment")
    private WebElement commentBox;

    @FindBy(xpath = "//a[contains(text(), 'Go to Homepage')]")
    private WebElement gotoHomepageButton;

    public ConfirmationPage(WebDriver driver) {

        super(driver);
    }

    public void verifyAppointHeader(){

        ExtentReportManager.getTest().info("Verify the Appointment Confirmation Header");
        Assert.assertTrue(appointmentHeader.isDisplayed());
    }

    public void verifyFacility(String facility){
        ExtentReportManager.getTest().info("Verify the facility drop-down");
        Assert.assertEquals(facility,facilityInfo.getText(), "Not matching");
    }

    public void verifyReadmission(String applyReadmission){
        ExtentReportManager.getTest().info("Verify Apply for hospital readmission checkbox");
        Assert.assertEquals(applyReadmission,hospitalReadmission.getText(), "Not matching");
    }

    public void verifyHealthcareProgram(String healthcareProgramOption){
        ExtentReportManager.getTest().info("Verify Healthcare Program radio button");
        Assert.assertEquals(healthcareProgramOption, healthcareProgram.getText(), "Not matching");
    }

    public void verifyVisitDate(String visitDate){
        ExtentReportManager.getTest().info("Verify Visit Date selector");
        Assert.assertEquals(visitDate, visitDateField.getText(), "Not matching" );
    }

    public void verifyCommentBox(String comment){
        ExtentReportManager.getTest().info("Verify Comment field");
        Assert.assertEquals(comment, commentBox.getText(), "Not matching");
    }

    public void clickOnGoToHomepageButton(){

        ExtentReportManager.getTest().info("Click on Homepage button");
        gotoHomepageButton.click();
    }

}
