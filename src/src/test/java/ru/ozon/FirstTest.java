package ru.ozon;

import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static com.sun.xml.internal.messaging.saaj.packaging.mime.util.ASCIIUtility.getBytes;
import static java.lang.Thread.sleep;

public class FirstTest extends WebDriverSettings {
    public FirstTest() {
    }

    @Step("Проверка входа")
    public static void checkSignIn(String str1, String str2) throws IOException {
        Assert.assertEquals(str1, str2);
        getBytes("1-1.png");
    }

    @Test //показатель тестового метода
    public void Test1() throws InterruptedException {
        //найдем элемент окна по xpath, а именно кнопку "вход или регистрация"
        WebElement sign_in = driver.findElement(By.xpath(".//div[@class='ui-b']"));
        sign_in.click(); //кликаем по нему

        sleep(50000); //задержка 50 сек
        //аналогично ищем элемент профиля после регистрации
        //WebElement profile = driver.findElement(By.xpath(".//span[@class='a9r6']"));
        WebElement profile = driver.findElement(By.xpath(".//span[@class='bb2']"));
        Assert.assertEquals(profile.getText(), "Кабинет"); //проверка
        sleep(5000); //задержка 5 сек
    }

}
