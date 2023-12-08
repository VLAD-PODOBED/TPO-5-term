package Test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import page.HomePage;
import page.ComparisonPage;

public class ProductComparisonTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver", "C:\\msedgedriver.exe");


        // Создание экземпляра веб-драйвера для Microsoft Edge
        WebDriver driver = new EdgeDriver();
        // Максимизация окна браузера
        driver.manage().window().maximize();

        try {
            HomePage homePage = new HomePage(driver);
            ComparisonPage comparisonPage = new ComparisonPage(driver);

            // Test Case 2: Product Comparison
            homePage.openHomePage();
            Thread.sleep(10000);
            homePage.clickSearchButton();
            homePage.searchForProduct("Galaxy Z");

            // Navigate to comparison page
            comparisonPage.openComparisonPage();

            // Verification
            if (comparisonPage.areSelectedProductsDisplayed()) {
                System.out.println("Ура!!!Тест-кейсы прошли успешно");
            } else {
                System.out.println("Парень, ты что-то перепутал");
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }
}