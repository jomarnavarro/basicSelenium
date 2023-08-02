package com.herokuapp.theinternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(css = "#flash")
    WebElement msgLbl;

    @FindBy(css = "#username")
    WebElement userTxt;

    @FindBy(css = "#password")
    WebElement passTxt;

    @FindBy(css = "button[type='submit']")
    WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void inputCredentials(String username, String password) {
        wait.until(ExpectedConditions.visibilityOf(this.userTxt));
        this.userTxt.clear();
        this.userTxt.sendKeys(username);
        this.passTxt.clear();
        this.passTxt.sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(this.loginBtn)).click();
    }

    public boolean loginButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(this.loginBtn)).isDisplayed();
    }

}
