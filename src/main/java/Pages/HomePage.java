package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePages {

    public HomePage(WebDriver driver) {
        super(driver);
    }


    WebElement searchTextBox = driver.findElement(By.xpath("//input[@type='text']"));
    WebElement searchBtn = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));;
    WebElement todaysDealsBtn = driver.findElement(By.linkText("Today's Deals"));
    WebElement exceptionBtn= driver.findElement(By.xpath("//input[@data-action-params='{\"toasterType\":\"AIS_INGRESS\"}']"));

    public void typeTextInSearchBox(String text) {
        searchTextBox.sendKeys(text);
        searchBtn.click();
    }



    public TodaysDealsPage openTodaysDeals() {
        try{
            todaysDealsBtn.click();
            System.out.printf("one");
        }
        catch(ElementClickInterceptedException e) {
            exceptionBtn.click();

            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfAllElements(todaysDealsBtn));
            todaysDealsBtn.click();
            System.out.printf("two");
        }

        return new TodaysDealsPage(driver);

    }





}
