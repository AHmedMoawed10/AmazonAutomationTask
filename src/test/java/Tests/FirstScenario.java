package Tests;

import DataDriven.LoadProperties;
import Pages.CartPage;
import Pages.HomePage;
import Pages.ItemDetailsPage;
import Pages.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstScenario extends BaseTests{


    HomePage homeObject;

    SearchResultsPage SearchPageObject;

    ItemDetailsPage itemDetailsObj;

    CartPage cartPageObj;
    String ProductSearch= LoadProperties.userData.getProperty("Search");

    String ItemName="";
    String verifyItemName="";

    @Test
    public void FirstScenario()
    {
        homeObject=new HomePage(driver);
        homeObject.typeTextInSearchBox(ProductSearch);

        SearchPageObject=new SearchResultsPage(driver);
        ItemName=SearchPageObject.getfirstItemName();

        itemDetailsObj=new ItemDetailsPage(driver);
        itemDetailsObj=SearchPageObject.selectFirstItem();
        itemDetailsObj.addItemToCart();

        CartPage cartPageObj=new CartPage(driver);
        cartPageObj=itemDetailsObj.goToCart();

        verifyItemName=cartPageObj.getItemName();
        Assert.assertTrue(ItemName.contains(verifyItemName.subSequence(0, 10).toString()));







    }
}
