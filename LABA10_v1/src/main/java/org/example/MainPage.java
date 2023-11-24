package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.samsung.com/ru/");
    }

    public void search(String query) throws InterruptedException {
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"component-id\"]/div[1]/div[6]/div[1]/button"));
        searchButton.click();

        Thread.sleep(10000);
        WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"gnb-search-keyword\"]"));
        searchInput.sendKeys(query);
        searchInput.sendKeys(Keys.ENTER);
    }

    public boolean areSearchResultsDisplayed() throws InterruptedException {
        Thread.sleep(5000);
        WebElement searchResults = driver.findElement(By.xpath("//*[@id=\"product\"]/div/div[2]/div[2]"));
        return searchResults.isDisplayed();
    }

    public void closeBrowser() {
        driver.quit();
    }
}
