package logic;

import cucumber.api.java.en.And;
import framework.CreateSession;
import logger.Log;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

public class Watches {

    WebDriver driver ;
    pages.Watches watches;

    public Watches() throws IOException {
        driver = CreateSession.getWebDriver();
        watches=new pages.Watches(driver);
    }

    @And("^User clicks on first item on the watches page and Add the Items In the Cart$")
    public void userClicksOnFirstItemOnTheWatchesPageAndAddTheItemsInTheCart() throws Exception{
        Log.info("*************User add first item on the cart from watches section***************");
        watches.waitForVisibility(watches.firstElement);
        watches.clickOnElementUsingJs(watches.firstElement);
        Thread.sleep(2000);
        watches.waitForVisibility(watches.addToCart);
        watches.clickOnElementUsingJs(watches.addToCart);
    }

    @And("^User click on proceed to checkout button on the cart icon$")
    public void userClickOnProceedToCheckoutButtonOnTheCartIcon() throws Exception{
        Log.info("*************User proceed to checkout from the cart container***************");
        Thread.sleep(3000);//Some time waitForVisibility is not working in current framework so i have placed Thread.sleep
        watches.waitForVisibility(watches.cartIcon);
        watches.clickOnElementUsingActions(watches.cartIcon);
        watches.waitForVisibility(watches.proceedToCheckout);
        watches.clickOnElementUsingActions(watches.proceedToCheckout);
    }
}
