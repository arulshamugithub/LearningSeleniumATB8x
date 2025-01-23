package com.thetestingacademy.ex07_Selenium_WebTables;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;

public class Selenium45_WebTables_Dynamic {
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }


    @Description("Verify Web Tables_task")
    @Test
    public void test_web_tables_task() throws InterruptedException {

        driver.manage().window().maximize();
        String URL = "https://awesomeqa.com/webtable1.html";
        driver.get(URL);
        driver.manage().window().maximize();
        Thread.sleep(3000);
        WebElement table = driver.findElement(By.xpath("//table[@summary='Sample Table']/tbody"));
        List<WebElement> rows_tables = table.findElements(By.tagName("tr"));
        for(int i=0; i< rows_tables.size();i++){
            List<WebElement> col_tables = rows_tables.get(i).findElements(By.tagName("td"));
            for(WebElement c: col_tables){
                System.out.println(c.getText());
            }
        }


    }
        @AfterTest
        public void closeBrowser () {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //driver.quit();

        }
    }

