package widgets;

import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class SelectMenu extends BasePage {
    public SelectMenu(WebDriver driver) {
        super(driver); // Вызов конструктора родительского класса BasePage
    }

    // URL страницы выбора меню
    public static final String URL_SELECT_MENU_PAGE = "https://demoqa.com/select-menu";

    // Метод для открытия страницы выбора меню
    public void openSelectMenuPage() {
        openUrl(URL_SELECT_MENU_PAGE); // Открывает указанный URL
    }
}
