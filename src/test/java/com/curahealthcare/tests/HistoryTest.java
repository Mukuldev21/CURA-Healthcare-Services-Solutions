package com.curahealthcare.tests;

import com.curahealthcare.pages.AppointmentPage;
import com.curahealthcare.pages.LoginPage;
import com.curahealthcare.pages.MenuBarPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HistoryTest extends BaseTest {

    private String facility;
    private String applyReadmission;
    private String healthcareProgramOption;
    private String visitDate;
    private String comment;
    private String username;
    private String password;

    @BeforeMethod(dependsOnMethods = "setUp")
    public void initHistoryPageDetails(){
        //Load Appointment Details from JSON file
        facility = appointmentDetailsData.get("facility").getAsString();
        applyReadmission = appointmentDetailsData.get("applyReadmission").getAsString();
        healthcareProgramOption = appointmentDetailsData.get("healthcareProgramOption").getAsString();
        visitDate = appointmentDetailsData.get("visitDate").getAsString();
        comment = appointmentDetailsData.get("comment").getAsString();

        // Initialize login credentials from the validLoginData JsonObject in HistoryTest
        username = validLoginData.get("username").getAsString();
        password = validLoginData.get("password").getAsString();
    }

    @Test(priority = 1, description = "Verify Appointment Booking Details in History Page")
    public void verifyHistoryPage(){

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

        //Verify in History Page
        MenuBarPage menuBarPage = new MenuBarPage(driver);
        menuBarPage.clickOnMenuBarToggle();
        menuBarPage.verifyFacilityInHistoryPage(facility);
        menuBarPage.verifyReadmissionInHistoryPage(applyReadmission);
        menuBarPage.verifyHealthcareInHistoryPage(healthcareProgramOption);
        menuBarPage.verifyCommentBoxInHistoryPage(comment);

        //Click on Back to HomePage
        menuBarPage.clickOnBackToHomeButton();
    }

}
