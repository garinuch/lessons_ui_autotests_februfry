package Homework_5;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.gb.lessons.Lesson5.BaseTest;

public class FishingAuthTest extends BaseTest {

    @Test
    void authWithUiTest() {
        webDriver.get("https://lovisnami.ru/user_login.php");
        webDriver.findElement(By.name("email")).sendKeys("garinuch@gmail.com");
        webDriver.findElement(By.name("password")).sendKeys("3321");
        webDriver.findElement(By.xpath("//*[@class='button big blue']")).click();
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Мои заказы')]")));
    }

    @Test
    void authWithCookieTest() throws InterruptedException {
        webDriver.get("https://lovisnami.ru/user_login.php");
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Авторизация')]")));
        webDriver.manage().addCookie(new Cookie("tmr_lvid", "7707c0d7f2e12e15ebe8b0dc12a06519"));
        webDriver.get("https://lovisnami.ru/user_orders.php");
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Мои заказы')]")));

    }
}
