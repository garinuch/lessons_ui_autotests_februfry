package Homwork_6;

import Homwork_6.Pages.BaseTest;
import Homwork_6.Pages.MainPage;
import Homwork_6.Pages.block.LoginContent;
import org.junit.jupiter.api.Test;

public class logAndLogoutTest extends BaseTest {

    @Test
    void loginAndLogout() {
        new MainPage(webDriver)
                .getHeader()
                .clickLoginButton()
                .login(email, password)
                .logout()
                .checkLoginButtonIsVisible();
    }

    @Test
    void incorrectPasswordTest() {
        LoginContent loginContent = new MainPage(webDriver)
                .getHeader()
                .clickLoginButton();
        loginContent.login(email, "Логин или пароль указан не верно");
        loginContent.checkErrorIsVisible("Логин или пароль указан не верно");
    }
}
