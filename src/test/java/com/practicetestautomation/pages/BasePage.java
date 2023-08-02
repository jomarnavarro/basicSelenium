package com.practicetestautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    @FindBy(css = "#flash")
    WebElement msgLbl;
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public boolean isAt(String url) {
        return this.driver.getCurrentUrl().equals(url);
    }
    public boolean confirmationMessageDisplays(String expectedMessage) {
        return wait.until(ExpectedConditions.visibilityOf(this.msgLbl)).isDisplayed() &&
                this.msgLbl.getText().contains(expectedMessage);
    }
}
