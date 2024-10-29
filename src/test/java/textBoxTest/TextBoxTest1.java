package textBoxTest;

import browser.Browser;
import constant.CategoryCards;
import constant.Item;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.demoqa.main_pages.MainPage;
import pages.demoqa.secondPage.LeftPanel;
import pages.demoqa.secondPage.SecondPage;
import pages.elements.TextBoxPage;

import java.time.Duration;

public class TextBoxTest1 {
    // Объявляем переменные WebDriver и страниц
    private WebDriver driver;
    private MainPage mainPage;
    private TextBoxPage textBoxPage;
    private SecondPage secondPage;
    private LeftPanel leftPanel;

    // Данные для теста
    private String fullName = "Artem Abramov";
    private String email = "test@test.ru";
    private String curAddr = "Нижний Новгород";
    private String permAddr = "Москва";

    // Конструктор класса теста
    public TextBoxTest1() {}

    @BeforeClass
    public void beforeClass() {
        // Инициализация WebDriver и страниц перед тестами
        this.driver = Browser.createDriver();
        this.mainPage = new MainPage(this.driver);
        this.leftPanel = new LeftPanel(this.driver);
    }

    @AfterClass
    public void afterClass() {
        // Закрытие браузера после завершения тестов
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    @Test
    public void step_01() {
        // Открытие главной страницы приложения
        this.mainPage.openMainPage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Переход на страницу "Elements" и ожидание ее загрузки
        this.secondPage = this.mainPage.openCategoryCards(CategoryCards.ELEMENTS);
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(this.secondPage.getPageElement())) != null, "Страница Elements не загрузилась.");

        // Проверка, что левая панель элементов отображается
        Assert.assertTrue(this.leftPanel.isLeftPanelDisplayed(), "Левая панель не отображается.");

        // Проверка, что блок "Elements" открыт
        Assert.assertTrue(this.leftPanel.isBlockOpen(CategoryCards.ELEMENTS), "Блок Elements не открыт.");

        // Переход на страницу "TextBox" и проверка загрузки страницы
        this.textBoxPage = this.leftPanel.openTextBoxPage();
        Assert.assertEquals(this.textBoxPage.getPageName(), Item.TEXT_BOX.getName(), "Страница TextBox не загрузилась.");
    }

    @Test
    public void step_02() {
        // Ввод данных в поля на странице TextBox
        this.textBoxPage.setFullName(this.fullName);
        this.textBoxPage.setEmail(this.email);
        this.textBoxPage.setCurrentAddress(this.curAddr);
        this.textBoxPage.setPermanentAddress(this.permAddr);

        // Нажатие на кнопку Submit для отправки формы
        this.textBoxPage.clickSubmit();

        // Проверка, что данные отображаются правильно после отправки формы
        Assert.assertEquals(this.textBoxPage.getOutputName(), "Name:" + this.fullName, "Имя не совпадает.");
        Assert.assertEquals(this.textBoxPage.getOutputEmail(), "Email:" + this.email, "Email не совпадает.");
        Assert.assertEquals(this.textBoxPage.getOutputCurAddr(), "Current Address :" + this.curAddr, "Текущий адрес не совпадает.");
        Assert.assertEquals(this.textBoxPage.getOutputPermAddr(), "Permanent Address :" + this.permAddr, "Постоянный адрес не совпадает.");
    }
}
