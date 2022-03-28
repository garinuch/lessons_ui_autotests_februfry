package ru.gb.lessons.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class LoginAndLogout {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();

        webDriver.get("https://pop-music.ru/");
        webDriver.manage().window().setSize(new Dimension(1500, 1100));
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.findElement(By.xpath("//div[@class='header__links']//a[div[text()='Войти']]")).click();

        webDriver.get("https://pop-music.ru/");
        webDriver.manage().window().setSize(new Dimension(1500, 1100));
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.findElement(By.xpath("//div[@class='header__links']//a[div[text()='Войти']]")).click();

        WebElement authPopup = webDriver.findElement(By.xpath("//div[@class='popup-login__tab is-active']"));
        authPopup.findElement(By.name("USER_LOGIN")).sendKeys("garinuch@gmail.com");
        authPopup.findElement(By.name("USER_PASSWORD")).sendKeys("gari6619");
        authPopup.findElement(By.xpath(".//button[span[text()='Войти']]")).click();
        webDriver.findElement(By.cssSelector("div.header__user")).click();

        new WebDriverWait(webDriver, 5).until(ExpectedConditions.visibilityOf(webDriver.
                        findElement(By.xpath("//a[text()='Выйти']")))).click();

        new WebDriverWait(webDriver, 5).until(ExpectedConditions.
                presenceOfElementLocated(By.xpath("//div[@class='header__links']//a[div[text()='Войти']]")));
        webDriver.quit();
    }
}

