package radioButtonTest;

import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.demoqa.secondPage.LeftPanel;
import pages.elements.RadioButtonPage;

public class RadioButtonTest1 {
    // Объявляем WebDriver для управления браузером
    private WebDriver driver;
    // Левая панель навигации
    private LeftPanel leftPanel;
    // Экземпляр страницы с радиокнопками
    private RadioButtonPage radioButtonPage;

    @BeforeClass
    public void beforeClass() {
        // Инициализируем браузер и страницы перед началом тестов
        driver = Browser.createDriver();
        leftPanel = new LeftPanel(driver);
        radioButtonPage = new RadioButtonPage(driver);
    }

    @AfterClass
    public void afterClass() {
        // Закрываем браузер после завершения тестов
        driver.quit();
    }

    // Тест на выбор радиокнопки "Yes" и проверку её состояния
    @Test
    public void step_01() {
        // Открываем страницу с радиокнопками
        radioButtonPage.openRadioButtonPage();
        // Кликаем на радиокнопку "Yes"
        radioButtonPage.clickRadioButton("Yes");
        // Проверяем, что радиокнопка "Yes" выбрана
        Assert.assertTrue(radioButtonPage.getStateRadioButton("Yes"));
    }

    // Тест на выбор радиокнопки "Impressive" и проверку состояния других кнопок
    @Test
    public void step_02() {
        // Открываем страницу с радиокнопками
        radioButtonPage.openRadioButtonPage();
        // Кликаем на радиокнопку "Impressive"
        radioButtonPage.clickRadioButton("Impressive");
        // Проверяем, что радиокнопка "Yes" не выбрана
        Assert.assertFalse(radioButtonPage.getStateRadioButton("Yes"));
        // Проверяем, что радиокнопка "Impressive" выбрана
        Assert.assertTrue(radioButtonPage.getStateRadioButton("Impressive"));
        // Проверяем, что радиокнопка "No" отключена и не может быть выбрана
        Assert.assertFalse(radioButtonPage.radioButtonIsEnabled("No"));
    }
}
