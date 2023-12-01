package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get("https://www.samsung.com/ru/");
    }

    public void clickOnFirstProduct() {
        WebElement firstProduct = driver.findElement(By.xpath("//*[@id=\"component-id\"]/div/div[2]/ul/li[1]/a/div[1]"));
        firstProduct.click();
    }

    public void clickCompareButton() {
        WebElement compareButton = driver.findElement(By.xpath("//button[contains(text(),'Сравнить товары')]"));
        compareButton.click();
    }
}

