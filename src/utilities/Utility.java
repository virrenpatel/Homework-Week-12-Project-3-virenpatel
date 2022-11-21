package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Utility extends BaseTest {
    // Method  with no return type with  Parameter
    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }
    // Method  with no return type with  Parameter
    public void sendTextToElement(By by, String text) {
        WebElement emailField = driver.findElement(by);
        // Type email to email field
        emailField.sendKeys(text);
    }
    // Method with  return type with Parameter
    public String getTextFromElement(By by){
        WebElement actualTextMessageElement = driver.findElement(by);
        return actualTextMessageElement.getText();
    }
}
