package checkBoxTest;

import browser.Browser;
import constant.Item;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.elements.CheckBoxPage;

public class CheckBoxTest1 {
    // Объявляем WebDriver для управления браузером
    private WebDriver driver;
    // Экземпляр страницы с чекбоксами
    private CheckBoxPage checkBoxPage;

    @BeforeTest
    public void beforeTest() {
        // Инициализируем браузер и страницу с чекбоксами перед началом тестов
        driver = Browser.createDriver();
        checkBoxPage = new CheckBoxPage(driver);
    }

    @AfterTest
    public void afterTest() {
        // Закрываем браузер после завершения тестов
        driver.quit();
    }

    // Тест на открытие страницы с чекбоксами и проверку её заголовка
    @Test
    public void step_1() {
        // Открываем страницу с чекбоксами
        checkBoxPage.openCheckBoxPage();
        // Проверяем, что заголовок страницы совпадает с ожидаемым
        Assert.assertEquals(checkBoxPage.getPageName(), Item.CHECK_BOX.getName());
    }

    // Тест на установку и проверку состояния чекбокса
    @Test
    public void step_2() {
        // Открываем список чекбоксов, начиная с "Home"
        checkBoxPage.openListCheckBox("Home");
        // Устанавливаем чекбокс "Desktop" в состояние "выбран"
        checkBoxPage.setCheckBox("Desktop", true);
        // Проверяем, что чекбокс "Desktop" установлен
        Assert.assertTrue(checkBoxPage.getCheckBoxState("Desktop"));
    }
}
