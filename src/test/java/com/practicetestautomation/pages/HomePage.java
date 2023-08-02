package com.practicetestautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    @FindBy(css = ".button.secondary.radius")
    WebElement logOutBtn;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean logOutButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(this.logOutBtn)).isDisplayed();
    }
}
