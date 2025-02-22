package com.thetestingacademy.ex10_Selenium_Relative_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Selenium25 {

    @Test
    public void testMethod01() throws Exception {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        String URL = "https://awesomeqa.com/practice.html";
        EdgeDriver driver = new EdgeDriver(edgeOptions);
        driver.get(URL);
        driver.manage().window().maximize();

        WebElement span_element = driver.findElement(By.xpath("//span[normalize-space()='Years of Experience']"));
        driver.findElement(with(By.id("exp-2")).toRightOf(span_element)).click();


    }
}
