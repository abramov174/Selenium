package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class ButtonsPage extends BasePage {
    // URL страницы с кнопками
    public static final String URL_TEXT_BOX_PAGE = "https://demoqa.com/buttons";

    // Локаторы для кнопок
    public static final By DOUBLE_CLICK_BTN = By.id("doubleClickBtn"); // Локатор для кнопки двойного клика
    public static final By RIGHT_CLICK_BTN = By.id("rightClickBtn"); // Локатор для кнопки правого клика

    // Сообщения, которые отображаются после кликов
    public static final String MESSAGE_DOUBLE_CLICK = "You have done a double click"; // Сообщение после двойного клика
    public static final String MESSAGE_RIGHT_CLICK = "You have done a right click"; // Сообщение после правого клика
    public static final String MESSAGE_CLICK = "You have done a dynamic click"; // Сообщение после обычного клика

    // Конструктор класса ButtonsPage
    public ButtonsPage(WebDriver driver) {
        super(driver); // Вызов конструктора родительского класса BasePage
    }

    // Метод для открытия страницы с кнопками
    public void openButtonsPage() {
        openUrl(URL_TEXT_BOX_PAGE); // Открывает указанный URL
    }

    // Метод для проверки, отображается ли сообщение
    public boolean isMessageDisplay(String message) {
        String xpath = "//*[text()='" + message + "']"; // Создание XPath для поиска сообщения
        return isElementDisplay(By.xpath(xpath)); // Возвращает результат проверки отображения сообщения
    }
}
