package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ComparisonPage {
    private final WebDriver driver;

    public ComparisonPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openComparisonPage() {
        driver.get("https://www.samsung.com/ru/");
    }

    public boolean areSelectedProductsDisplayed() throws InterruptedException {

        Thread.sleep(10000);
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"component-id\"]/div[1]/div[5]/ul[1]/li[1]/button"));
        Thread.sleep(10000);
        searchButton.click();

        Thread.sleep(10000);
        WebElement searchButton1 = driver.findElement(By.xpath("//*[@id=\"component-id\"]/div[1]/div[5]/ul[1]/li[1]/div/div[1]/ul/li[1]/a"));
        Thread.sleep(10000);
        searchButton1.click();

        Thread.sleep(10000);
        WebElement searchButton2 = driver.findElement(By.xpath("//*[@id=\"component-id\"]/div/div[2]/ul/li[1]/a"));
        Thread.sleep(10000);
        searchButton2.click();

        Thread.sleep(10000);
        WebElement searchButton3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[3]/div/div[1]/section/div/div[2]/div[1]/div/div[2]/div/div[1]/div/ul/li[1]/div/div"));
        Thread.sleep(10000);
        searchButton3.click();

        return searchButton3.isDisplayed();
    }
}