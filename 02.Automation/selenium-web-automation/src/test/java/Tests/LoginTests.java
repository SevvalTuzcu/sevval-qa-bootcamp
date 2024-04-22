package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.annotations.Test;


@Feature("Login Test Senaryoları")
public class LoginTests extends BaseTest
{
    LoginPage loginPage = new LoginPage();
    HomePage homePage= new HomePage();

    @Step("TC_01 Geçersiz email adresi ile login testi")
    @Test (priority = 0)
    public void InvalidEmailLoginTEST(){
        homePage.goToLogin();
        loginPage
                .fillUsername("Sevval")
                .fillPassword("sifrem"+createRandomNumber(10))
                .clickLogin()
                .controlLoginWarnings(invalidEmail);
    }

    @Step("TC_02 Boş bırakılan şifre ile login testi")
    @Test(priority = 1)
    public void EmptyPasswordLoginTEST(){
        homePage.goToLogin();
        loginPage
                .fillUsername(userEmail)
                .fillPassword("")
                .clickLogin()
                .controlLoginWarnings(emptyPassword);
    }

    @Step("TC_03 Başarılı login testi")
    @Test(priority = 2)
    public void SuccessfulLoginTEST(){
        homePage.goToLogin();
        loginPage
                .fillUsername(registeredEmail)
                .fillPassword(registeredPassword)
                .clickLogin()
                .controlSuccessfulLogin();
    }
}


