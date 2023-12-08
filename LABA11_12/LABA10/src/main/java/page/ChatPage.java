package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChatPage extends BasePage {

    public ChatPage(WebDriver driver) {
        super(driver);
    }

    public void askQuestion(String question) throws InterruptedException {
        WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"webim_chat\"]/div/div[2]/div[3]/div[1]/div[1]/div[3]/div[1]/div[2]/div/div[5]/div[2]"));
        searchInput.sendKeys(question);
        Thread.sleep(5000);

        WebElement feed2 = driver.findElement(By.xpath("//*[@id=\"webim_chat\"]/div/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div/div/svg"));
        feed2.click();
    }
}