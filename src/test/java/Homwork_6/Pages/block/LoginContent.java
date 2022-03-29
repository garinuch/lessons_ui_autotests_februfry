package Homwork_6.Pages.block;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginContent implements WrapsElement {
    private WebElement self;
    private WebDriver webDriver;

    public LoginContent(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.self = webDriver.findElement(By.xpath("//div[@class='content center']"));
    }

    @Override
    public WebElement getWrappedElement() {
        return self;
    }

    public MainHeader login(String email, String password) {
        getWrappedElement().findElement(By.name("email")).sendKeys(email);
        getWrappedElement().findElement(By.name("password")).sendKeys(password);
        getWrappedElement().findElement(By.xpath("//*[@class='button big blue']")).click();
        return new MainHeader(webDriver);
    }

    public void checkErrorIsVisible(String errorText) {
        assertThat(new WebDriverWait(webDriver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='error']")))
                .getText()).as("Логин или пароль указан не верно").isEqualTo(errorText);
    }
}
