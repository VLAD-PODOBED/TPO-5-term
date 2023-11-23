package org.example;

        import org.openqa.selenium.By;
        import org.openqa.selenium.Keys;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.edge.EdgeDriver;
        import org.openqa.selenium.support.events.WebDriverEventListener;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;

        import java.time.Duration;
        import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        // Установка пути к драйверу браузера Microsoft Edge
        System.setProperty("webdriver.edge.driver", "C:\\msedgedriver.exe");


        // Создание экземпляра веб-драйвера для Microsoft Edge
        WebDriver driver = new EdgeDriver();
        // Максимизация окна браузера
        driver.manage().window().maximize();

        try {
            // Открытие URL
            driver.get("https://www.samsung.com/ru/");
            WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"component-id\"]/div[1]/div[6]/div[1]/button"));
            searchButton.click();

            // Ввод запроса в поле поиска
            CharSequence input = "Galaxy S21";
            WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"gnb-search-keyword\"]"));
            searchInput.sendKeys(input.toString());


            // Нажатие на Enter (или можно также кликнуть на кнопку поиска, если она отображается)
            searchInput.sendKeys(Keys.ENTER);

            // Ожидание появления результатов поиска
            Thread.sleep(5000); // Подождем 5 секунд (можно использовать WebDriverWait в реальных тестах)

            // Проверка, что результаты поиска отображаются
            WebElement searchResults = driver.findElement(By.xpath("//*[@id=\"product\"]/div/div[2]/div[2]")); // Предположим, что результаты находятся в этом элементе

            if (searchResults.isDisplayed()) {
                System.out.println("Тест успешно выполнен: Отображаются результаты поиска, соответствующие введенному запросу.");
            } else {
                System.out.println("Тест не пройден: Результаты поиска не отображаются или не соответствуют введенному запросу.");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Закрытие браузера после выполнения теста
            driver.quit();
        }
    }
}