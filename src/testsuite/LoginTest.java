package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter valid user name
        sendTextToElement(By.name("username"),"tomsmith");
        //Enter valid Password
        sendTextToElement(By.name("password"),"SuperSecretPassword!");
        //Click on login button
        clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        // This is from requirement
        String expectedMessage= "Welcome to the Secure Area. When you are done click logout below.";
        // Find the text element and get the text
        String actualMessage = getTextFromElement(By.xpath("//*[@id=\"content\"]/div/h4"));
        // Validate actual and expected message
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @Test
    public void verifyTheUsernameErrorMessage() {
        //Enter Invalid user name
        sendTextToElement(By.name("username"),"tomsmith1");
        //Enter valid Password
        sendTextToElement(By.name("password"),"SuperSecretPassword!");
        //Click on login button
        clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        // This is from requirement
        String expectedMessage= "Your username is invalid!\n"+"×";
        // Find the text element and get the text
        String actualMessage = getTextFromElement(By.xpath("//div[@id='flash-messages']//div[1]"));
        // Validate actual and expected message
        Assert.assertEquals(expectedMessage,actualMessage);

    }
    @Test
    public void verifyThePasswordErrorMessage() {
        //Enter valid user name
        sendTextToElement(By.name("username"),"tomsmith");
        //Enter Invalid Password
        sendTextToElement(By.name("password"),"SuperSecretPassword");
        //Click on login button
        clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        // This is from requirement
        String expectedMessage= "Your password is invalid!\n"+"×";
        // Find the text element and get the text
        String actualMessage = getTextFromElement(By.xpath("//div[@id='flash-messages']//div[1]"));
        // Validate actual and expected message
        Assert.assertEquals(expectedMessage,actualMessage);

    }
    @After
    public void testDown(){
        closeBrowser();
    }

}