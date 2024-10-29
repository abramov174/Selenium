package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;

import java.time.Duration;

public class DynamicPropertiesPage extends BasePage {
    public DynamicPropertiesPage(WebDriver driver) {
        super(driver); // Вызов конструктора родительского класса BasePage
    }

    // URL страницы с динамическими свойствами
    public static final String URL_DYNAMIC_PAGE = "https://demoqa.com/dynamic-properties";

    // Элементы на странице
    public static final By BTN_ENABLE_AFTER = By.id("enableAfter"); // Кнопка, которая становится активной через некоторое время
    public static final By BTN_COLOR_CHANGE = By.id("colorChange"); // Кнопка, меняющая цвет
    public static final By BTN_VISIBLE_AFTER = By.id("visibleAfter"); // Кнопка, которая становится видимой через некоторое время

    // Метод для открытия страницы с динамическими свойствами
    public void openDynamicPage() {
        openUrl(URL_DYNAMIC_PAGE); // Открывает указанный URL
    }

    // Метод для нажатия на кнопку, которая активируется через некоторое время
    public void clickBtnEnableAfter() {
        waitForElementsEnabled(BTN_ENABLE_AFTER, 6); // Ожидаем, пока кнопка не станет активной
        click(BTN_ENABLE_AFTER); // Нажимаем на кнопку
    }

    // Метод для нажатия на кнопку, которая становится видимой через некоторое время
    public void clickBtnVisibleAfter() {
        waitElementIsVisible(BTN_VISIBLE_AFTER, 6); // Ожидаем, пока кнопка не станет видимой
        click(BTN_VISIBLE_AFTER); // Нажимаем на кнопку
    }

    // Метод для ожидания изменения цвета кнопки
    public void waitForColorChange() {
        new WebDriverWait(driver, Duration.ofSeconds(6)).until(d -> isColorChange(BTN_COLOR_CHANGE, "rgba(220, 53, 69, 1)")); // Ждем, пока цвет не изменится
    }

    // Метод для получения цвета кнопки
    public String getColorBtn(By xpathBtn) {
        return getAttributeValue(xpathBtn, "color"); // Возвращает значение атрибута "color"
    }

    // Метод для проверки, изменился ли цвет кнопки
    public boolean isColorChange(By xpathBtn, String color) {
        return getColorBtn(xpathBtn).equals(color); // Сравнивает текущий цвет с ожидаемым
    }
}
