package pages.base;

import constant.LocatorsType;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static browser.Config.EXPLICIT_WAIT;

public class BasePage {
    protected WebDriver driver; // Экземпляр WebDriver для взаимодействия с браузером
    private WebElement pageElement; // Элемент страницы (если требуется)

    public BasePage(WebDriver driver) {
        this.driver = driver; // Конструктор принимает WebDriver
    }

    // Локаторы для различных элементов на странице
    public static final By HEADER_XPATH = By.xpath("//header/a[@href='https://demoqa.com'][img[@src='/images/Toolsqa.jpg']]");
    public static final String CHECK_BOX_INPUT_XPATH = "//input[@type='checkbox'][following-sibling::span[text()='%s']]";
    public static final String CHECK_BOX_XPATH = CHECK_BOX_INPUT_XPATH + "/following-sibling::span[@class='rct-checkbox']";
    public static final By NAME_PAGE = By.xpath("//h1[@class='text-center']");
    public static final String BUTTON_XPATH = "//*[@type='button' and text()='%s']";

    // Метод для открытия указанного URL
    public void openUrl(String url) {
        driver.get(url);
    }

    // Метод для поиска элемента с прокруткой к нему
    public WebElement findElement(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element); // Прокрутка к элементу
        return element; // Возврат найденного элемента
    }

    // Метод для поиска нескольких элементов
    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator); // Возврат списка найденных элементов
    }

    // Метод ожидания видимости элемента
    public void waitElementIsVisible(By locator, int second) {
        new WebDriverWait(driver, Duration.ofSeconds(second)).until(ExpectedConditions.visibilityOf(findElement(locator)));
    }

    // Метод ожидания, пока элемент станет видимым (по умолчанию с использованием EXPLICIT_WAIT)
    public void waitElementIsVisible(By locator) {
        waitElementIsVisible(locator, EXPLICIT_WAIT);
    }

    // Метод для ожидания отображения элемента
    public void waitElementIsDisplay(By locator, int second) {
        new WebDriverWait(driver, Duration.ofSeconds(second)).until(d -> isElementDisplay(locator));
    }

    // Метод для ожидания, пока элемент станет доступным для взаимодействия
    public void waitForElementsEnabled(By locator, int second) {
        new WebDriverWait(driver, Duration.ofSeconds(second)).until(d -> isElementEnabled(locator));
    }

    // Метод для клика по элементу
    public void click(By locator) {
        findElement(locator).click(); // Клик по найденному элементу
    }

    // Метод для двойного клика по элементу
    public void doubleClick(By locator) {
        Actions actions = new Actions(driver);
        actions.doubleClick(findElement(locator)).perform(); // Двойной клик
    }

    // Метод для контекстного клика (правый клик)
    public void contextClick(By locator) {
        Actions actions = new Actions(driver);
        actions.contextClick(findElement(locator)).perform(); // Контекстное меню
    }

    // Метод для очистки текстового поля
    public void clear(By locator) {
        findElement(locator).clear(); // Очистка содержимого поля
    }

    // Метод для ввода текста в текстовое поле
    public void sendKeys(By locator, String text) {
        findElement(locator).sendKeys(text); // Ввод текста
    }

    // Метод для очистки поля и ввода текста
    public void sendKeysWithClear(By locator, String text) {
        clear(locator); // Очистка поля
        sendKeys(locator, text); // Ввод текста
    }

    // Метод для получения текста элемента
    public String getText(By locator) {
        return findElement(locator).getText(); // Возврат текста элемента
    }

    // Метод для проверки, отображается ли элемент
    public boolean isElementDisplay(By locator) {
        try {
            return findElement(locator).isDisplayed(); // Возврат true, если элемент видим
        } catch (Exception ex) {
            return false; // Возврат false, если элемент не найден
        }
    }

    // Метод для проверки, доступен ли элемент для взаимодействия
    public boolean isElementEnabled(By locator) {
        return findElement(locator).isEnabled(); // Возврат true, если элемент активен
    }

    // Метод для проверки, отображается ли заголовок страницы
    public boolean isHeaderDisplayed() {
        return isElementDisplay(HEADER_XPATH); // Проверка отображения заголовка
    }

    // Метод для получения количества элементов по локатору
    public int getElementsCount(By locator) {
        return findElements(locator).size(); // Возврат количества найденных элементов
    }

    // Метод для получения состояния чек-бокса по его имени
    public boolean getCheckBoxState(String checkBoxName) {
        return findElement(By.xpath(String.format(CHECK_BOX_INPUT_XPATH, checkBoxName))).isSelected(); // Проверка состояния чек-бокса
    }

    // Метод для установки состояния чек-бокса
    public void setCheckBox(String checkBoxName, boolean state) {
        // Переключение состояния чек-бокса, если текущее состояние не совпадает с требуемым
        if (getCheckBoxState(checkBoxName) != state) {
            click(By.xpath(String.format(CHECK_BOX_XPATH, checkBoxName))); // Клик для переключения состояния
        }
    }

    // Метод для проверки состояния радио-кнопки
    public boolean getRadioButtonState(By locator) {
        return findElement(locator).isSelected(); // Возврат true, если радио-кнопка выбрана
    }

    // Метод для установки состояния радио-кнопки
    public void setRadioButton(By locator) {
        click(locator); // Клик по радио-кнопке
    }

    // Метод для создания локатора на основе типа локатора
    public By locatorBuild(String textLocator, LocatorsType locatorsType) {
        By locator = null; // Инициализация локатора
        switch (locatorsType) {
            case ID:
                locator = By.id(textLocator); // Создание локатора по ID
                break;
            case XPATH:
                locator = By.xpath(textLocator); // Создание локатора по XPATH
                break;
            case CSS:
                locator = By.cssSelector(textLocator); // Создание локатора по CSS
                break;
            case NAME:
                locator = By.name(textLocator); // Создание локатора по имени
                break;
            case TAG_NAME:
                locator = By.tagName(textLocator); // Создание локатора по тегу
                break;
            case CLASS_NAME:
                locator = By.className(textLocator); // Создание локатора по имени класса
                break;
            default:
                System.out.println("Некорректный вид селектора: " + locatorsType); // Обработка некорректного типа локатора
        }
        return locator; // Возврат созданного локатора
    }

    // Метод для выброса ошибки в случае неудачи
    public void failure() {
        throw new AssertionError(); // Выбрасывание ошибки
    }

    // Метод для получения имени страницы
    public String getPageName() {
        return getText(NAME_PAGE); // Возврат текста заголовка страницы
    }

    // Метод для клика по кнопке по имени
    public void buttonClick(String buttonName) {
        click(By.xpath(String.format(BUTTON_XPATH, buttonName))); // Клик по кнопке
    }

    // Метод для получения значения атрибута элемента
    public String getAttributeValue(By locator, String attribute) {
        return findElement(locator).getAttribute(attribute); // Возврат значения атрибута
    }

    // Метод для получения элемента страницы (если требуется)
    public WebElement getPageElement() {
        return pageElement; // Возврат элемента страницы
    }
}
