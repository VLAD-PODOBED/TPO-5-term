package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void performSearch(String query) throws InterruptedException {
        Thread.sleep(5000);

        WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"webim_chat\"]/div/div[2]/div[3]/div[1]/div[1]/div[3]/div[1]/div[2]/div/div[5]/div[2]"));
        searchInput.sendKeys(query);

        Thread.sleep(5000);

        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"webim_chat\"]/div/div[2]/div[3]/div[1]/div[1]/div[3]/div[1]/div[2]/div/div[5]/button[1]"));
        searchButton.click();
    }
}