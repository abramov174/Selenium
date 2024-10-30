package Exams.Z2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Z2 {
    private static JavascriptExecutor js;

    public static void main(String[] args) {
        // Настройка опций Chrome
        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");

        // Инициализация драйвера
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        // Переход на сайт
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        // Ввод текстовых данных
        WebElement inputText = driver.findElement(By.id("my-text-id"));
        inputText.sendKeys("Abramov Artem Andreevich");
        Assert.assertEquals(inputText.getAttribute("value"), "Abramov Artem Andreevich", "Text input is incorrect");

        WebElement inputPassword = driver.findElement(By.xpath("/html/body/main/div/form/div/div[1]/label[2]/input"));
        inputPassword.sendKeys("HelloHello4Hello67Hello");
        Assert.assertEquals(inputPassword.getAttribute("value"), "HelloHello4Hello67Hello", "Password input is incorrect");

        WebElement textArea = driver.findElement(By.xpath("/html/body/main/div/form/div/div[1]/label[3]/textarea"));
        textArea.sendKeys("AbramovAA");
        Assert.assertEquals(textArea.getAttribute("value"), "AbramovAA", "Text Area is incorrect");


        // Выбираем элемент Two
        WebElement Select = driver.findElement(By.xpath("/html/body/main/div/form/div/div[2]/label[1]/select"));
        Select.click();
        WebElement Two = driver.findElement(By.xpath("/html/body/main/div/form/div/div[2]/label[1]/select/option[3]"));
        Two.click();

        // Выбираем detalist
        WebElement detalist = driver.findElement(By.xpath("/html/body/main/div/form/div/div[2]/label[2]/input"));
        detalist.sendKeys("Seattle");

        //Выбираем DefaultCheckbox
        WebElement DefaultCheckbox = driver.findElement(By.xpath("//*[@id=\"my-check-2\"]"));
        DefaultCheckbox.click();

        // Выбираем Default Radio
        WebElement DefaultRadio = driver.findElement(By.xpath("//*[@id=\"my-radio-2\"]"));
        DefaultRadio.click();


        // Нажимаем на кнопку Submit
        WebElement submit = driver.findElement(By.xpath(" /html/body/main/div/form/div/div[2]/button"));
        submit.click();

        //Вывод сообщения Form submitted Received!
        try {
            WebElement PrintSubmit = driver.findElement(By.xpath("/html/body/main"));
            String finPrintSubmit = PrintSubmit.getText();

            System.out.println("Message submit: " + finPrintSubmit);
        } catch (Exception e) {
            System.out.println("Ошибка при получении данных: " + e.getMessage());
        }

        // Закрытие браузера (если нужно)
        driver.quit();
    }
}