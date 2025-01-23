package com.thetestingacademy.ex04_30122024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium21 {
    @Test
    public void testMethod01() throws Exception {

    EdgeOptions edgeOptions = new EdgeOptions();
    edgeOptions.addArguments("--start-maximized");

    WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://www.idrive360.com/enterprise/login");
        Thread.sleep(5000);
        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys("augtest_040823@idrive.com");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("123456");
        driver.findElement(By.id("frm-btn")).click();
        Thread.sleep(15000);
        WebElement e_message = driver.findElement(By.xpath("//h5[@class='id-card-title']"));
        Assert.assertEquals(e_message.getText(),"Your free trial has expired");
    }
}




