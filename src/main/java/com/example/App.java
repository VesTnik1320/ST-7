package com.example;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/Дополнительно/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        try {
            // Задание №1
            driver.get("https://www.calculator.net/password-generator.html");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45));
            By passwordLocator = By.cssSelector("#resultid div.verybigtext b");
            wait.until(ExpectedConditions.presenceOfElementLocated(passwordLocator));
            WebElement passwordEl = driver.findElement(passwordLocator);
            System.out.println("Пароль (задание 1): " + passwordEl.getText());

            // Задание №2
            Task2.run(driver);

            // Задание №3
            Task3.run(driver);

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.toString());
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}