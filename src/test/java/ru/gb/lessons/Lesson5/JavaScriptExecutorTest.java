package ru.gb.lessons.Lesson5;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutorTest extends BaseTest {

    @SneakyThrows
    @Test
    void javaScriptExecutorTest() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;

        webDriver.get("https://demoqa.com/modal-dialogs");
        WebElement showSmallModalButton = webDriver.findElement(By.id("showSmallModal"));
        javascriptExecutor.executeScript("arguments[0].click()", showSmallModalButton);
        WebElement modalWindow = webDriver.findElement(By.xpath("//div[contains(@class, 'modal-dialog')]"));
        javascriptExecutor.executeScript("arguments[0].remove()", modalWindow);
        Thread.sleep(5000);
    }
}
