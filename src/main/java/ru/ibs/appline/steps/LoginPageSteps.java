package ru.ibs.appline.steps;

import io.cucumber.java.ru.Допустим;

import ru.ibs.appline.pages.LoginPage;

public class LoginPageSteps {
    private final LoginPage loginPage;

    public LoginPageSteps() {
        this.loginPage = new LoginPage();
    }

    @Допустим("Зарегистрироваться в системе логин: {string} пароль: {string}")
    public void зарегистрироваться_в_системе(String login, String password) {
        loginPage.enterLoginAndPassword(login, password);
        loginPage.submitClick();
    }
}
