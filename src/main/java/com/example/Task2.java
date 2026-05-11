package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Task2 {
    public static void run(WebDriver driver) {
        try {
            driver.get("https://api.ipify.org/?format=json");
            String jsonText = driver.findElement(By.tagName("body")).getText();
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(jsonText);
            String ip = (String) json.get("ip");
            System.out.println("Ваш IP-адрес (задание 2): " + ip);
        } catch (Exception e) {
            System.out.println("Ошибка при получении IP: " + e.toString());
        }
    }
}