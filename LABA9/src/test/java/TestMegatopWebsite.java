import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;

public class TestMegatopWebsite {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new OperaDriver();
        driver.get("https://megatop.by");
        WebElement searchIcon = driver.findElement(By.xpath("//*[@id=\"header-top\"]/div[5]/div/div/button/span/div/div/div[3]"));
        searchIcon.click();
        WebElement searchInputElement = driver.findElement(By.xpath("//div[@class='search v-card v-card--flat v-sheet theme--light']/../..//input[@type='text']"));
        searchInputElement.sendKeys("челси");
        searchInputElement.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        driver.quit();
    }
}