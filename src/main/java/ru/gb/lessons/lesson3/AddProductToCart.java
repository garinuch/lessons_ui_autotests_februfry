package ru.gb.lessons.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class AddProductToCart {

    public static void main(String[] args) {
        String productName = "Электроакустический бас BATON ROUGE X11S/BSCE";
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();

        webDriver.get("https://pop-music.ru/");
        webDriver.manage().window().setSize(new Dimension(1500, 1100));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

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

        System.out.print("Actual products: ");
        webDriver.findElement(By.className("cart-table"))
                .findElements(By.xpath("./div"))
                .forEach(product -> System.out.print(product.findElement(By.className("cart-table__name")).getText() + " "));
        System.out.println();
        System.out.println("Expected products: " + productName);

        webDriver.quit();
    }
}
