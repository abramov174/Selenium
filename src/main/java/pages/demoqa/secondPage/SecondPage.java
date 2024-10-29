package pages.demoqa.secondPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class SecondPage extends BasePage {
    // Конструктор класса SecondPage
    public SecondPage(WebDriver driver) {
        super(driver); // Вызов конструктора родительского класса BasePage
    }

    // Локатор для изображения нулевого шага
    public static final By ZERO_STEP_PICTURE = By.xpath("//a/img[@src='/images/zero-step.jpeg']");
    // Локатор для текста, указывающего на необходимость выбора элемента
    public static final By PLEASE_SELECT_AN_ITEM = By.xpath("//div[text()='Please select an item from left to start practice.']");

    // Метод для проверки, отображается ли изображение нулевого шага
    public boolean zeroStepPictureIsDisplayed() {
        return isElementDisplay(ZERO_STEP_PICTURE); // Возвращает результат проверки отображения изображения
    }

    // Метод для проверки, отображается ли текст с просьбой выбрать элемент
    public boolean pleaseSelectAnItemXpathIsDisplayed() {
        return isElementDisplay(PLEASE_SELECT_AN_ITEM); // Возвращает результат проверки отображения текста
    }

    // Метод для проверки, открыта ли страница
    public boolean isPageOpen() {
        // Проверяем, отображаются ли оба элемента
        if (zeroStepPictureIsDisplayed() && pleaseSelectAnItemXpathIsDisplayed()) {
            return true; // Если оба элемента отображаются, страница открыта
        }
        return false; // Если хотя бы один элемент не отображается, страница не открыта
    }
}
