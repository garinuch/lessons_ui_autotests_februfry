package Homwork_6.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.gb.lessons.Lesson6.pages.BasePage;
import ru.gb.lessons.Lesson6.pages.CartPage;

import java.util.List;
import java.util.NoSuchElementException;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//*[contains(text(),'Перейти в корзину')]")
    private WebElement goToCartButton;

    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ProductPage selectProduct(String productName) {
        List<WebElement> products = webDriver.findElements(By.xpath("//div[@class='product-card ']"));
        WebElement selectedProduct = products.stream()
                .filter(product -> product.findElement(By.xpath(".//a[@class='product-card__name']"))
                        .getText().equals(productName))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("productName"));
        selectedProduct.findElement(By.className("product-card__btn")).click();
        return this;
    }

    public CartPage goToCart() {
        goToCartButton.click();
        return new CartPage(webDriver);
    }
}