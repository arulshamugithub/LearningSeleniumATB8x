package com.thetestingacademy.ex06_Selenium_SVG;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;

public class Selenium_SVG_P1 {
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }

    @Description("Test the flipkart search icon")
    @Test
    public void test_flipkart_search(){
        String URL = "https://www.flipkart.com/";
        driver.get(URL);
        driver.manage().window().maximize();

        //Step 1 - enter the 'macmini' in input box
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("macmini");

        //step2 - click on SVG image
        List<WebElement> svg_image = driver.findElements(By.xpath("//*[name()='svg']"));
        svg_image.get(0).click();
        List<WebElement> title_results = driver.findElements(By.xpath("//div[contains(@data-id,'CPU')]/div/a[2]"));
        for(WebElement title:title_results){
            System.out.println(title.getText());
        }
    }

    @AfterTest
    public void closeBrowser(){
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            {
                throw new RuntimeException(e);
            }
        }
    }
}
