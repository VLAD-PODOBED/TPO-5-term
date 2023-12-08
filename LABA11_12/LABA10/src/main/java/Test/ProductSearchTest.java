package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import page.HomePage;

public class ProductSearchTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver", "C:\\msedgedriver.exe");


        // Создание экземпляра веб-драйвера для Microsoft Edge
        WebDriver driver = new EdgeDriver();
        // Максимизация окна браузера
        driver.manage().window().maximize();

        try {
            HomePage homePage = new HomePage(driver);

            // Test Case 1: Product Search
            homePage.openHomePage();
            homePage.clickSearchButton();
            Thread.sleep(15000);
            homePage.searchForProduct("Galaxy S21");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }
}