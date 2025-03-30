package com.curahealthcare.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class ExtentReportManager {

    private static ExtentReports extent;
    private static final Map<Long, ExtentTest> testMap = new HashMap<>();
    private static final String REPORT_DIR = "test-output/reports/";

    private ExtentReportManager() {
        // Private constructor to prevent instantiation
    }

    public static synchronized ExtentReports getInstance() {
        if (extent == null) {
            createReportDir();
            extent = createInstance();
        }
        return extent;
    }

    private static void createReportDir() {
        File directory = new File(REPORT_DIR);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    private static ExtentReports createInstance() {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        String reportPath = REPORT_DIR + "CuraHealthcare_TestReport_" + timestamp + ".html";

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
        sparkReporter.config().setDocumentTitle("CURA-Healthcare Test Results");
        sparkReporter.config().setReportName("Automation Test Report");
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setEncoding("utf-8");
        sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

        // Add custom CSS to make descriptions more prominent
        sparkReporter.config().setCss(
                ".test-content .description { " +
                        "font-size: 26px; " +            // Larger font size
                        "font-weight: 500; " +           // Semi-bold text
                        "padding: 12px 15px; " +         // Add some padding
                        "background-color: #f8f9fa; " +  // Light background
                        "border-left: 4px solid #7066e0; " + // Left border accent
                        "border-radius: 4px; " +         // Rounded corners
                        "margin-bottom: 15px; " +        // Bottom margin
                        "line-height: 1.5; " +           // Better line spacing
                        "}"
        );

        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("Operating System", System.getProperty("os.name"));
        extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
        extentReports.setSystemInfo("Browser", System.getProperty("browser", "chrome"));
        extentReports.setSystemInfo("Environment", System.getProperty("env", "QA"));
        extentReports.setSystemInfo("Tester Name", System.getProperty("Tester name", "Mukul"));

        return extentReports;
    }

    /*public static synchronized ExtentTest createTest(String testName, String description) {
        ExtentTest test = getInstance().createTest(testName, description);
        testMap.put(Thread.currentThread().getId(), test);
        return test;
    }*/
    public static ExtentTest createTest(String testName, String description) {
        ExtentTest test = extent.createTest(testName);
        testMap.put((long) Thread.currentThread().getId(), test);
        return test;
    }

    public static synchronized ExtentTest getTest() {
        return testMap.get(Thread.currentThread().getId());
    }

    public static synchronized void flushReports() {
        if (extent != null) {
            extent.flush();
        }
    }
}