package Homwork6_Homwork7;

import Homwork6_Homwork7.Pages.BaseTest;
import Homwork6_Homwork7.Pages.MainPage;
import Homwork6_Homwork7.Pages.block.LoginContent;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class logAndLogoutTest extends BaseTest {

    @Test
    @DisplayName("Успешные Авторизация и выход из системы")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Успешная авторизация под существующим юзером и выход из системы")
    @TmsLink("")
    @Epic("")
    @Feature("Авторизация на сайте")
    @Issue("")
    @Story("")
    void logAndLogout() {
        new MainPage(webDriver)
                .getHeader()
                .clickLoginButton()
                .login(email, password)
                .logout()
                .checkLoginButtonIsVisible();
    }

    @Test
    @DisplayName("Авторизация: Негативный сценарий: неверный пароль")
    @Severity(SeverityLevel.NORMAL)
    void incorrectPasswordTest() {
        LoginContent loginContent = new MainPage(webDriver)
                .getHeader()
                .clickLoginButton();
        loginContent.login(email, "=== Косяк ===");
        loginContent.checkErrorIsVisible("Логин или пароль указан не верно");
    }
}