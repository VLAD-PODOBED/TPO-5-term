package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import page.ChatPage;
import page.TheHomePage;

public class TheProductHomePage {

    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver", "C:\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver();
        // Максимизация окна браузера
        driver.manage().window().maximize();

        TheHomePage homePage = new TheHomePage(driver);
        ChatPage chatPage = new ChatPage(driver);

        try {
            homePage.open();
            homePage.getFeedElement().click();
            homePage.getFeed1Element().click();

            chatPage.askQuestion("когда вернется товар ?");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}