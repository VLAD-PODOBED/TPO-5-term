package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Установка пути к драйверу Microsoft Edge WebDriver
        System.setProperty("webdriver.edge.driver", "C:\\msedgedriver.exe");

        // Создание экземпляра драйвера
        WebDriver driver = new EdgeDriver();

        // Максимизация окна браузера
        driver.manage().window().maximize();

        // Открытие URL: https://www.samsung.com/ru/
        driver.get("https://www.samsung.com/ru/");

        // Выбрать категорию товаров (например, "Телефоны")
        WebElement category = driver.findElement(By.xpath("//*[@id=\"component-id\"]/div[1]/div[5]/ul[1]/li[1]/button"));
        category.click();

        WebElement category1 = driver.findElement(By.xpath("//*[@id=\"component-id\"]/div[1]/div[5]/ul[1]/li[1]/div/div[1]/ul/li[1]/a"));
        category1.click();

        driver.get("https://www.samsung.com/ru/mobile/");

        WebElement category2 = driver.findElement(By.xpath("//*[@id=\"component-id\"]/div/div[2]/ul/li[3]/a/div[1]"));
        category2.click();

        WebElement category3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[3]/div/div[2]/section/div/div[2]/div[1]/div/div[2]/div/div[1]/div/ul/li[1]/div/div/label"));
        category3.click();


        // Проверить, что на странице отображаются только товары, удовлетворяющие выбранным параметрам
        List<WebElement> products = driver.findElements(By.xpath("//*[@id=\"content\"]/div/div/div[3]/div/div[2]/section/div/div[2]/div[2]/div[1]/div[1]"));
        boolean allProductsPassFilter = true;
        for (WebElement product : products) {
            // Проверяем, что каждый товар принадлежит к серии Galaxy Z
            WebElement seriesElement = product.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[3]/div/div[2]/section/div/div[2]/div[2]/div[1]/div[1]/div/div/div[2]/div[1]/div[1]/a/p, 'Galaxy Z')]"));
            if (seriesElement == null) {
                allProductsPassFilter = false;
                break;
            }
        }

        // Вывод результата
        if (allProductsPassFilter) {
            System.out.println("Товары успешно фильтруются в соответствии с выбранными параметрами");
        } else {
            System.out.println("Ошибка: Товары не соответствуют выбранным параметрам");
        }

        // Закрыть браузер
        driver.quit();
    }
}
