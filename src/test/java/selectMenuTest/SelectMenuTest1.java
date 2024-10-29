package selectMenuTest;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.elements.DynamicPropertiesPage;

public class SelectMenuTest1 {
    // Объявляем WebDriver для управления браузером
    private WebDriver driver;
    // Экземпляр страницы с динамическими свойствами
    private DynamicPropertiesPage dynamicPropertiesPage;

    @BeforeTest
    public void beforeTest() {
        // Инициализируем браузер и страницу перед началом тестов
        driver = Browser.createDriver();
        dynamicPropertiesPage = new DynamicPropertiesPage(driver);
    }

    @AfterTest
    public void afterTest() {
        // Закрываем браузер после завершения тестов
        driver.quit();
    }

    // Тест на выбор элемента из выпадающего меню
    @Test
    public void step_1() {
        // Открываем страницу с выпадающим меню
        dynamicPropertiesPage.openUrl("https://demoqa.com/select-menu");
        // Инициализируем объект Select для работы с выпадающим списком с id="cars"
        Select select = new Select(dynamicPropertiesPage.findElement(By.id("cars")));
        // Выбираем элемент с текстом "Saab" в выпадающем меню
        select.selectByVisibleText("Saab");
        // Получаем выбранный элемент для проверки
        WebElement option = select.getFirstSelectedOption();
        // Сохраняем текст выбранного элемента в переменную
        String defaultItem = option.getText();
        // (Возможная проверка: сравнить выбранное значение с ожидаемым значением)
        Assert.assertEquals(defaultItem, "Saab", "Выбран неверный элемент в меню.");
    }
}
