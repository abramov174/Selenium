package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class TextBoxPage extends BasePage {
    public TextBoxPage(WebDriver driver) {
        super(driver); // Вызов конструктора родительского класса BasePage
    }

    // URL страницы с текстовыми полями
    public static final String URL_TEXT_BOX_PAGE = "https://demoqa.com/text-box";

    // XPath для полей ввода с использованием заполнителя
    public static final String INPUT_XPATH = "//*[@placeholder='%s']";

    // XPath для постоянного адреса и кнопки отправки
    public static final String PERMANENT_ADDRESS = "//textarea[@id='permanentAddress']";
    public static final String SUBMIT = "//button[@id='submit']";

    // XPath для вывода значений
    public static final String OUTPUT_XPATH = "//div[@id='output']//p[@id='%s']";

    // Названия полей для использования в методах
    public static final String FULL_NAME = "Full Name";
    public static final String EMAIL = "name@example.com";
    public static final String CURRENT_ADDRESS = "Current Address";

    // Метод для открытия страницы с текстовыми полями
    public TextBoxPage openTextBoxPage() {
        openUrl(URL_TEXT_BOX_PAGE); // Открывает указанный URL
        return new TextBoxPage(driver); // Возвращает текущий объект страницы
    }

    // Метод для установки полного имени
    public void setFullName(String text) {
        String locator = String.format(INPUT_XPATH, FULL_NAME); // Формирует XPath для полного имени
        sendKeys(By.xpath(locator), text); // Вводит текст в поле
    }

    // Метод для установки адреса электронной почты
    public void setEmail(String email) {
        String locator = String.format(INPUT_XPATH, EMAIL); // Формирует XPath для электронной почты
        sendKeys(By.xpath(locator), email); // Вводит текст в поле
    }

    // Метод для установки текущего адреса
    public void setCurrentAddress(String address) {
        String locator = String.format(INPUT_XPATH, CURRENT_ADDRESS); // Формирует XPath для текущего адреса
        sendKeys(By.xpath(locator), address); // Вводит текст в поле
    }

    // Метод для установки постоянного адреса
    public void setPermanentAddress(String address) {
        sendKeys(By.xpath(PERMANENT_ADDRESS), address); // Вводит текст в поле постоянного адреса
    }

    // Метод для заполнения всех полей и отправки формы
    public void setAllFieldAndSubmit(String fullName, String email, String curAddr, String permAddr) {
        setFullName(fullName); // Заполняет полное имя
        setEmail(email); // Заполняет электронную почту
        setCurrentAddress(curAddr); // Заполняет текущий адрес
        setPermanentAddress(permAddr); // Заполняет постоянный адрес
        clickSubmit(); // Отправляет форму
    }

    // Метод для нажатия на кнопку отправки
    public void clickSubmit() {
        click(By.xpath(SUBMIT)); // Нажимает кнопку отправки
    }

    // Метод для получения значения полного имени из вывода
    public String getOutputName() {
        String locator = String.format(OUTPUT_XPATH, "name"); // Формирует XPath для имени
        return getText(By.xpath(locator)); // Возвращает текст из элемента
    }

    // Метод для получения значения электронной почты из вывода
    public String getOutputEmail() {
        String locator = String.format(OUTPUT_XPATH, "email"); // Формирует XPath для электронной почты
        return getText(By.xpath(locator)); // Возвращает текст из элемента
    }

    // Метод для получения текущего адреса из вывода
    public String getOutputCurAddr() {
        String locator = String.format(OUTPUT_XPATH, "currentAddress"); // Формирует XPath для текущего адреса
        return getText(By.xpath(locator)); // Возвращает текст из элемента
    }

    // Метод для получения постоянного адреса из вывода
    public String getOutputPermAddr() {
        String locator = String.format(OUTPUT_XPATH, "permanentAddress"); // Формирует XPath для постоянного адреса
        return getText(By.xpath(locator)); // Возвращает текст из элемента
    }
}
