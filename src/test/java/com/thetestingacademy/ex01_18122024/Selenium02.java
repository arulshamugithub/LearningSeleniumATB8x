package com.thetestingacademy.ex01_18122024;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Selenium02 {

    @Test
    public void test_Selenium(){
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com");
    }

}
