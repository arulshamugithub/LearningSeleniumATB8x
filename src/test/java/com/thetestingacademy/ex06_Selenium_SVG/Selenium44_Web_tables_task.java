package com.thetestingacademy.ex06_Selenium_SVG;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium44_Web_tables_task {
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
        String URL = "https://awesomeqa.com/hr/web/index.php/auth/login";
        driver.get(URL);
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Hacker@4321");
        driver.findElement(By.xpath("//button[contains(@class,'oxd-button')]")).click();

        // Row  - //table[@id="customers"]/tbody/tr
        // Col - //table[@id="customers"]/tbody/tr[1]/td

        int row = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr")).size();
        int col = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr[2]/td")).size();


        System.out.println(row);
        System.out.println(col);

        String first_part = "//table[@id=\"customers\"]/tbody/tr[";
        String second_part = "]/td[";
        String third_part = "]";

        for (int i = 2; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                String Dynamic_xpath = first_part + i + second_part + j + third_part;
                String data = driver.findElement(By.xpath(Dynamic_xpath)).getText();
                System.out.println(data);
                if(data.contains("Helen Bennett")){
                    String Country_path = Dynamic_xpath+"/following-sibling::td";
                    String Country_company = Dynamic_xpath+"/preceding-sibling::td";
                    String country_text = driver.findElement(By.xpath(Country_path)).getText();
                    String company_text = driver.findElement(By.xpath(Country_company)).getText();
                    System.out.println("----------------");
                    System.out.println("Helen Bennett is In - " + country_text);
                    System.out.println("Helen Bennett is Company - "  + company_text);
                }
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

