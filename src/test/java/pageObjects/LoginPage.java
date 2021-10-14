package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getUsername(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name=\"user-name\"]")));
        return driver.findElement(By.cssSelector("[name=\"user-name\"]"));
    }

    private WebElement getPassword(){
        return driver.findElement(By.cssSelector("[name=\"password\"]"));
    }

    private WebElement getLoginButton(){
        return driver.findElement(By.cssSelector("[name=\"login-button\"]"));
    }
    public void open() {

        driver.get("https://qa-challenge.codesubmit.io/");
    }
    public MainPage logIn(String username, String password) {
        getUsername().sendKeys(username);
        getPassword().sendKeys(password);
        getLoginButton().click();
        return new MainPage(driver);
    }
}
