package ru.gb.lessons.Lesson5;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PriceFilterTest extends BaseTest {
    @Test
    void priceFilterTest() {
        webDriver.get("https://pop-music.ru/catalog/gitaryi/akusticheskie-bas-gitary/");
        int startPrice = Integer.parseInt(webDriver.findElement(By.id("arrFilterElement_P1_MIN")).getAttribute("value").replaceAll("([^0-9]*)", ""));
        int toPrice = Integer.parseInt(webDriver.findElement(By.id("arrFilterElement_P1_MAX")).getAttribute("value").replaceAll("([^0-9]*)", ""));
        int quarter = (toPrice - startPrice) / 4;

        List<WebElement> sliders = webDriver.findElements(By.xpath("//div[@role='slider']"));

        Actions actions = new Actions(webDriver);

        int width = sliders.get(0).getSize().width;
        Point slider1Location = sliders.get(0).getLocation();
        Point slider2Location = sliders.get(1).getLocation();

        int length = slider2Location.getX() - slider1Location.getX() + width;

        actions.dragAndDropBy(sliders.get(0), (length) / 4, 0)
                .build()
                .perform();

        new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions
                .attributeToBe(By.id("arrFilterElement_P1_MIN"), "value", String.valueOf(startPrice + quarter)));

        actions.dragAndDropBy(sliders.get(1), -(length) / 4, 0)
                .build()
                .perform();

        new WebDriverWait(webDriver, 7)
                .until(ExpectedConditions
                .attributeToBe(By.id("arrFilterElement_P1_MAX"), "value", String.valueOf(toPrice - quarter)));
    }
}
