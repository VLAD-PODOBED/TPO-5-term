package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TVPage extends BasePage {

    public TVPage(WebDriver driver) {
        super(driver);
    }

    public void selectTVModel() throws InterruptedException {
        Thread.sleep(10000);

        WebElement tv1 = driver.findElement(By.xpath("//*[@id=\"component-id\"]/div[1]/div[5]/ul[1]/li[2]/div/div[4]/ul/li[7]/a"));
        tv1.click();

        Thread.sleep(10000);

        WebElement tv2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[3]/div/div[2]/section/div/div[2]/div[2]/div[1]/div[1]/div/div/div[2]/div[2]/div[7]/button"));
        tv2.click();

        // Add more actions as needed
    }

    public void performAdditionalTVActions() throws InterruptedException {
        // Add additional TV-related actions here
    }
}