package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ComparisonPage {

    private WebDriver driver;

    public ComparisonPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean areProductsDisplayedForComparison() {
        WebElement comparisonResults = driver.findElement(By.xpath("//*[@id=\"product\"]/div/div[2]/div[2]"));
        return comparisonResults.isDisplayed();
    }
}
