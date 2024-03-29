package Tests;

import Pages.HomePage;
import Pages.TodaysDealsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondScenario extends BaseTests{

    HomePage homeObject;
    TodaysDealsPage todaysDealsObject;

    @Test
    public void SecondScenario()
    {
        homeObject=new HomePage(driver);

        todaysDealsObject=new TodaysDealsPage(driver);

        todaysDealsObject=homeObject.openTodaysDeals();
        todaysDealsObject.selectHeadphonesAndgroceryFromFilters();
        todaysDealsObject.selectTenPercentDiscount();
        todaysDealsObject.selectThefourthPage();
        todaysDealsObject.AddItemToCart();
        Assert.assertTrue(todaysDealsObject.getAddedToCartMessage().contains("Added to Cart"));


    }
}
