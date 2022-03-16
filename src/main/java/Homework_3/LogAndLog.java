package Homework_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LogAndLog {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();

        webDriver.get("https://lovisnami.ru/");
        webDriver.manage().window().setSize(new Dimension(1500, 1100));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        webDriver.findElement(By.xpath("//*[contains(text(),'Вход')]")).click();

        WebElement authForm = webDriver.findElement(By.xpath("//div[4]/form"));
        authForm.findElement(By.name("email")).sendKeys("garinuch@gmail.com");
        authForm.findElement(By.name("password")).sendKeys("4321");
        authForm.findElement(By.xpath("//*[@class='button big blue']")).click();

        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//a[text()='Выход']"))))
                .click();
        Thread.sleep(5_000);
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='auth']/a[text()='Вход']")));
        webDriver.quit();
    }
}