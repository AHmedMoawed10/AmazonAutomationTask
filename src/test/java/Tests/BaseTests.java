package Tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTests {

    public static WebDriver driver;


    @BeforeSuite
    public void StartDriver()
    {
        //to handle ConnectionFailedException
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--incognito");

        String Chromepath=System.getProperty("user.dir")+"/Drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", Chromepath);
        driver= new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("https://amazon.com");

    }



    @AfterSuite
    public void EndDriver()
    {
        //driver.quit();
    }
}
