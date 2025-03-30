package com.curahealthcare.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuBarPage extends LoginPage {

    //locators
    @FindBy(id = "menu-toggle")
    private WebElement sideMenuBar;

    public MenuBarPage(WebDriver driver) {
        super(driver);
    }

    //@FindBy(id="hist0ry")

}
