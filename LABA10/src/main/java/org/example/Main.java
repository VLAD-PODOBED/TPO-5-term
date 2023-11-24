package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Main {
    public static void main(String[] args) {
        // Установка пути к драйверу браузера Microsoft Edge
        System.setProperty("webdriver.edge.driver", "C:\\msedgedriver.exe");

        // Создание экземпляра веб-драйвера для Microsoft Edge
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        try {
            MainPage mainPage = new MainPage(driver);
            mainPage.open();
            mainPage.search("Galaxy S21");

            if (mainPage.areSearchResultsDisplayed()) {
                System.out.println("Тест успешно выполнен: Отображаются результаты поиска, соответствующие введенному запросу.");
            } else {
                System.out.println("Тест не пройден: Результаты поиска не отображаются или не соответствуют введенному запросу.");
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }
}