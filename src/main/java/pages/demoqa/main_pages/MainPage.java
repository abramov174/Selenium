package pages.demoqa.main_pages;

import constant.CategoryCards;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.demoqa.secondPage.SecondPage;

public class MainPage extends BasePage {
    // Конструктор класса MainPage
    public MainPage(WebDriver driver) {
        super(driver); // Вызов конструктора родительского класса BasePage
    }

    // URL главной страницы
    public static final String MAIN_PAGE = "https://demoqa.com/";
    // Локатор для баннера на главной странице
    public static final By HOME_BANNER = By.xpath("//div[@class='home-banner'][a[@href='https://www.toolsqa.com/selenium-training/'][img[contains(@src,'WB.svg')]]]");

    // Локатор для карточек категорий
    public static final By CATEGORY_CARDS_XPATH = By.xpath("//h5[contains(text(),'')]");
    // Форматированный локатор для конкретной карточки категории по ее имени
    public static final String CATEGORY_CARD_XPATH = "//h5[text()='%s']";

    // Метод для открытия главной страницы
    public void openMainPage() {
        openUrl(MAIN_PAGE); // Вызов метода открытия URL
    }

    // Метод для открытия карточки категории и возврата новой страницы
    public SecondPage openCategoryCards(CategoryCards nameCards) {
        // Формирование локатора для карточки категории
        By locator = By.xpath(String.format(CATEGORY_CARD_XPATH, nameCards.getName()));
        click(locator); // Клик по карточке категории
        return new SecondPage(driver); // Возврат новой страницы
    }

    // Метод для получения количества карточек категорий
    public int getCategoryCount() {
        return getElementsCount(CATEGORY_CARDS_XPATH); // Возврат количества найденных карточек
    }
}
