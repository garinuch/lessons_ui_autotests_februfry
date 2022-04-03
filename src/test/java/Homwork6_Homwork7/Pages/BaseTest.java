package Homwork6_Homwork7.Pages;

import Homwork6_Homwork7.listener2.AllureListener2;
import Homwork6_Homwork7.pojo2.User2;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

import static io.qameta.allure.Allure.addAttachment;
import static io.qameta.allure.Allure.step;

public class BaseTest {
    protected EventFiringWebDriver webDriver;
    public final String email = "garinuch@gmail.com";
    public final String password = "4321";
    public final User2 user = new User2(email, password);

    @BeforeEach
    void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");
        webDriver = new EventFiringWebDriver(WebDriverManager.chromedriver().capabilities(chromeOptions).create());
        webDriver.register(new AllureListener2());
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get("https://lovisnami.ru/");
        webDriver.manage().window().setSize(new Dimension(2000, 1500));
    }

    @AfterEach
    void tearDown() {
        step("Логи браузера", () -> {
            webDriver.manage().logs().get(LogType.BROWSER)
                    .forEach(log -> addAttachment("logs", log.getMessage()));
        });
        webDriver.quit();
    }
}
