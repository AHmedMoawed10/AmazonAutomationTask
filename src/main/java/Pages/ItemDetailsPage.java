package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ItemDetailsPage extends BasePages{


    public ItemDetailsPage(WebDriver driver) {
        super(driver);
    }


    WebElement AddToCartBtn = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
    WebElement GoToCartBtn = driver.findElement(By.linkText("Go to Cart"));

    public void addItemToCart() {
        AddToCartBtn.click();
    }

    public CartPage goToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(GoToCartBtn));
        GoToCartBtn.click();
        return new CartPage(driver);
}}
