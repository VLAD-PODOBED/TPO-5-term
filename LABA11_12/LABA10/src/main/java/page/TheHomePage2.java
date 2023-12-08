package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TheHomePage2 extends BasePage {

    public TheHomePage2(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.samsung.com/ru/");
    }

    public WebElement getSearchElement() throws InterruptedException {
        Thread.sleep(10000);
        return driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/img"));
    }

    public WebElement getSearch1Element() throws InterruptedException {
        Thread.sleep(10000);
        return driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[1]/div"));
    }
}