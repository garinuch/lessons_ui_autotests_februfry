package ru.gb.lessons.Lesson5;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WindowsFramesAlertsTest extends BaseTest {

    @Test
    void windowSwitchTest() {
        webDriver.get("https://demoqa.com/browser-windows");
        webDriver.findElement(By.id("tabButton")).click();

        List<String> windowHandles = List.copyOf(webDriver.getWindowHandles());

        assertThat(windowHandles).hasSize(2);
        webDriver.switchTo().window(windowHandles.get(1));

        new WebDriverWait(webDriver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='This is a sample page']")));
    }

    @Test
    void frameSwitchTest() {
        webDriver.get("https://demoqa.com/frames");
        webDriver.switchTo().frame("frame1");
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='This is a sample page']")));
    }

    @Test
    void alertTest() {
        webDriver.get("https://demoqa.com/alerts");
        webDriver.findElement(By.id("alertButton")).click();
        webDriver.switchTo().alert().accept();
    }
}