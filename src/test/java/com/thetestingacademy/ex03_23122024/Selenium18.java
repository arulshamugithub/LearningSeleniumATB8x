package com.thetestingacademy.ex03_23122024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium18 {
    @Test
    public void testMethod01() throws Exception {

    EdgeOptions edgeOptions = new EdgeOptions();
    edgeOptions.addArguments("--start-maximized");

    WebDriver driver = new EdgeDriver(edgeOptions);
    driver.get("https://vwo.com/free-trial/");

    WebElement email = driver.findElement(By.id("page-v1-step1-email"));
    email.sendKeys("xcbxnmcnxmnm");

    WebElement check_box  = driver.findElement(By.name("gdpr_consent_checkbox"));
    check_box.click();

    List<WebElement> button_list = driver.findElements(By.tagName("button"));
    button_list.get(0).click();

    WebElement error_message = driver.findElement(By.className("invalid-reason"));
        Assert.assertEquals(error_message.getText(),"The email address you entered is incorrect.");
    }
}




