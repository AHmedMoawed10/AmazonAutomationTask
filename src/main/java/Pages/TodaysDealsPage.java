package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TodaysDealsPage extends BasePages{

    public TodaysDealsPage(WebDriver driver) {
        super(driver);
    }


    int productIndex = 6;

    WebElement headphonesCheckBox = driver.findElement(By.xpath("//span[@class='CheckboxFilter-module__checkboxLabel_21MUk0e7QdlZKH5Xcwap-F'][contains(.,'Headphones')]"));
    WebElement groceryCheckBox = driver.findElement(By.xpath("//span[@class='CheckboxFilter-module__checkboxLabel_21MUk0e7QdlZKH5Xcwap-F'][contains(.,'Grocery')]"));
    WebElement chooseDiscount = driver.findElement(By.linkText("10% off or more"));
    WebElement thirdPage = driver.findElement(By.xpath("//a[@href='#'][contains(.,'3')]"));
    WebElement fourthPageBtn = driver.findElement(By.xpath("//a[@href='#'][contains(.,'4')]"));
    WebElement itemToAdd = driver.findElement(By.xpath("(//div[contains(@class,'sWbxETx42ZPStTc9jwySW')])["+productIndex+"]"));


    WebElement addToCartBtn = driver.findElement(By.id("add-to-cart-button"));
    WebElement addedToCartMessage = driver.findElement(By.xpath("//span[contains(.,'Added to Cart')]"));

    public void selectHeadphonesAndgroceryFromFilters() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(headphonesCheckBox));
        headphonesCheckBox.click();
        groceryCheckBox.click();
    }

    public void selectTenPercentDiscount() {
        chooseDiscount.click();
    }

    public void selectThefourthPage() {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(thirdPage));
        thirdPage.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(fourthPageBtn));
        fourthPageBtn.click();
    }

    public void AddItemToCart() {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(itemToAdd));
        driver.findElement(By.xpath("(//div[contains(@class,'sWbxETx42ZPStTc9jwySW')])["+productIndex+"]")).click();

        boolean done = false;
        while(!done) {
            try {
                ((JavascriptExecutor)driver).executeScript("arguments[0].click();", addToCartBtn);
                done = true;
            }
            catch(org.openqa.selenium.NoSuchElementException e) {
                driver.navigate().back();
                productIndex++;
                wait.until(ExpectedConditions.visibilityOfAllElements(itemToAdd));
                driver.findElement(By.xpath("(//div[contains(@class,'sWbxETx42ZPStTc9jwySW')])["+productIndex+"]")).click();

            }
        }
    }

    public String getAddedToCartMessage() {
        return addedToCartMessage.getText();
    }


}
