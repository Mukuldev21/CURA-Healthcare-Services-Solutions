package com.curahealthcare.utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Suite started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Suite finished: " + context.getName());
        ExtentReportManager.flushReports();
    }

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        String description = result.getMethod().getDescription();
        if (description == null || description.isEmpty()) {
            description = testName;
        }

        // Create test with description
        ExtentTest test = ExtentReportManager.createTest(testName, description);

        // Highlight the description to make it more prominent
        test.info(MarkupHelper.createLabel("TEST DESCRIPTION: " + description, ExtentColor.BLUE));
        test.info("Test started: " + testName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTest test = ExtentReportManager.getTest();
        test.log(Status.PASS, "Test passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = ExtentReportManager.getTest();
        test.log(Status.FAIL, "Test failed: " + result.getMethod().getMethodName());

        // Re-display the description on failure for context
        String description = result.getMethod().getDescription();
        if (description != null && !description.isEmpty()) {
            test.fail(MarkupHelper.createLabel("FAILED TEST PURPOSE: " + description, ExtentColor.RED));
        }

        test.log(Status.FAIL, "Error: " + result.getThrowable().getMessage());

        // Capture screenshot on failure
        try {
            WebDriver driver = DriverManager.getDriver();
            if (driver != null) {
                String base64Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
                test.fail("Screenshot of failure",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
            }
        } catch (Exception e) {
            test.log(Status.WARNING, "Failed to capture screenshot: " + e.getMessage());
        }

        // Log stack trace
        test.log(Status.FAIL, Arrays.toString(result.getThrowable().getStackTrace()));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTest test = ExtentReportManager.getTest();
        test.log(Status.SKIP, "Test skipped: " + result.getMethod().getMethodName());

        // Re-display the description on skipped for context
        String description = result.getMethod().getDescription();
        if (description != null && !description.isEmpty()) {
            test.skip(MarkupHelper.createLabel("SKIPPED TEST PURPOSE: " + description, ExtentColor.YELLOW));
        }

        if (result.getThrowable() != null) {
            test.log(Status.SKIP, "Reason: " + result.getThrowable().getMessage());
        }
    }
}