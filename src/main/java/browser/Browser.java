package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.time.Duration;

import static browser.Config.BROWSER_TYPE;
import static browser.Config.WAIT;

/**
 * Класс Browser предназначен для инициализации WebDriver с учетом выбранного типа браузера.
 * Это упрощает создание и конфигурирование драйвера для тестов.
 */
public class Browser {
    public static WebDriver driver;

    /**
     * Метод для создания экземпляра WebDriver на основе указанного типа браузера.
     * Устанавливаются настройки экрана, стратегия загрузки страницы и неявное ожидание.
     * Переменная BROWSER_TYPE определяет, какой браузер будет использоваться.
     *
     * @return - возвращает и настроенный экземпляр класса WebDriver.
     */
    public static WebDriver createDriver() {

        // Выбор браузера в зависимости от значения BROWSER_TYPE
        switch (BROWSER_TYPE) {
            case "chrome":
                // Настройка для Chrome
                ChromeOptions options = new ChromeOptions();
                options.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
                driver = new ChromeDriver(options);
                break;

            case "firefox":
                // Настройка для Firefox
                FirefoxOptions fOptions = new FirefoxOptions();
                fOptions.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
                driver = new FirefoxDriver(fOptions);
                break;

            default:
                // Обработка ошибки, если указан неверный тип браузера
                System.out.println("Некорректное имя браузера: " + BROWSER_TYPE);
        }

        // Установка размеров окна на максимальные и настройка неявного ожидания
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT));

        return driver;
    }
}
