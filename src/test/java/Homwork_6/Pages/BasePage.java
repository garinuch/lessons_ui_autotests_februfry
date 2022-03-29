package Homwork_6.Pages;

import org.openqa.selenium.WebDriver;
import Homwork_6.Pages.block.MainHeader;

public class BasePage extends BaseView {

    public BasePage(WebDriver webDriver) {
        super(webDriver);
    }

    public MainHeader getHeader() {
        return new MainHeader(webDriver);
    }
}