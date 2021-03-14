package com.homework.instagram;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Random;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.homework.instagram.ExtractUsers.extractUsers;
import static java.lang.Math.random;

public class Instagram {

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
        //options.addArguments("--headless");
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
    public void instagramUnfollow() throws IOException, InterruptedException {
        instagramLogin("", "");
        unfollowUsersThatAreNotFollowingBack();
        //followUsersThatAreFollowingBack();


    }

    public void unfollowUsersThatAreNotFollowingBack() throws IOException, InterruptedException {
        //list of followers
        List<String> followers = new ArrayList<>();
        followers.addAll(extractUsers("src/main/java/com/homework/instagram/followers.txt"));
        //followers.stream().forEach(System.out::println);

        //list of following
        List<String> following = new ArrayList<>();
        following.addAll(extractUsers("src/main/java/com/homework/instagram/following.txt"));
        //following.stream().forEach(System.out::println);

        //list of users that are not followers back
        List<String> differences = new ArrayList<>(following);
        differences.removeAll(followers);
        differences.stream().forEach(System.out::println);
        System.out.println("---sfarsit de lista de sters---");
        System.out.println("-------------------------------");
        System.out.println();


        //unfollow users that are not following
        int numberOfErrors=0;
        int counter=0;
        Random random = new Random();
        for (String user : differences) {
            final long DELAY_TIME_MIN = 2000L;               // Minimal delay time between requests
            final long DELAY_TIME_MAX = 20000L;              // Maximal delay time between requests
            final int LONG_DELAY_FREQ = 12;                  // How often to add additional delay time
            final long LONG_DELAY_ADDED_TIME = 120000L;      // Additional delay time
            System.out.println("Unfollowing user: " + user);
            numberOfErrors+=unfollow(user);
            if (numberOfErrors>3){
                System.out.println("Number of errors > 3");
                return;
            }

            //checkIfUnfollowLimitIsReached
            if(checkIfUnfollowLimitIsReached()){
                System.out.println("***Unfollow limit reached***");
                return ;
            }

            //dynamic wait if unfollow is not working
            navigate("https://www.instagram.com/" + user + "/");
            if (!checkIfUnfollowIsSuccessfull()){
                System.out.println("sleep 5 min");
                sleep(300000);
                unfollow(user);
                navigate("https://www.instagram.com/" + user + "/");
                if (!checkIfUnfollowIsSuccessfull()){
                    System.out.println("sleep 10 min");
                    sleep(600000);
                    unfollow(user);
                }
            }

            //dynamic wait for each user
            long sleepTime = DELAY_TIME_MIN * (1 + random.nextInt((int) (DELAY_TIME_MAX / DELAY_TIME_MIN)));
            if (counter++ % LONG_DELAY_FREQ == 0)
                sleepTime += LONG_DELAY_ADDED_TIME;
            System.out.println("Waiting for " + sleepTime + " ms");
            Thread.sleep(sleepTime);
        }
    }

    public void followUsersThatAreFollowingBack() throws IOException {
        //list of followers
        List<String> followers = new ArrayList<>();
        followers.addAll(extractUsers("src/main/java/com/homework/instagram/followers.txt"));
        //followers.stream().forEach(System.out::println);

        //list of following
        List<String> following = new ArrayList<>();
        following.addAll(extractUsers("src/main/java/com/homework/instagram/following.txt"));
        //following.stream().forEach(System.out::println);

        //list of users that are followers but i don't follow
        List<String> differences = new ArrayList<>(followers);
        differences.removeAll(following);
        differences.stream().forEach(System.out::println);
        System.out.println("---sfarsit de lista de dat follow---");
        System.out.println("-------------------------------");
        System.out.println();
        int numberOfErrors=0;

        //follow users that are following
        for (String user : differences) {
            System.out.println("Following user: " + user);
            numberOfErrors+=follow(user);
            if (numberOfErrors>3){
                System.out.println("Number of errors > 3");
                return;
            }


        }
    }

    public void instagramLogin(String username, String password) {
        navigate("https://www.instagram.com/");
        sleep(1000);
        find(By.xpath(".//*[@class=\"aOOlW  bIiDR  \"]")).click();


        WebElement user = new WebDriverWait(driver, 3)
                .until(d -> find(By.xpath(".//*[@aria-label=\"Phone number, username, or email\"]")));
        user.sendKeys((CharSequence) username);

        WebElement pw = new WebDriverWait(driver, 3)
                .until(d -> find(By.xpath(".//*[@name=\"password\"]")));
        pw.sendKeys((CharSequence) password);

        find(By.xpath("//div[contains(text(),'Log In')]")).click();
        sleep((int) (random() * 1000));
        find(By.xpath("//button[contains(text(),'Not Now')]")).click();
        find(By.xpath(".//*[@class=\"aOOlW   HoLwm \"]")).click();
    }

    public int unfollow(String person) {

        navigate("https://www.instagram.com/" + person + "/");
        sleep((int) (random() * 500));
        int isError = 0;
        try {
            find(By.xpath(".//*[@aria-label=\"Following\"]")).click();
            sleep((int) (random() * 500));
            find(By.xpath("//button[contains(text(),'Unfollow')]")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Follow')]")));

        } catch (Exception e) {
            System.out.println("Can't find Following button for user " + person);
            isError = 1;
        }
        return isError;
    }

    public boolean checkIfUnfollowIsSuccessfull() {
        boolean present;
        try {
            sleep((int) (random() * 1000));
            driver.findElement(By.xpath("//button[contains(text(),'Follow')]"));
            present = true;
        } catch (NoSuchElementException e) {
            present = false;
        }
        return present;
    }

    public boolean checkIfUnfollowLimitIsReached() {
        boolean present;
        try {
            sleep((int) (random() * 1000));
            driver.findElement(By.xpath("//div[contains(text(),'We limit how often you can do certain things on Instagram, like unfollowing people, to protect our community.')]"));
            present = true;
        } catch (NoSuchElementException e) {
            present = false;
        }
        return present;
    }

    public int follow(String person) {
        navigate("https://www.instagram.com/" + person + "/");
        sleep((int) (random() * 500));
        int isError = 0;
        try {
            find(By.xpath("//button[contains(text(),'Follow')]")).click();
            sleep((int) (1000+random()*500));
        } catch (Exception e) {
            System.out.println("Can't find Follow button for user " + person);
            isError = 1;
        }
        return isError;
        //sleep((int) (random() * 20000));
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
