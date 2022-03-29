package ru.gb.lessons.Lesson6.pages.block;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPopup implements WrapsElement {
    private WebElement self;
    private WebDriver webDriver;

    public LoginPopup(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.self = webDriver.findElement(By.xpath("//div[@class='popup-login__tab is-active']"));
    }

    @Override
    public WebElement getWrappedElement() {
        return self;
    }

    public MainHeader login(String login, String password) {
        getWrappedElement().findElement(By.name("USER_LOGIN")).sendKeys(login);
        getWrappedElement().findElement(By.name("USER_PASSWORD")).sendKeys(password);
        getWrappedElement().findElement(By.xpath(".//button[span[text()='Войти']]")).click();
        return new MainHeader(webDriver);
    }

    public void checkErrorIsVisible(String errorText) {
        assertThat(new WebDriverWait(webDriver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='errortext']")))
                .getText()).as("Был указан некорректный пароль").isEqualTo(errorText);
    }
}