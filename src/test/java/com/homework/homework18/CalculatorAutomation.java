package com.homework.homework18;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class CalculatorAutomation {

    private WebDriver driver;

    private ChromeOptions options;

    private Wait wait;

    @BeforeClass //rulat inaintea tuturor metodelor de tests (cu  @Test)
    // si inaintea celei cu @BeforeMethod
    public void setup1() {
        System.out.println("BeforeClass");
    }

    @BeforeMethod //rulat inaintea fiecarei metode de test
    public void setup() {
        System.out.println("BeforeMethod");
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver_win32/chromedriver.exe");
        options = new ChromeOptions();
//        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
    }

    @AfterMethod
    public void closeEverything() {
        driver.close();
    }

    @Test
    public void calculatePercentOfNumber() {
        navigate("https://www.calculator.net/percent-calculator.html");

        WebElement input1 = new WebDriverWait(driver, 3)
                .until(d -> find(By.id("cpar1")));
        input1.sendKeys("19");

        sleep(1000);
        find(By.id("cpar2")).sendKeys("35000");
        sleep(1000);

        find(By.xpath("//*[@id=\"content\"]/table[1]/tbody/tr[2]/td/input[2]")).click();
        String actualValue1 = find(By.xpath("//*[@id=\"content\"]/h2[1]")).getText();
        String actualValue2 = find(By.xpath("//*[@id=\"content\"]/p[2]/font/b")).getText();
        String actualValue3 = find(By.xpath("//*[@id=\"content\"]/p[3]/*")).getText();

        assertEquals(actualValue1.substring(actualValue1.length() - 4), "6650");
        assertEquals(actualValue2, "6650");
        //primesc eroare : The result of the xpath expression "//*[@id="content"]/p[3]/text()" is: [object Text]. It should be an element.
        //assertEquals(actualValue3.substring(actualValue1.length()-4), "6650");

    }


    @Test
    public void calculatePercentDifference() {
        navigate("https://www.calculator.net/percent-calculator.html");

        WebElement input1 = new WebDriverWait(driver, 3)
                .until(d -> find(By.name("c3par1")));
        input1.sendKeys("4500");

        sleep(1000);
        find(By.name("c3par2")).sendKeys("3825");
        sleep(1000);

        find(By.xpath("//tbody/tr[3]/td[1]/input[2]")).click();

        String actualValue1 = find(By.xpath("//*[@id=\"content\"]/p[2]/font/b")).getText();
        String actualValue2 = find(By.xpath("//*[@id=\"content\"]/p[4]/font/b")).getText();

        assertEquals(actualValue1, "16.216216216216%");
        assertEquals(actualValue2, "15%");
    }

    @Test
    public void calculatePercentChangeIncrease() {
        navigate("https://www.calculator.net/percent-calculator.html");

        WebElement input1 = new WebDriverWait(driver, 3)
                .until(d -> find(By.name("c2par1")));
        input1.sendKeys("9000");
        sleep(1000);
        Select increase = new Select(find(By.name("c2type")));
        increase.selectByVisibleText("Increase");
        find(By.name("c2par2")).sendKeys("35");
        sleep(1000);

        find(By.xpath("//*[@id=\"content\"]/table[6]/tbody/tr[2]/td/input[2]")).click();

        String actualValue0 = find(By.xpath("//*[@id=\"content\"]/h2[4]")).getText();
        String actualValue1 = find(By.xpath("//*[@id=\"content\"]/h2[4]")).getText();
        String actualValue2 = find(By.xpath("//*[@id=\"content\"]/p[3]/font/b")).getText();


        assertEquals(actualValue1.substring(actualValue1.length() - 5), "12150");
        assertEquals(actualValue2, "12150");
    }

    @Test
    public void calculatePercentChangeDecrease() {
        navigate("https://www.calculator.net/percent-calculator.html");

        WebElement input1 = new WebDriverWait(driver, 3)
                .until(d -> find(By.name("c2par1")));
        input1.sendKeys("9000");
        sleep(1000);
        Select increase = new Select(find(By.name("c2type")));
        increase.selectByVisibleText("Decrease");
        find(By.name("c2par2")).sendKeys("35");
        sleep(1000);

        find(By.xpath("//*[@id=\"content\"]/table[6]/tbody/tr[2]/td/input[2]")).click();

        String actualValue1 = find(By.xpath("//*[@id=\"content\"]/h2[4]")).getText();
        String actualValue2 = find(By.xpath("//*[@id=\"content\"]/p[3]/font/b")).getText();

        assertEquals(actualValue1.substring(actualValue1.length() - 4), "5850");
        assertEquals(actualValue2, "5850");
    }


    private WebElement find(By by) {
        return driver.findElement(by);
    }

    private void navigate(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }


    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
