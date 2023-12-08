package Struct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class ProductFeed {

    public static void main(String[] args) {
        // Установка пути к драйверу браузера Microsoft Edge
        System.setProperty("webdriver.edge.driver", "C:\\msedgedriver.exe");


        // Создание экземпляра веб-драйвера для Microsoft Edge
        WebDriver driver = new EdgeDriver();
        // Максимизация окна браузера
        driver.manage().window().maximize();

        try {
            driver.get("https://www.samsung.com/ru/");

            Thread.sleep(5000);
            WebElement feed = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/img")); // Предположим, что результаты находятся в этом элементе
            feed.click();

            Thread.sleep(5000);
            WebElement feed1 = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[1]/div"));
            feed1.click();

            Thread.sleep(5000);
            CharSequence input2 = "когда вернется товар ?";
            Thread.sleep(5000);
            WebElement searchInput2 = driver.findElement(By.xpath("//*[@id=\"webim_chat\"]/div/div[2]/div[3]/div[1]/div[1]/div[3]/div[1]/div[2]/div/div[5]/div[2]"));
            searchInput2.sendKeys(input2.toString());

            Thread.sleep(5000);
            WebElement feed2= driver.findElement(By.xpath("//*[@id=\"webim_chat\"]/div/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div/div/svg"));
            feed2.click();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Закрытие браузера после выполнения теста
            driver.quit();
        }



}
}