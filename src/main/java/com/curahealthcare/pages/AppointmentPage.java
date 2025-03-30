package com.curahealthcare.pages;

import com.curahealthcare.utils.ExtentReportManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AppointmentPage extends BasePage {

    //Locators

    @FindBy(xpath="//select[@name='facility']")
    private WebElement facilityDropdown;

    @FindBy(xpath="//input[@name='hospital_readmission']")
    private WebElement readmissionCheckbox;

    @FindBy(id="radio_program_medicare")
    private WebElement medicareButton;

    @FindBy(id="radio_program_medicaid")
    private WebElement medicaidButton;

    @FindBy(id="radio_program_none")
    private WebElement noneRadioButton;

    @FindBy(xpath="//input[@id='txt_visit_date']")
    private WebElement calenderField;

    @FindBy(xpath="//textarea[@id='txt_comment']")
    private WebElement commentBox;

    @FindBy(id="btn-book-appointment")
    private WebElement bookAppointmentButton;

    public AppointmentPage(WebDriver driver) {
        super(driver);
    }


    //To select from Facility Dropdown
    public void selectFacility(String facility) {

        ExtentReportManager.getTest().info("Select from Facility Drop-down ");
        Select select = new Select(facilityDropdown);
        select.selectByValue(facility);
    }

    //Click on Readmission Checkbox
    public void selectReadmissionCheckbox(String applyReadmission) {
        if(applyReadmission.equalsIgnoreCase("yes")){
            readmissionCheckbox.click();
            ExtentReportManager.getTest().info("Click on Readmission Checkbox");
        }
        else {
            System.out.println("User not opted for Readmission");
        }

    }

    //Click on Healthcare Program
    public void selectHealthcareProgram(String healthcareProgramOption){

        if(healthcareProgramOption.equalsIgnoreCase("Medicare")){
            medicareButton.click();
            ExtentReportManager.getTest().info("Click on Healthcare Program");
        }
        else if(healthcareProgramOption.equalsIgnoreCase("Medicaid")){
            medicaidButton.click();
            ExtentReportManager.getTest().info("Click on Healthcare Program");
        }
        else{
            noneRadioButton.click();
            ExtentReportManager.getTest().info("Click on none");
        }
    }

    //Set visit date
    public void setVisitDate(String visitDate) {

        ExtentReportManager.getTest().info("Set visit date");
        calenderField.sendKeys(visitDate);
    }

    //add comments
    public void addComment(String comment){

        ExtentReportManager.getTest().info("Add Comments");
        commentBox.sendKeys(comment);
    }

    //click on Book appointment button
    public void clickOnBookAppointmentButton() {

        ExtentReportManager.getTest().info("Click on Book appointment button");
        bookAppointmentButton.click();
    }

    //Verify the error message
    public void verifyErrorMessage(){
        ExtentReportManager.getTest().info("Verify the error message");
        String errorMessage = calenderField.getAttribute("validationMessage");
        System.out.println("Captured Error Message: " + errorMessage);
    }
}
