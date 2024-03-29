package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;


public class BasePages {



    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Select select;
    protected Actions actions;

    public BasePages(WebDriver driver)
    {
        this.driver=driver;
    }

}
