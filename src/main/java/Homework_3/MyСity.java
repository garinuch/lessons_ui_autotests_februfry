package Homework_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

class MyCity {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();

        webDriver.get("https://lovisnami.ru/");
        webDriver.manage().window().setSize(new Dimension(1500, 1100));
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement mayBeCity = webDriver.findElement(By.className("bt_box"));
        mayBeCity.findElement(By.xpath(".//input[2]")).click();

        WebElement windowCity = webDriver.findElement(By.xpath("//*[@id=\"window\"]"));
        windowCity.findElement(By.xpath(".//a[text()='Санкт-Петербург']")).click();

        WebElement cityList = webDriver.findElement(By.xpath("//*[@id=\"window\"]//div[@class='wcontent']"));
        cityList.findElement(By.xpath(".//a[@href='#city3019']")).click();

        Thread.sleep(5_000);
        webDriver.quit();
    }
}