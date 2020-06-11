package ru.ozon;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;

public class SecondTest extends WebDriverSettings {
    @Test //показатель тестового метода
    public void Test2() throws InterruptedException {
        //ищем элемент смены города (в левом верхнем углу)
        //WebElement town1 = driver.findElement(By.xpath(".//button[@class='c5j0']"));
        WebElement town1 = driver.findElement(By.xpath(".//button[@class='c5i8']"));
        town1.click(); //кликаем по нему
        //ищем элемент ввода города в вышедшем окне
        WebElement town1_in = driver.findElement(By.xpath(".//input[@class='ui-av9 ui-av6']"));
        sleep(3000); //задержка 3 сек
        town1_in.sendKeys("Саратов"); //вводим туда Саратов
        //sleep(3000); //задержка 3 сек
        //ищем элемент, подходящий под описание самым первым
        WebElement town1_first = driver.findElement(By.xpath("//a[@class='a7']"));
        town1_first.click(); //кликаем по нему
        sleep(3000); //задержка 3 сек
        //читаем название города, получившегося в результате этих операций
        String town1_res = driver.findElement(By.xpath(".//span[@class='c5j0']")).getText();
        sleep(3000); //задержка 3 сек

        //те же операции со сменой названия города на Вольск

        WebElement town2 = driver.findElement(By.xpath(".//button[@class='c5i8']"));
        town2.click();
        WebElement town2_in = driver.findElement(By.xpath(".//input[@class='ui-av9 ui-av6']"));
        sleep(3000); //задержка 3 сек
        town2_in.sendKeys("Вольск");
        sleep(3000);
        WebElement chooseElementTwice = driver.findElement(By.xpath("//a[@class='a7']"));
        chooseElementTwice.click();
        sleep(3000);
        String town2_res = driver.findElement(By.xpath(".//span[@class='c5j0']")).getText();
        Assert.assertFalse(town1_res, town2_res.equals(town1_res)); //проверка на изменение значения
        sleep(3000); //задержка 3 сек
        //найдем элемент окна по xpath, а именно кнопку "вход или регистрация"
        WebElement sign_in = driver.findElement(By.xpath(".//div[@class='ui-b']"));
        sign_in.click(); //кликаем по нему
        sleep(40000); //задержка 50 сек
        //найдем элемент "пункты выдачи" по ссылке
        WebElement pointOfIssue = driver.findElement(By.xpath(".//a[contains(@href, '//www.ozon.ru/info/map/')]"));
        pointOfIssue.click(); //кликаем по нему
        sleep(3000); //задержка 3 сек
        //ищем название города в поле выбора пунктов выдачи
        String cityName = driver.findElement(By.xpath(".//span[@class='city-name-inner']")).getText();
        //проверка значения города в верхнем углу и города доставки
        Assert.assertEquals(town2_res, cityName);
        sleep(3000); //задержка 3 сек
    }
}
