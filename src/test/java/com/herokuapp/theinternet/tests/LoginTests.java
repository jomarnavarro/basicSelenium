package com.herokuapp.theinternet.tests;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {


    @Parameters({"username", "password", "expectedMessage", "expectedUrl"})
    @Test(priority = 1, groups = {"positiveTests", "smokeTests"})
    public void positiveLoginTest(String username,
                          String password,
                          String expectedMessage,
                          String expectedUrl) throws InterruptedException {
        login.inputCredentials(username, password);
        Assert.assertTrue(home.confirmationMessageDisplays(expectedMessage));
        Assert.assertTrue(home.logOutButtonDisplayed());
        Assert.assertTrue(home.isAt(expectedUrl));
    }

    @Parameters({"username", "password", "expectedMessage", "expectedUrl"})
    @Test(priority = 1, groups = { "negativeTests", "smokeTests"})
    public void negativeLoginTest(String username,
                               String password,
                               String expectedMessage,
                               String expectedUrl) throws InterruptedException {
        login.inputCredentials(username, password);

        Assert.assertTrue(login.confirmationMessageDisplays(expectedMessage));
        Assert.assertTrue(login.loginButtonDisplayed());
        Assert.assertTrue(login.isAt(expectedUrl));
    }
}
