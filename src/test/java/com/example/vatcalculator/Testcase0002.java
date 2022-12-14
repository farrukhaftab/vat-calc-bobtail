package com.example.vatcalculator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Testcase0002 {
    // This testcase will calculate VAT Rate
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.calculator.net/vat-calculator.html");
        WebElement beforeVAT = driver.findElement(By.cssSelector("input[name=beforetax]"));
        beforeVAT.sendKeys("25");
        WebElement finalPrice = driver.findElement(By.cssSelector("input[name=finalprice]"));
        finalPrice.clear();
        finalPrice.sendKeys("30");
        WebElement calcButton = driver.findElement(By.cssSelector("input[type=image]"));
        calcButton.click();
        String msg = driver.findElement(By.cssSelector("#content > div:nth-child(5)")).getText();
        Assert.assertEquals(msg,"VAT: 20.00% or 5.00");
        driver.quit();

    }
}
