package com.thetestingacademy.ex03_23122024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Selenium16 {
    @Test
    public void testMethod01() throws Exception {

    EdgeOptions edgeOptions = new EdgeOptions();
    edgeOptions.addArguments("--start-maximized");

    WebDriver driver = new EdgeDriver(edgeOptions);
    driver.get("https://app.vwo.com");

    Assert.assertEquals(driver.getTitle(),"Login - VWO");
    Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");
        Thread.sleep(5000);
        WebElement username_txt = driver.findElement(By.id("login-username"));
        username_txt.sendKeys("admin@admin.com");

        WebElement pwd_txt = driver.findElement(By.id("login-password"));
        pwd_txt.sendKeys("password123");

        WebElement submit_btn = driver.findElement(By.id("js-login-btn"));
        submit_btn.click();
        Thread.sleep(5000);
        WebElement error_message = driver.findElement(By.className("notification-box-description"));
        Assert.assertEquals(error_message.getText(),"Your email, password, IP address or location did not match");
        //AssertJ
        assertThat(error_message.getText()).isNotEmpty().isNotBlank().isEqualTo("Your email, password, IP address or location did not match");
    }
}




