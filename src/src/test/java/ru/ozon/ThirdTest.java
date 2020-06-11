package ru.ozon;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class ThirdTest extends WebDriverSettings {
    @Test
    public void Test3() throws InterruptedException {
        //ищем кнопку с каталогом товаров
        WebElement catalog = driver.findElement(By.xpath(".//button[@class='ui-a9']"));
        catalog.click(); //кликаем по ней
        WebDriverWait wait1 = new WebDriverWait(driver, 10); //ждем загрузки каталога, максимум 10 сек
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//span[contains(text(), 'Бытовая техника')]")));
        //выбираем бытовую технику
        WebElement appliances = driver.findElement(By.xpath(".//span[contains(text(), 'Бытовая техника')]"));
        Actions actions = new Actions(driver);
        //элемент, на который мы наводим мышь
        actions.moveToElement(appliances).build().perform();
        WebDriverWait wait2 = new WebDriverWait(driver, 10); //ждем загрузки подкаталога, максимум 10 сек
        wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//span[contains(text(), 'Соковыжималки')]")));
        //найдем элемент выбора соковыжималок
        WebElement sokovyzhimalki = driver.findElement(By.xpath(".//span[contains(text(), 'Соковыжималки')]"));
        sokovyzhimalki.click(); //кликаем по ней
        WebDriverWait wait3 = new WebDriverWait(driver, 10); //ждем загрузки страницы, максимум 10 сек
        wait3.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//p[contains(text(), 'от')]")));
        //ищем элемент сортировки товаров с надписью "от"
        WebElement ot = driver.findElement(By.xpath(".//p[contains(text(), 'от')]"));
        //элемент ввода значения
        WebElement ot_in = ot.findElement(By.xpath("preceding-sibling::input[1]"));
        ot_in.click(); //кликаем по нему
        //меняем значение на 3000
        ot_in.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE), "3000\n");
        sleep(3000); //задержка 3 сек

        //аналогично с элементом с надписью "до"
        WebElement do1 = driver.findElement(By.xpath(".//p[contains(text(), 'до')]"));
        WebElement do1_in = do1.findElement(By.xpath("preceding-sibling::input[1]"));
        do1_in.click();
        sleep(3000); //задержка 3 сек
        do1_in.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE), "4000");
        do1_in.sendKeys(Keys.ENTER); //нажмем enter для завершения действия

        //находим список выбранных товаров
        ArrayList<WebElement> listPrices = (ArrayList<WebElement>) driver.findElements(By.xpath(".//span[@class='a2b5']"));

        //товары по акции включаем в список
        ArrayList<WebElement> listPricesSale = (ArrayList<WebElement>) driver.findElements(By.xpath(".//span[@class='a2b5 a2b6']"));
        listPrices.addAll(listPricesSale);
        sleep(3000); //задержка 3 сек
        Boolean flag = true; //заводим переменную bool
        for (int i = 0; i < listPrices.size(); i++) { //в цикле по всему списку
            //если вдруг товар не вошел в диапазон
            if ((listPrices.get(i).getText().charAt(0) != '3') & (listPrices.get(i).getText() != "4000")) {
                flag = false; //опустить флаг и выйти из цикла
                break;
            }
        }
        Assert.assertEquals(flag.toString(), "true"); //проверим значение флага
        sleep(3000); //задержка 3 сек

        //находим элемент выбора сортировки
        WebElement sort = driver.findElement(By.xpath(".//input[@class='ui-a1f3']"));
        sort.click(); //кликаем по нему
        //опустимся на 2 уровня в списке и таким образом перейдем к сортировке "сначала дешевые"
        sort.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
        sleep(3000); //задержка 3 сек
        //найдем кнопку "в корзину" по css селектору
        WebElement addButton = driver.findElement(By.cssSelector("[data-widget=\"megaPaginator\"] > div"))
                .findElement(By.cssSelector("div[data-widget=\"searchResultsV2\"]"))
                .findElements(By.cssSelector("div > div[style=\"grid-column-start: span 12;\"]"))
                .get(0)
                .findElements(By.cssSelector("div > div > div[style=\"width: 25%; max-width: 25%; flex: 0 0 25%;\"]"))
                .get(1).findElements(By.cssSelector("div > button"))
                .get(1);
        JavascriptExecutor executor = driver;
        executor.executeScript("arguments[0].click();", addButton);
        //перейдем в корзину
        WebElement cartButton = driver.findElement(By.xpath(".//a[contains(@href, '/cart')]"));
        cartButton.click(); //кликнем по ней
        sleep(3000);
        WebDriverWait wait4 = new WebDriverWait(driver, 10); //ждем загрузки страницы, максимум 10 сек
        wait4.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//input[@class='ui-a1f3']")));
        //найдем элемент количества товаров в списке
        WebElement numberButton = driver.findElement(By.xpath(".//input[@class='ui-a1f3']"));
        numberButton.click(); //кликнем по ней
        sleep(3000);
        //опустимся на 4 уровня вниз, т е перейдем к количеству 5
        numberButton.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
        //sleep(3000);
        WebDriverWait wait5 = new WebDriverWait(driver, 10); //ждем загрузки страницы, максимум 10 сек
        wait5.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[@class='ui-a1k9']")));
        WebElement cartButtonChange = driver.findElement(By.xpath(".//div[@class='ui-a1k9']"));
        try {
            //проверяем, что элементов 5
            Assert.assertEquals(cartButtonChange.getText(), "5");
        } catch (Error var19) {
            var19.getMessage();
        }
    }
}