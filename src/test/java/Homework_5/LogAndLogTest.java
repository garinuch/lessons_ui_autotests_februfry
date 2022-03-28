package Homework_5;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.gb.lessons.Lesson5.BaseTest;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LogAndLogTest extends BaseTest {

    @Test
    void loginAndLogout() {
        webDriver.get("https://lovisnami.ru/");
        webDriver.manage().window().setSize(new Dimension(1500, 1100));
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.findElement(By.xpath("//*[contains(text(),'Вход')]")).click();

        WebElement authForm = webDriver.findElement(By.xpath("//div[4]/form"));
        authForm.findElement(By.name("email")).sendKeys("garinuch@gmail.com");
        authForm.findElement(By.name("password")).sendKeys("4321");
        authForm.findElement(By.xpath("//*[@class='button big blue']")).click();

        new WebDriverWait(webDriver, 5).until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//a[text()='Выход']"))))
                .click();
        //Thread.sleep(7_000);
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='auth']/a[text()='Вход']")));
        webDriver.quit();
    }

    @Test
    void incorrectPasswordTest() throws InterruptedException {
        webDriver.get("https://lovisnami.ru/");
        webDriver.manage().window().setSize(new Dimension(1500, 1100));
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.findElement(By.xpath("//*[contains(text(),'Вход')]")).click();

        WebElement authForm = webDriver.findElement(By.xpath("//div[4]/form"));
        authForm.findElement(By.name("email")).sendKeys("garinuch@gmail.com");
        authForm.findElement(By.name("password")).sendKeys("1234");
        authForm.findElement(By.xpath("//*[@class='button big blue']")).click();

        assertThat(new WebDriverWait(webDriver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='error']")))
                .getText()).isEqualTo("Логин или пароль указан не верно");

        Thread.sleep(7_000);
    }
}