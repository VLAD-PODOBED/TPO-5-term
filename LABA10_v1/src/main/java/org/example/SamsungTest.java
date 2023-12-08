package org.example;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class main {

    private WebDriver driver;
    private SamsungHomePage homePage;
    private SamsungComparisonPage comparisonPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\msedgedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        homePage = new SamsungHomePage(driver);
        comparisonPage = new SamsungComparisonPage(driver);
    }

    @Test(priority = 1)
    public void testSamsungComparison() {
        homePage.openHomePage("https://www.samsung.com/ru/");
        homePage.clickSearchButton();
        homePage.performSearch("Galaxy S21");

        Assert.assertTrue(homePage.areSearchResultsDisplayed(), "Search results are not displayed.");

        homePage.openHomePage("https://www.samsung.com/ru/");
        homePage.clickSearchButton();
        homePage.performSearch("Some other query");

        Assert.assertTrue(homePage.areSearchResultsDisplayed(), "Search results are not displayed for another query.");

        comparisonPage.navigateToComparisonPage();

        Assert.assertTrue(comparisonPage.areSelectedProductsDisplayed(), "Selected products are not displayed for comparison.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}