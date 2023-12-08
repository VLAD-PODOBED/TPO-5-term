package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TheHomePage extends BasePage {

    public TheHomePage(WebDriver driver) {
        super(driver);
    }

    public void open() throws InterruptedException {
        Thread.sleep(10000);
        driver.get("https://www.samsung.com/ru/");
    }

    public WebElement getFeedElement() throws InterruptedException {
        Thread.sleep(10000);
        return driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/img"));
    }

    public WebElement getFeed1Element() throws InterruptedException {
        Thread.sleep(10000);
        return driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[1]/div"));
    }

}