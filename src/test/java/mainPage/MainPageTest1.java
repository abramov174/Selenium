package mainPage;

import browser.Browser;
import constant.CategoryCards;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.demoqa.main_pages.MainPage;
import pages.demoqa.secondPage.LeftPanel;
import pages.demoqa.secondPage.SecondPage;
import pages.elements.CheckBoxPage;

public class MainPageTest1 {
    // Объявляем WebDriver для управления браузером
    private WebDriver driver;
    // Экземпляр главной страницы
    private MainPage mainPage;
    // Экземпляр второй страницы
    private SecondPage secondPage;
    // Панель навигации слева
    private LeftPanel leftPanel;
    // Экземпляр страницы с чекбоксами
    private CheckBoxPage checkBoxPage;

    @BeforeTest
    public void beforeTest() {
        // Инициализируем браузер и страницы перед началом тестов
        driver = Browser.createDriver();
        mainPage = new MainPage(driver);
        leftPanel = new LeftPanel(driver);
    }

    @AfterTest
    public void afterTest() {
        // Закрываем браузер после завершения тестов
        driver.quit();
    }

    // Тест на проверку отображения главной страницы и её элементов
    @Test
    public void step_01() {
        // Открываем главную страницу
        mainPage.openMainPage();
        // Проверяем, что баннер на главной странице отображается
        Assert.assertTrue(mainPage.isElementDisplay(MainPage.HOME_BANNER));
        // Проверяем, что количество категорий на главной странице равно 6
        Assert.assertEquals(mainPage.getCategoryCount(), 6);
    }

    // Тест на переход в категорию "Elements" и проверку открытия страницы
    @Test
    public void step_02() {
        // Переходим в категорию "Elements"
        secondPage = mainPage.openCategoryCards(CategoryCards.ELEMENTS);
        // Проверяем, что вторая страница открыта
        Assert.assertTrue(secondPage.isPageOpen());
        // Проверяем, что левая панель отображается
        Assert.assertTrue(leftPanel.isLeftPanelDisplayed());
        // Проверяем, что блок "Elements" открыт на левой панели
        Assert.assertTrue(leftPanel.isBlockOpen(CategoryCards.ELEMENTS));
    }

    // Тест на установку чекбокса "Home"
    @Test
    public void step_03() {
        // Переходим на страницу с чекбоксами через левую панель
        checkBoxPage = leftPanel.openCheckBoxPage();
        // Проверяем текущее состояние чекбокса "Home" (при необходимости)
        checkBoxPage.getCheckBoxState("Home");
        // Устанавливаем чекбокс "Home" в состояние "выбран"
        checkBoxPage.setCheckBox("Home", true);
    }
}
