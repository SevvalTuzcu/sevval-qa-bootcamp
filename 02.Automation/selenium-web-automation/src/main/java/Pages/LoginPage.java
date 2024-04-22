package Pages;

import Base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage extends BaseTest {
    By txtUsername = By.cssSelector("#login-email");
    By txtPassword= By.cssSelector("#login-password-input");
    By btnLogin= By.cssSelector("button[type='submit'] span");

    public LoginPage fillUsername(String text){
        driver.findElement(txtUsername).sendKeys(text);
        return this;
    }
    public LoginPage fillPassword(String text2){
        driver.findElement(txtPassword).sendKeys(text2);
        return this;
    }
    public LoginPage controlLoginWarnings(String errorMessage){
        String text = driver.findElement(By.xpath("//span[@class='message']")).getText();
        Assert.assertEquals(text, errorMessage);
        return this;
    }
    public LoginPage controlSuccessfulLogin(){
        driver.findElement(By.xpath("//p[contains(text(),'Hesabım')]"));
        return this;
    }
    public LoginPage clickLogin(){
        driver.findElement(btnLogin).click();
        return this;
    }
}
