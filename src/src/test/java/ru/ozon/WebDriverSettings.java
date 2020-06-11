package ru.ozon;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverSettings {
    public ChromeDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Master\\Downloads\\chromedriver1\\chromedriver.exe");
        driver = new ChromeDriver(); //инициализация веб-драйвера
        driver.get("https://www.ozon.ru/"); //get открывает страницу
        driver.manage().window().maximize(); //расширим окно
        System.out.println("test started");
    }

    @After
    public void close() {
        System.out.println("test finished");
        driver.quit(); //закрытие страницы после загрузки
    }
}
