package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import page.TheHomePage2;
import page.SearchPage;

public class TestFramework3 {

    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver", "C:\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        // Initialize page objects
        TheHomePage2 homePage = new TheHomePage2(driver);
        SearchPage searchPage = new SearchPage(driver);

        // Test scenario
        try {
            // Home page actions
            homePage.open();
            homePage.getSearchElement().click();
            homePage.getSearch1Element().click();

            // Search page actions
            searchPage.performSearch("когда вернется товар ?");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}