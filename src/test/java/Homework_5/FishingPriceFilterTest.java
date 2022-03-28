package Homework_5;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.gb.lessons.Lesson5.BaseTest;

import java.util.List;

public class FishingPriceFilterTest extends BaseTest {

    @SneakyThrows
    @Test
    void fishingPriceFilterTest() {
        webDriver.get("https://lovisnami.ru/blesny-kuusamo-finlyandiya.html");
        int newPrice = Integer.parseInt(webDriver.findElement(By.name("price_from")).getAttribute("value").replaceAll("([^0-9]*)", ""));
        int toNewPrice = Integer.parseInt(webDriver.findElement(By.name("price_to")).getAttribute("value").replaceAll("([^0-9]*)", ""));
        int quarter = (toNewPrice - newPrice) / 4;

        List<WebElement> sliders = webDriver.findElements(By.xpath("//span[@class='irs-slider from type_last']"));

        Actions actions = new Actions(webDriver);

        int width = sliders.get(0).getSize().width;
        Point sliderLocation1 = sliders.get(0).getLocation();
        Point sliderLocation2 = sliders.get(1).getLocation();

        int length = sliderLocation2.getX() - sliderLocation1.getX() + width;

        actions.dragAndDropBy(sliders.get(0), (length) /4, 0)
                .build()
                .perform();

        new WebDriverWait(webDriver, 5).until(ExpectedConditions
                .attributeToBe(By.xpath("//span[@class='irs-slider from']"), "style", String.valueOf(newPrice + quarter)));

        actions.dragAndDropBy(sliders.get(1), - (length) /4, 0)
                .build()
                .perform();

        new WebDriverWait(webDriver, 5).until(ExpectedConditions
                .attributeToBe(By.xpath("//span[@class='irs-slider to type_last']"), "style", String.valueOf(toNewPrice - quarter)));

        Thread.sleep(7_000);
    }
}
