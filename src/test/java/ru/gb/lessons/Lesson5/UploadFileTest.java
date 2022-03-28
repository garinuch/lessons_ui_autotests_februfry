package ru.gb.lessons.Lesson5;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class UploadFileTest extends BaseTest {

    @SneakyThrows
    @Test
    void uploadFileTest() {
        webDriver.get("http://the-internet.herokuapp.com/upload");
        webDriver.findElement(By.xpath("//input[@type='file']"))
                .sendKeys("/Users/dimakar/GB/february/lessons-ui-autotests-february/src/test/resources/logback.xml");
        Thread.sleep(5000);
    }
}