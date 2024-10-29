package buttonTests;

import browser.Browser;
import constant.Item;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.elements.ButtonsPage;
import pages.elements.CheckBoxPage;

import static pages.elements.ButtonsPage.*;

public class ButtonTest1 {
    // Объявляем переменные для WebDriver и страницы с кнопками
    private WebDriver driver;
    private ButtonsPage buttonsPage;

    @BeforeTest
    public void beforeTest() {
        // Создаем экземпляр WebDriver и инициализируем ButtonsPage
        driver = Browser.createDriver();
        buttonsPage = new ButtonsPage(driver);
    }

    @AfterTest
    public void afterTest() {
        // Закрываем драйвер после завершения всех тестов
        driver.quit();
    }

    @Test
    public void step_1() {
        // Открываем страницу с кнопками и выполняем двойной клик
        buttonsPage.openButtonsPage();
        buttonsPage.doubleClick(DOUBLE_CLICK_BTN);
        // Проверяем, отображается ли сообщение о двойном клике
        Assert.assertTrue(buttonsPage.isMessageDisplay(MESSAGE_DOUBLE_CLICK));
    }

    @Test
    public void step_2() {
        // Выполняем правый клик по кнопке и проверяем сообщения
        buttonsPage.contextClick(RIGHT_CLICK_BTN);
        // Проверяем, отображается ли сообщение о двойном клике
        Assert.assertTrue(buttonsPage.isMessageDisplay(MESSAGE_DOUBLE_CLICK));
        // Проверяем, отображается ли сообщение о правом клике
        Assert.assertTrue(buttonsPage.isMessageDisplay(MESSAGE_RIGHT_CLICK));
    }

    @Test
    public void step_3() {
        // Выполняем обычный клик по кнопке и проверяем все сообщения
        buttonsPage.buttonClick("Click Me");
        // Проверяем, отображается ли сообщение о двойном клике
        Assert.assertTrue(buttonsPage.isMessageDisplay(MESSAGE_DOUBLE_CLICK));
        // Проверяем, отображается ли сообщение о правом клике
        Assert.assertTrue(buttonsPage.isMessageDisplay(MESSAGE_RIGHT_CLICK));
        // Проверяем, отображается ли сообщение о клике
        Assert.assertTrue(buttonsPage.isMessageDisplay(MESSAGE_CLICK));
    }
}
