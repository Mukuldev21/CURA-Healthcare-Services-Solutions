package com.curahealthcare.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Properties;

public class DriverManager {

    protected static WebDriver driver;


    private DriverManager() {
    }

    public static WebDriver initializeDriver(Properties config) {
        String browserName = config.getProperty("browser").toLowerCase();
        int implicitWait = Integer.parseInt(config.getProperty("wait.implicit"));
        driver = switch (browserName) {
            case "chrome" -> createChromeDriver();
            case "firefox" -> createFirefoxDriver();
            case "edge" -> createEdgeDriver();
            case "headless" -> createHeadlessDriver();
            default -> throw new IllegalArgumentException("Unsupported browser: " + browserName);
        };

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        driver.manage().window().maximize();

        return driver;
    }

    private static WebDriver createChromeDriver() {
        System.setProperty("wdm.silent", "true");
        // Add this line to completely disable WebDriverManager logging
        java.util.logging.Logger.getLogger("io.github.bonigarcia").setLevel(java.util.logging.Level.OFF);
        WebDriverManager.chromedriver().setup();
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--start-maximized", "--remote-allow-origins=*");
        return new ChromeDriver();
    }

    private static WebDriver createFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private static WebDriver createEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }

    private static WebDriver createHeadlessDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "--remote-allow-origins=*","--headless");
        return new ChromeDriver();
    }
    public static WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("Driver not initialized. Call initializeDriver first.");
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
