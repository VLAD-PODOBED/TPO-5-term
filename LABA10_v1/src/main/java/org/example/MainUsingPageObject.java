package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class MainUsingPageObject {

    public static void main(String[] args) {

        System.setProperty("webdriver.edge.driver", "C:\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();

        HomePage homePage = new HomePage(driver);
        ComparisonPage comparisonPage = new ComparisonPage(driver);

        try {
            homePage.openPage();
            homePage.clickOnFirstProduct();
            homePage.clickCompareButton();

            driver.get("https://www.samsung.com/ru/compare/");

            if (comparisonPage.areProductsDisplayedForComparison()) {
                System.out.println("Тест успешно выполнен: Выбранные товары успешно добавлены для сравнения.");
            } else {
                System.out.println("Тест не пройден: Выбранные товары не отображаются для сравнения.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
