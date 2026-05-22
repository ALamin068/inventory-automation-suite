package tests;

import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest {

    @Test
    public void verifyHomePage() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
options.setBinary("/usr/bin/google-chrome");

options.addArguments("--headless=new");

options.addArguments("--no-sandbox");

options.addArguments("--disable-dev-shm-usage");

WebDriver driver = new ChromeDriver(options);

        driver.get("http://localhost");

        String bodyText =
                driver.findElement(By.tagName("body")).getText();

        Assert.assertTrue(
                bodyText.contains("Inventory Application Running!")
        );

        System.out.println("TEST PASSED");

        driver.quit();
    }
}
