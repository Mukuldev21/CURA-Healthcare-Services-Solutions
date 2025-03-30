package com.curahealthcare.tests;

import com.curahealthcare.utils.ConfigReader;
import com.curahealthcare.utils.DriverManager;
import com.curahealthcare.utils.ExtentReportManager;
import com.google.gson.JsonObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;
    protected Properties config;
    protected JsonObject validLoginData;
    protected JsonObject invalidLoginData;
    protected JsonObject appointmentDetailsData;

    @BeforeSuite
    public void beforeSuite() {
        // Initialize the ExtentReports
        ExtentReportManager.getInstance();
    }

    @AfterSuite
    public void afterSuite() {
        // Flush the report after all tests are done
        ExtentReportManager.flushReports();
    }

    @BeforeMethod
    public void setUp() {
        // Load configuration properties
        config = ConfigReader.loadProperties("src/test/resources/config/config.properties");
        validLoginData = ConfigReader.loadJsonConfig("src/test/resources/testData/LoginData.json");
        invalidLoginData = ConfigReader.loadJsonConfig("src/test/resources/testData/InvalidLoginData.json");
        appointmentDetailsData = ConfigReader.loadJsonConfig("src/test/resources/testData/AppointmentDetailsData.json");

        // Initialize WebDriver
        driver = DriverManager.initializeDriver(config);

        // Navigate to application URL
        driver.get(config.getProperty("url"));

    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
