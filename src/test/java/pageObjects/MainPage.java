package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.swing.*;
import java.util.List;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCartButton() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class=\"shopping_cart_link\"]")));
        } catch (TimeoutException err) {
            return false;
        }
        return true;
    }

    public boolean isErrorMessage() {
        try {
            wait.until(x -> x.findElement(By.cssSelector("[class=\"error-message-container error\"]")));
        } catch (TimeoutException err) {
            return false;
        }
        return true;
    }

    public boolean isImageDisplyed(String nameItem) {
        List<WebElement> list = driver.findElements(By.xpath("[src=\"/static/media/sauce-backpack-1200x1500.34e7aa42.jpg\"]" + nameItem + "']"));
        return list.size() > 0 && list.get(0).getText().equals(nameItem);
        //WebElement ImageFile = driver.findElement(By.xpath("//img[contains(@id,'Test Image')]"));
    }

}

