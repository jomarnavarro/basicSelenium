package com.practicetestautomation.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ExceptionTests extends BaseTest {

    @Test(priority = 1, groups = {"smokeTests"})
    public void elementNotInteractableExceptionTest() throws InterruptedException {
        driver.findElement(By.cssSelector("#add_btn")).click();
        WebElement taskInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='row2']/input")));
        taskInput.sendKeys("Sushi");
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(
                        By.xpath("//div[@id='row2']/button[@name='Save']")
                )
        ).click();
    }
}
