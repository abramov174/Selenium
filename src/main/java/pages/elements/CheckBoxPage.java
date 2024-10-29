package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class CheckBoxPage extends BasePage {
    public CheckBoxPage(WebDriver driver) {
        super(driver); // Вызов конструктора родительского класса BasePage
    }

    // URL страницы с чек-боксами
    public static final String URL_TEXT_BOX_PAGE = "https://demoqa.com/checkbox";

    // XPath для кнопки toggle рядом с чек-боксом
    public static final String BUTTON_TOGGLE = CHECK_BOX_INPUT_XPATH + "/../preceding-sibling::button[@title='Toggle']";

    // XPath для списка чек-боксов
    public static final String LIST_CHECKBOX_XPATH = CHECK_BOX_INPUT_XPATH + "/ancestor::li[contains(@class,'%s')]";

    // Состояния списка чек-боксов
    public static final String LIST_CHECKBOX_OPEN = "expanded"; // Открытый список чек-боксов
    public static final String LIST_CHECKBOX_CLOSED = "collapsed"; // Закрытый список чек-боксов

    // Метод для открытия страницы с чек-боксами
    public void openCheckBoxPage() {
        openUrl(URL_TEXT_BOX_PAGE); // Открывает указанный URL
    }

    /**
     * Метод для открытия списка чек-боксов нажатием на toggle рядом с чек-боксом
     * @param checkBoxName - название чек-бокса
     */
    public void openListCheckBox(String checkBoxName) {
        if (!isCheckBoxDisplay(checkBoxName)) { // Проверка, отображается ли чек-бокс
            failure(); // Если не отображается, вызываем метод failure
        }
        // Если список чек-боксов закрыт, открываем его
        if (isListCheckBoxClosed(checkBoxName)) {
            click(By.xpath(String.format(BUTTON_TOGGLE, checkBoxName))); // Нажимаем на toggle
        }
    }

    /**
     * Метод для закрытия списка чек-боксов нажатием на toggle рядом с чек-боксом
     * @param checkBoxName - название чек-бокса
     */
    public void closeListCheckBox(String checkBoxName) {
        if (!isCheckBoxDisplay(checkBoxName)) { // Проверка, отображается ли чек-бокс
            failure(); // Если не отображается, вызываем метод failure
        }
        // Если список чек-боксов открыт, закрываем его
        if (isListCheckBoxOpen(checkBoxName)) {
            click(By.xpath(String.format(BUTTON_TOGGLE, checkBoxName))); // Нажимаем на toggle
        }
    }

    /**
     * Проверка отображения чек-бокса на форме
     * @param checkBoxName название чек-бокса
     * @return true, если чек-бокс отображается, иначе false
     */
    public boolean isCheckBoxDisplay(String checkBoxName) {
        return isElementDisplay(By.xpath(String.format(CHECK_BOX_XPATH, checkBoxName))); // Проверяем отображение чек-бокса
    }

    /**
     * Проверка отображения списка чек-боксов под конкретным чек-боксом
     * @param checkBoxName название чек-бокса
     * @return true, если список открыт, иначе false
     */
    public boolean isListCheckBoxOpen(String checkBoxName) {
        return isElementDisplay(By.xpath(String.format(LIST_CHECKBOX_XPATH, checkBoxName, LIST_CHECKBOX_OPEN))); // Проверяем, открыт ли список чек-боксов
    }

    // Проверка, закрыт ли список чек-боксов
    public boolean isListCheckBoxClosed(String checkBoxName) {
        return isElementDisplay(By.xpath(String.format(LIST_CHECKBOX_XPATH, checkBoxName, LIST_CHECKBOX_CLOSED))); // Проверяем, закрыт ли список чек-боксов
    }
}
