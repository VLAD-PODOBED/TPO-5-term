package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import page.ChatPage;
import page.TheHomePage;

public class TestFramework {

    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver", "C:\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver();
        // Максимизация окна браузера
        driver.manage().window().maximize();

        // Initialize page objects
        TheHomePage homePage = new TheHomePage(driver);
        ChatPage chatPage = new ChatPage(driver);

        // Test scenario
        try {
            // Home page actions
            homePage.open();
            homePage.getFeedElement().click();
            homePage.getFeed1Element().click();

            // Chat page actions
            chatPage.askQuestion("когда вернется товар ?");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}