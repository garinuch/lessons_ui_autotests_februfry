package Homwork6_Homwork7.Pages.block;

import Homwork6_Homwork7.Pages.BaseView;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainHeader extends BaseView {
    @FindBy(xpath = "//*[contains(text(),'Вход')]")
    private WebElement loginButton;

    public MainHeader(WebDriver webDriver) {
        super(webDriver);
    }
    /*
        public ProductPage goToProductPage(String tab1, String tab2) {
            new Actions(webDriver)
                    .moveToElement(webDriver.findElement(By.xpath("//ul[@data-type='header']//li/a[text()='" + tab1 + "']")))
                    .build()
                    .perform();
            webDriver.findElement(By.xpath("//ul[@data-type='header']//li/a[text()='" + tab2 + "']")).click();
            return new ProductPage(webDriver);
        }
    */
    public void checkLoginButtonIsVisible() {
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='button big blue']")));
    }

    public LoginContent clickLoginButton() {
        loginButton.click();
        return new LoginContent(webDriver);
    }

    public MainHeader logout() {
        //webDriver.findElement(By.xpath("//a[text()='Выход']")).click();
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.visibilityOf(By.xpath("//a[text()='Выход']").findElement(webDriver)))
                .click();
        return new MainHeader(webDriver);
    }

}