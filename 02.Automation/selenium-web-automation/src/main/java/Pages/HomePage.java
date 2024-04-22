package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BaseTest {
    By loginBtn = By.xpath("//p[contains(text(),'Giriş Yap')]");
    By navbar = By.cssSelector("div[data-fragment-name='Navigation']");
    By logo = By.cssSelector("img[alt='Trendyol']");
    By searchBar = By.cssSelector("input[placeholder='Aradığınız ürün, kategori veya markayı yazınız']");
    By searchBtn = By.cssSelector(".cyrzo7gC");
    By iphone15 = By.xpath("//span[@title='iPhone 15 128 GB Siyah']");
    By firstProduct = By.xpath("(//div[@class='product-name-wrapper'])[1]");
    By addToCartBtn = By.cssSelector(".add-to-basket-button-text");
    By checkCart = By.cssSelector(".CompleteOrder");

    public HomePage CheckTrendyolLogo(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement navbarElement = wait.until(ExpectedConditions.visibilityOfElementLocated(logo));
        if (!navbarElement.isEnabled()) {
            throw new RuntimeException("Trendyol logosu bulunamadı!");
        }
        return this;
    }
    public HomePage CheckNavbar(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement navbarElement = wait.until(ExpectedConditions.visibilityOfElementLocated(navbar));
        if (!navbarElement.isEnabled()) {
            throw new RuntimeException("Navigasyon barı bulunamadı!");
        }
        return this;
    }
    public HomePage ControlSearching(){
        driver.findElement(searchBar).sendKeys("iphone 15");
        driver.findElement(searchBtn).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement navbarElement = wait.until(ExpectedConditions.visibilityOfElementLocated(iphone15));
        if (!navbarElement.isEnabled()) {
            throw new RuntimeException("Aranan ürün (iPhone 15) bulunamadı!");
        }
        return this;
    }
    public HomePage ControlAddtoCart(){
        driver.findElement(firstProduct).click();
        driver.findElement(addToCartBtn).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cartElement = wait.until(ExpectedConditions.visibilityOfElementLocated(checkCart));
        if (!cartElement.isEnabled()) {
            throw new RuntimeException("Ürün sepete eklenemedi!");
        }
        return this;
    }
    public HomePage goToLogin(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        driver.findElement(loginBtn).click();
        return this;
    }
}
