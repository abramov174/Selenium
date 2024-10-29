package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class Main {
    public static void main(String[] args) {
        // Настройка опций Chrome
        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");

        // Инициализация драйвера
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        // Переход на сайт
        driver.get("https://demoqa.com/");

        // Поиск элемента по XPath и прокрутка к нему
        WebElement card = driver.findElement(By.xpath("//h5[text()='Elements']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", card);
        card.click();

        // Переход на элемент "Text Box" и клик по нему
        WebElement textBoxItem = driver.findElement(By.xpath("//span[text()='Text Box']"));
        textBoxItem.click();

        // Ввод данных в форму
        WebElement inputFullName = driver.findElement(By.id("userName"));
        inputFullName.sendKeys("User1");

        WebElement inputEmail = driver.findElement(By.id("userEmail"));
        inputEmail.sendKeys("user1@1.com");

        WebElement curAddress = driver.findElement(By.id("currentAddress"));
        curAddress.sendKeys("Moscow");

        WebElement permAddress = driver.findElement(By.id("permanentAddress"));
        js.executeScript("arguments[0].scrollIntoView();", permAddress);
        permAddress.sendKeys("Kursk");

        // Поиск кнопки "Submit" и отправка формы
        WebElement button = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].scrollIntoView();", button); // Прокрутка к кнопке
        button.click(); // Отправка формы

        // Получение данных после отправки формы
        try {
            WebElement user = driver.findElement(By.id("name")); // Проверь, что ID "name" существует
            String userName = user.getText();
            System.out.println("User name: " + userName);

            WebElement email = driver.findElement(By.id("email"));
            String userEmail = email.getText();
            System.out.println("Email: " + userEmail);

            WebElement currentAddress = driver.findElement(By.id("currentAddress"));
            String userCurrentAddress = currentAddress.getText();
            System.out.println("Current Address: " + userCurrentAddress);

            WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
            String userPermanentAddress = permanentAddress.getText();
            System.out.println("Permanent Address: " + userPermanentAddress);
        } catch (Exception e) {
            System.out.println("Ошибка при получении данных: " + e.getMessage());
        }

        // Закрытие браузера (если нужно)
        driver.quit();
    }
}