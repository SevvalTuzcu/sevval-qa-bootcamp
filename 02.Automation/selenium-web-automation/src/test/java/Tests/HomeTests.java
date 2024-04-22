package Tests;

import Base.BaseTest;
import Pages.HomePage;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

@Feature("Home Page Test Caseleri")
public class HomeTests extends BaseTest {
    HomePage homePage = new HomePage();

    @Step("TC_04 Trendyol logo doğrulama testi.")
    @Test(priority = 3)
    public void CheckLogoTEST() {
        homePage.CheckTrendyolLogo();
    }

    @Step("TC_05 Navigasyon barı doğrulama testi.")
    @Test(priority = 4)
    public void CheckNavbarTEST() {
        homePage.CheckNavbar();
    }

    @Step("TC_06 Aranılan ürünü bulma testi.")
    @Test(priority = 5)
    public void SearchAndFindProductTEST() {
        homePage.ControlSearching();
    }

    @Step("TC_07 Seçilen ürünü sepete ekleme doğrulama testi.")
    @Test(priority = 6)
    public void ControlAddToCart() {
        homePage.ControlAddtoCart();
    }
}


