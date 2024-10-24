package ru.ibs.appline.steps;

import ru.ibs.appline.pages.CreationTripPage;
import ru.ibs.appline.pages.LoginPage;

public class LoginPageSteps {
    private LoginPage loginPage;
    public LoginPageSteps() {
        this.loginPage = new LoginPage();
    }

    public MainPageSteps login(String login,String password){
        loginPage.enterLoginAndPassword(login,password);
        loginPage.submitClick();
        return new MainPageSteps();
    }
}
