package pages.demoqa.secondPage;

import constant.CategoryCards;
import constant.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.elements.CheckBoxPage;
import pages.elements.TextBoxPage;

import static browser.Config.EXPLICIT_WAIT;

public class LeftPanel extends BasePage {
    // Конструктор класса LeftPanel
    public LeftPanel(WebDriver driver) {
        super(driver); // Вызов конструктора родительского класса BasePage
    }

    // Форматированный локатор для блока панели слева
    public static final String LEFT_PANEL_BLOCK_XPATH = "//div[@class='left-pannel']//div[@class='element-group'][descendant::div[text()='%s']]";
    // Локатор для SVG иконки, открывающей блок
    public static final String OPEN_BLOCK_SVG_XPATH = LEFT_PANEL_BLOCK_XPATH + "/descendant::div[@class='icon']//*[name()='path' and @d='M3 19h18v2H3v-2zM13 5.828V17h-2V5.828L4.929 11.9l-1.414-1.414L12 2l8.485 8.485-1.414 1.414L13 5.83z']";
    // Локатор для списка элементов в блоке
    public static final String LIST_ON_BLOCK_XPATH = LEFT_PANEL_BLOCK_XPATH + "/div[contains(@class,'element-list collapse')]";
    // Форматированный локатор для конкретного элемента в блоке
    public static final String ITEM_XPATH = LEFT_PANEL_BLOCK_XPATH + "//li[span[text()='%s']]";

    // Метод для проверки, отображается ли левая панель
    public boolean isLeftPanelDisplayed() {
        boolean conditions = true; // Флаг для отслеживания условий
        // Проверка отображения всех карточек в левой панели
        for (CategoryCards cards : CategoryCards.values()) {
            if (!isElementDisplay(By.xpath(String.format(LEFT_PANEL_BLOCK_XPATH, cards.getName())))) {
                conditions = false; // Если хотя бы одна карточка не отображается, флаг становится ложным
                break; // Выход из цикла
            }
        }
        return conditions; // Возврат результата проверки
    }

    // Метод для проверки, открыт ли конкретный блок
    public boolean isBlockOpen(CategoryCards blockName) {
        return isElementDisplay(By.xpath(String.format(LIST_ON_BLOCK_XPATH, blockName.getName())));
    }

    // Метод ожидания открытия блока
    public void waitForBlockOpen(CategoryCards blockName) {
        waitElementIsDisplay(By.xpath(String.format(LIST_ON_BLOCK_XPATH, blockName.getName())), EXPLICIT_WAIT);
    }

    // Метод для клика по элементу меню
    public void clickMenuItem(CategoryCards blockName, Item item) {
        // Если блок не открыт, то открываем его
        if (!isBlockOpen(blockName)) {
            click(By.xpath(String.format(LEFT_PANEL_BLOCK_XPATH, blockName.getName())));
            waitForBlockOpen(blockName); // Ожидание открытия блока
        }
        // Клик по элементу в блоке
        click(By.xpath(String.format(ITEM_XPATH, blockName.getName(), item.getName())));
    }

    // Метод для открытия страницы текстового поля
    public TextBoxPage openTextBoxPage() {
        clickMenuItem(CategoryCards.ELEMENTS, Item.TEXT_BOX); // Клик по текстовому полю
        return new TextBoxPage(driver); // Возврат новой страницы текстового поля
    }

    // Метод для открытия страницы чекбокса
    public CheckBoxPage openCheckBoxPage() {
        clickMenuItem(CategoryCards.ELEMENTS, Item.CHECK_BOX); // Клик по чекбоксу
        return new CheckBoxPage(driver); // Возврат новой страницы чекбокса
    }
}
