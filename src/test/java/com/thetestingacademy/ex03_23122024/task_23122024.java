package com.thetestingacademy.ex03_23122024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class task_23122024 {
    @Test
    public void testMethod01() throws Exception {

    EdgeOptions edgeOptions = new EdgeOptions();
    edgeOptions.addArguments("--start-maximized");

    WebDriver driver = new EdgeDriver(edgeOptions);
    driver.get("https://katalon-demo-cura.herokuapp.com/");

    WebElement make_app = driver.findElement(By.id("btn-make-appointment"));
    make_app.click();

    WebElement usr_name = driver.findElement(By.id("txt-username"));
    usr_name.sendKeys("John Doe");

    WebElement pasword = driver.findElement(By.id("txt-password"));
    pasword.sendKeys("ThisIsNotAPassword");

    WebElement s_button = driver.findElement(By.id("btn-login"));
    s_button.click();
Thread.sleep(5000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");


    }
}




