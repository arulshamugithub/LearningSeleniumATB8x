package com.thetestingacademy.ex05_Selenium_Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium23 {
    @Test
    public void testMethod01() throws Exception {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);

        driver.get("https://cdpn.io/AbdullahSajjad/fullpage/LYGVRgK?anon=true&view=fullpage");
        Thread.sleep(5000);
        driver.switchTo().frame("result");

        WebElement button = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
        button.click();
        String inputbox_path = "//input[@id='username']";
        String small_path = inputbox_path+"/following-sibling::small";
        String label_path = inputbox_path+"/preceding-sibling::label";

        WebElement error_msg = driver.findElement(By.xpath(small_path));
        WebElement label_tag = driver.findElement(By.xpath(label_path));
        System.out.println(label_tag.getText());

        Assert.assertEquals(error_msg.getText(),"Username must be at least 3 characters");
        Thread.sleep(3000);
        driver.quit();


    }

}





