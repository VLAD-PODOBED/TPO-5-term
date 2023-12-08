package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openHomePage() {
        driver.get("https://www.samsung.com/ru/");
    }

    public void clickSearchButton() throws InterruptedException {
        Thread.sleep(10000);
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"component-id\"]/div[1]/div[6]/div[1]/button"));
        Thread.sleep(10000);
        searchButton.click();
    }

    public void searchForProduct(String productName) throws InterruptedException {
        Thread.sleep(10000);
        WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"gnb-search-keyword\"]"));
        searchInput.sendKeys(productName);
        Thread.sleep(10000);
        searchInput.sendKeys(Keys.ENTER);
    }

}