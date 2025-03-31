package com.curahealthcare.pages;

import com.curahealthcare.utils.ExtentReportManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MenuBarPage extends LoginPage {

    //locators
    @FindBy(id = "menu-toggle")
    private WebElement sideMenuBar;

    @FindBy(css=".php#history")
    private WebElement historyButton;

    @FindBy(css="p#facility")
    private WebElement facilityInHistoryPage;

    @FindBy(css="p#hospital_readmission")
    private WebElement readmissionInHistoryPage;

    @FindBy(css="p#program")
    private WebElement healthcareInHistoryPage;

    @FindBy(css="p#comment")
    private WebElement commentInHistoryPage;

    @FindBy(xpath = "//div[@class=' col-sm-offset-2 col-sm-8'][last()]/div/div[1]")
    private WebElement visitDateInHistoryPage;

    @FindBy(css = "a.btn.btn-default")
    private WebElement clickOnBackToHomeButtonInHistoryPage;

    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement logoutButton;

    //Constructor
    public MenuBarPage(WebDriver driver)
    {
        super(driver);
    }

    public void clickOnMenuBarToggle(){
        ExtentReportManager.getTest().info("Click on Side Menu Bar Toggle");
        sideMenuBar.click();
    }

    public void verifyFacilityInHistoryPage(String facility){
        ExtentReportManager.getTest().info("Verify Facility");
        Assert.assertEquals(facility,facilityInHistoryPage.getText(),"Not matching");
    }

    public void verifyReadmissionInHistoryPage(String applyReadmission){
        ExtentReportManager.getTest().info("Verify Apply for hospital readmission");
        Assert.assertEquals(applyReadmission,readmissionInHistoryPage.getText(), "Not matching");
    }

    public void verifyHealthcareInHistoryPage(String healthcareProgramOption){
        ExtentReportManager.getTest().info("Verify Healthcare Program");
        Assert.assertEquals(healthcareProgramOption, healthcareInHistoryPage.getText(), "Not matching");
    }

    public void verifyVisitDateInHistoryPage(String visitDate){
        ExtentReportManager.getTest().info("Verify Visit Date");
        Assert.assertEquals(visitDate, visitDateInHistoryPage.getText(), "Not matching" );
    }

    public void verifyCommentBoxInHistoryPage(String comment){
        ExtentReportManager.getTest().info("Verify Comment");
        Assert.assertEquals(comment, commentInHistoryPage.getText(), "Not matching");
    }

    public void clickOnBackToHomeButton(){
        ExtentReportManager.getTest().info("Click on Back to HomePage Button");
        clickOnBackToHomeButtonInHistoryPage.click();
    }

    public void clickOnLogoutButton(){
        ExtentReportManager.getTest().info("Click on Logout Button");
        logoutButton.click();
    }

}
