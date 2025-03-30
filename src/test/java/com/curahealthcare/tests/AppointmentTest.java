package com.curahealthcare.tests;

import com.curahealthcare.pages.AppointmentPage;
import com.curahealthcare.pages.ConfirmationPage;
import com.curahealthcare.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AppointmentTest extends BaseTest{

    private String facility;
    private String applyReadmission;
    private String healthcareProgramOption;
    private String visitDate;
    private String comment;
    private String username;
    private String password;

    @BeforeMethod(dependsOnMethods = "setUp")
    public void initAppointmentDetails(){
        //Load Appointment Details from JSON file
        facility = appointmentDetailsData.get("facility").getAsString();
        applyReadmission = appointmentDetailsData.get("applyReadmission").getAsString();
        healthcareProgramOption = appointmentDetailsData.get("healthcareProgramOption").getAsString();
        visitDate = appointmentDetailsData.get("visitDate").getAsString();
        comment = appointmentDetailsData.get("comment").getAsString();

        // Initialize login credentials from the validLoginData JsonObject in BaseTest
        username = validLoginData.get("username").getAsString();
        password = validLoginData.get("password").getAsString();
    }

    @Test(priority = 1, description = "Verify Appointment Booking")
    public void testAppointmentBookingDetails(){

        //Create a test instance with the ExtentReportManager
        //ExtentReportManager.createTest("Appointment Booking Test", "Verify that users can book appointments successfully");

        // First login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginIntoCURA(username, password);

        //Then Book appointment
        AppointmentPage appointmentPage = new AppointmentPage(driver);
        appointmentPage.selectFacility(facility);
        appointmentPage.selectReadmissionCheckbox(applyReadmission);
        appointmentPage.selectHealthcareProgram(healthcareProgramOption);
        appointmentPage.setVisitDate(visitDate);
        appointmentPage.addComment(comment);
        appointmentPage.clickOnBookAppointmentButton();

        //Validation of details in Confirmation Page
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        confirmationPage.verifyAppointHeader();
        confirmationPage.verifyFacility(facility);
        confirmationPage.verifyReadmission(applyReadmission);
        confirmationPage.verifyHealthcareProgram(healthcareProgramOption);
        confirmationPage.verifyVisitDate(visitDate);
        confirmationPage.verifyCommentBox(comment);
        confirmationPage.clickOnGoToHomepageButton();
        confirmationPage.verifyHomepage();
    }

    @Test(priority = 2, description = "Verify Appointment Booking Without Required Fields")
    public void testAppointmentBookingDetailsWithoutRequiredFields(){

        // First login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginIntoCURA(username, password);

        //Then Book appointment
        AppointmentPage appointmentPage = new AppointmentPage(driver);
        appointmentPage.selectFacility(facility);
        appointmentPage.selectReadmissionCheckbox(applyReadmission);
        appointmentPage.selectHealthcareProgram(healthcareProgramOption);
        appointmentPage.addComment(comment);
        appointmentPage.clickOnBookAppointmentButton();
        appointmentPage.verifyErrorMessage();
    }
}
