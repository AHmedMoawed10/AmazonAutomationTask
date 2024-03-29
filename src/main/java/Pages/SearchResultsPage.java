package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage extends BasePages{

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    WebElement FirstItem = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small puis-padding-left-small puis-padding-right-small'][contains(.,'Ships to Egypt')]"));


    public ItemDetailsPage selectFirstItem() {
        FirstItem.click();
        return new ItemDetailsPage(driver);
    }

    public String getfirstItemName() {
        return FirstItem.getText();
    }
}
