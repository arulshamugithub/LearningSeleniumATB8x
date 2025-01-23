package com.thetestingacademy.ex03_23122024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Selenium17 {
    @Test
    public void testMethod01() throws Exception {

    EdgeOptions edgeOptions = new EdgeOptions();
    edgeOptions.addArguments("--start-maximized");

    WebDriver driver = new EdgeDriver(edgeOptions);
    driver.get("https://app.vwo.com");

    //WebElement free_trial = driver.findElement(By.linkText("Start a free trial"));
        WebElement free_trial = driver.findElement(By.partialLinkText("Start a free trial"));

    free_trial.click();
    }
}




