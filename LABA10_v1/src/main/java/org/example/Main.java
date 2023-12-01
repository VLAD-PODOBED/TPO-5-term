package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver", "C:\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        try {
            // Тест-кейс 1: Поиск продукта
            driver.get("https://www.samsung.com/ru/");
            WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"component-id\"]/div[1]/div[6]/div[1]/button"));
            searchButton.click();

            Thread.sleep(10000);
            CharSequence input = "Galaxy S21";
            WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"gnb-search-keyword\"]"));
            searchInput.sendKeys(input.toString());
            searchInput.sendKeys(Keys.ENTER);

            Thread.sleep(5000);
            WebElement searchResults = driver.findElement(By.xpath("//*[@id=\"product\"]/div/div[2]/div[2]"));

            if (searchResults.isDisplayed()) {
                System.out.println("Тест успешно выполнен: Отображаются результаты поиска, соответствующие введенному запросу.");
            } else {
                System.out.println("Тест не пройден: Результаты поиска не отображаются или не соответствуют введенному запросу.");
            }

            // Тест-кейс 2: Проверка функционала "Сравнение товаров"
            driver.get("https://www.samsung.com/ru/");
            WebElement compareButton = driver.findElement(By.xpath("//*[@id=\"component-id\"]/div[1]/div[5]/ul[1]/li[1]/button"));
            compareButton.click();

            WebElement compareSubButton = driver.findElement(By.xpath("//*[@id=\"component-id\"]/div[1]/div[5]/ul[1]/li[1]/div/div[1]/ul/li[1]/a"));
            compareSubButton.click();

            Thread.sleep(5000);

            WebElement compareLink = driver.findElement(By.xpath("//*[@id=\"component-id\"]/div/div[2]/ul/li[1]/a"));
            compareLink.click();

            Thread.sleep(5000);
            WebElement comparisonResults = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[3]/div/div[1]/section/div/div[2]/div[1]/div/div[2]/div/div[1]/div/ul/li[1]/div/div"));

            if (comparisonResults.isDisplayed()) {
                System.out.println("Тест успешно выполнен: Выбранные товары успешно добавлены для сравнения.");
            } else {
                System.out.println("Тест не пройден: Выбранные товары не отображаются для сравнения.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
