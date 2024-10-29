package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class RadioButtonPage extends BasePage {
    public RadioButtonPage(WebDriver driver) {
        super(driver); // Вызов конструктора родительского класса BasePage
    }

    // URL страницы с радиокнопками
    public static final String URL_TEXT_BOX_PAGE = "https://demoqa.com/radio-button";

    // XPath для выбора радиокнопки по имени
    public static final String RADIO_BUTTON_XPATH = "//input[@type='radio'][following-sibling::label[contains(., '%s')]]";

    // XPath для нажатия на радиокнопку по имени
    public static final String RADIO_BUTTON_CLICK_XPATH = "//input[@type='radio']/following-sibling::label[contains(., '%s')]";

    // Метод для открытия страницы с радиокнопками
    public void openRadioButtonPage() {
        openUrl(URL_TEXT_BOX_PAGE); // Открывает указанный URL
    }

    // Метод для получения состояния радиокнопки (выбрана/не выбрана)
    public boolean getStateRadioButton(String radioButtonName) {
        return getRadioButtonState(By.xpath(String.format(RADIO_BUTTON_XPATH, radioButtonName))); // Возвращает состояние радиокнопки
    }

    // Метод для нажатия на радиокнопку по имени
    public void clickRadioButton(String radioButtonName) {
        setRadioButton(By.xpath(String.format(RADIO_BUTTON_CLICK_XPATH, radioButtonName))); // Устанавливает выбранное состояние радиокнопки
    }

    // Метод для проверки, включена ли радиокнопка
    public boolean radioButtonIsEnabled(String radioButtonName) {
        return isElementEnabled(By.xpath(String.format(RADIO_BUTTON_XPATH, radioButtonName))); // Проверяет, доступна ли радиокнопка для нажатия
    }
}
