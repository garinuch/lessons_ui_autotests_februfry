package Homwork6_Homwork7.Pages;

import org.openqa.selenium.WebDriver;
import Homwork6_Homwork7.Pages.block.MainHeader;

public class BasePage extends BaseView {

    public BasePage(WebDriver webDriver) {
        super(webDriver);
    }

    public MainHeader getHeader() {
        return new MainHeader(webDriver);
    }
}