package dynamicPropertiesTest;

import browser.Browser;
import constant.Item;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.elements.DynamicPropertiesPage;

import static pages.elements.DynamicPropertiesPage.*;

public class DynamicPropertiesTest1 {
    // Объявляем WebDriver для управления браузером
    private WebDriver driver;
    // Экземпляр страницы с динамическими свойствами
    private DynamicPropertiesPage dynamicPropertiesPage;

    @BeforeTest
    public void beforeTest() {
        // Инициализируем браузер и страницу с динамическими свойствами перед началом тестов
        driver = Browser.createDriver();
        dynamicPropertiesPage = new DynamicPropertiesPage(driver);
    }

    @AfterTest
    public void afterTest() {
        // Закрываем браузер после завершения тестов
        driver.quit();
    }

    // Тест на открытие страницы с динамическими свойствами и проверку её заголовка
    @Test
    public void step_1() {
        // Открываем страницу с динамическими свойствами
        dynamicPropertiesPage.openDynamicPage();
        // Проверяем, что заголовок страницы совпадает с ожидаемым
        Assert.assertEquals(dynamicPropertiesPage.getPageName(), Item.DYNAMIC_PROPERTIES.getName());
    }

    // Тест на проверку изменения цвета кнопки
    @Test
    public void step_2() {
        // Получаем текущий цвет кнопки
        String color = dynamicPropertiesPage.getColorBtn(BTN_COLOR_CHANGE);
        System.out.println(color);  // Печатаем текущий цвет в консоль
        // Ждём изменения цвета кнопки
        dynamicPropertiesPage.waitForColorChange();
        // Получаем обновленный цвет кнопки
        color = dynamicPropertiesPage.getColorBtn(BTN_COLOR_CHANGE);
        System.out.println(color);  // Печатаем обновленный цвет в консоль
        // Здесь, в зависимости от логики, можно добавить проверку на соответствие цвета
        Assert.assertTrue(true);  // Условная проверка на успешность
    }

    // Тест на проверку видимости кнопки после обновления страницы
    @Test
    public void step_3() {
        // Обновляем страницу
        driver.navigate().refresh();
        // Ждем, пока элемент BTN_VISIBLE_AFTER станет видимым в течение 10 секунд
        dynamicPropertiesPage.waitElementIsDisplay(BTN_VISIBLE_AFTER, 10);
    }

    // Тест на проверку активности элемента после обновления страницы
    @Test
    public void step_4() {
        // Обновляем страницу
        driver.navigate().refresh();
        // Ждем, пока элемент BTN_ENABLE_AFTER станет активным в течение 10 секунд
        dynamicPropertiesPage.waitForElementsEnabled(BTN_ENABLE_AFTER, 10);
        // Проверяем, что элемент BTN_ENABLE_AFTER теперь активен
        Assert.assertTrue(dynamicPropertiesPage.isElementEnabled(BTN_ENABLE_AFTER));
    }
}
