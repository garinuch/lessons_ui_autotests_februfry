package ru.gb.lessons.Lesson5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class AddProductTest extends BaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"Электроакустический бас BATON ROUGE X11S/BSCE", "Бас-гитара CORT AB850F BK W_BAG"})
    void addProductTest(String productName) {

        webDriver.get("https://pop-music.ru/");
        webDriver.manage().window().setSize(new Dimension(2000, 1500));
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        new Actions(webDriver)
                .moveToElement(webDriver.findElement(By.xpath("//ul[@data-type='header']//li/a[text()='Гитары']")))
                .build()
                .perform();

        webDriver.findElement(By.xpath("//ul[@data-type='header']//li/a[text()='Акустические бас-гитары']")).click();

        List<WebElement> products = webDriver.findElements(By.xpath("//div[@class='product-card ']"));
        WebElement selectedProduct = products.stream()
                .filter(product -> product.findElement(By.xpath(".//a[@class='product-card__name']"))
                        .getText().equals("Электроакустический бас BATON ROUGE X11S/BSCE"))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("productName"));
        selectedProduct.findElement(By.className("product-card__btn")).click();

        webDriver.findElement(By.xpath("//*[contains(text(),'Перейти в корзину')]")).click();

        List<String> actualProductsInCart = webDriver.findElement(By.className("cart-table"))
                .findElements(By.xpath("./div"))
                .stream()
                .map(product -> product.findElement(By.className("cart-table__name")).getText())
                .collect(Collectors.toList());

        assertThat(actualProductsInCart).containsExactlyInAnyOrder(productName);
    }
}