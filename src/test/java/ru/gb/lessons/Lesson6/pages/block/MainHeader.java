package ru.gb.lessons.Lesson6.pages.block;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.gb.lessons.Lesson6.pages.BaseView;
import ru.gb.lessons.Lesson6.pages.ProductPage;

public class MainHeader extends BaseView {
    @FindBy(xpath = "//div[@class='header__links']//a[div[text()='Войти']]")
    private WebElement loginButton;

    public MainHeader(WebDriver webDriver) {
        super(webDriver);
    }

    public ProductPage goToProductPage(String tab1, String tab2) {
        new Actions(webDriver)
                .moveToElement(webDriver.findElement(By.xpath("//ul[@data-type='header']//li/a[text()='" + tab1 + "']")))
                .build()
                .perform();

        webDriver.findElement(By.xpath("//ul[@data-type='header']//li/a[text()='" + tab2 + "']")).click();
        return new ProductPage(webDriver);
    }

    public MainHeader checkLoginButtonIsVisible() {
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='header__links']//a[div[text()='Войти']]")));
        return this;
    }

    public LoginPopup clickLoginButton() {
        loginButton.click();
        return new LoginPopup(webDriver);
    }

    public MainHeader logout() {
        webDriver.findElement(By.cssSelector("div.header__user")).click();
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//a[text()='Выйти']"))))
                .click();
        return new MainHeader(webDriver);
    }

}