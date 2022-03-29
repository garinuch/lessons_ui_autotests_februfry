package ru.gb.lessons.Lesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class CartPage extends BasePage {
    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkCartContainsProducts(String... productNames) {
        List<String> actualProductsInCart = webDriver.findElement(By.className("cart-table"))
                .findElements(By.xpath("./div"))
                .stream()
                .map(product -> product.findElement(By.className("cart-table__name")).getText())
                .collect(Collectors.toList());

        assertThat(actualProductsInCart).containsExactlyInAnyOrder(productNames);
    }
}