package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends BasePages{

    public CartPage(WebDriver driver) {
        super(driver);
    }
    WebElement ItemName = driver.findElement(By.xpath("(//div[contains(@class,'sc-list-item-content')])[1]"));

    public String getItemName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElements(ItemName));
        return	ItemName.getText();
    }

}
