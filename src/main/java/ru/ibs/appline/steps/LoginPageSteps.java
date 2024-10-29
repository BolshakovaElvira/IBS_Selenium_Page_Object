package ru.ibs.appline.steps;

import io.qameta.allure.Step;

import ru.ibs.appline.pages.LoginPage;

public class LoginPageSteps {
    private final LoginPage loginPage;
    public LoginPageSteps() {
        this.loginPage = new LoginPage();
    }

    @Step("Регистрируемся в системе (login={login})")
    public MainPageSteps login(String login,String password){
        loginPage.enterLoginAndPassword(login,password);
        loginPage.submitClick();
        return new MainPageSteps();
    }
}
