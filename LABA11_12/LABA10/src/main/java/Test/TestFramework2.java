package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import page.TheHomePage;
import page.TVPage;

public class TestFramework2 {

    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver", "C:\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver();
        // Максимизация окна браузера
        driver.manage().window().maximize();

        // Initialize page objects
        TheHomePage homePage = new TheHomePage(driver);
        TVPage tvPage = new TVPage(driver);

        // Test scenario
        try {
            // Home page actions
            homePage.open();
            homePage.getFeedElement().click();
            homePage.getFeed1Element().click();

            // TV page actions
            tvPage.selectTVModel();
            tvPage.performAdditionalTVActions();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}