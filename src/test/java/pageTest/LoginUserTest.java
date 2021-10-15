package pageTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;

public class LoginUserTest extends BaseTest {

    @Test
    public void standartUser(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.logIn(username,password);
        Assert.assertTrue(mainPage.isCartButton());
    }
    @Test
    public void lockedOutUser(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.logIn("locked_out_user",password);
        Assert.assertTrue(mainPage.isErrorMessage());
    }
    @Test
    public void problemUser(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.logIn("problem_user",password);
        Assert.assertTrue(mainPage.isCartButton());
    }
    @Test
    public void perfomanceGlitchUser(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.logIn(username,password);
        Assert.assertTrue(mainPage.isCartButton());
    }
}
