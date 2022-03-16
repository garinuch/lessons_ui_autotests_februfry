package Homework_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import static java.time.Duration.ofSeconds;

public class AddProductToCart {

    public static void main(String[] args) throws InterruptedException {
        //String productName = "Катушка Daiwa 18 Ninja LT1000";
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();

        webDriver.get("https://lovisnami.ru/");
        webDriver.manage().window().setSize(new Dimension(1500, 1100));
        webDriver.manage().timeouts().implicitlyWait(ofSeconds(10));

        WebElement mayBeCity = webDriver.findElement(By.className("bt_box"));
        mayBeCity.findElement(By.xpath(".//input[1]")).click();

        webDriver.findElement(By.xpath("//a[text()=\"Приманки\"]")).click();
        webDriver.findElement(By.xpath(".//a[@href='/blesny-kuusamo-finlyandiya.html']")).click();

        webDriver.findElement(By.xpath("//div[@class='var_name']")).click();
        webDriver.findElement(By.xpath(".//input[@value=\"11\"]")).click();
        webDriver.findElement(By.xpath(".//input[@class='button']")).click();
 // TODO  Не доделка.

/*
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
*/
        Thread.sleep(7_000);
        webDriver.quit();
    }
}
