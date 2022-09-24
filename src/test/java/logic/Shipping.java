package logic;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import framework.CreateSession;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import logger.Log;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Shipping {

    WebDriver driver ;
    pages.Shipping shipping;
    String streetAddress="";
    String city="";
    String phoneNumber="";

    public Shipping() throws IOException {
        driver = CreateSession.getWebDriver();
        shipping=new pages.Shipping(driver);
    }
    @And("^User enter the shipping address on shipping page$")
    public void userEnterTheShippingAddressOnShippingPage() {
        RestAssured.baseURI = "https://randomuser.me";
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/")
                .then()
                .extract().response();
        System.out.println(response.asString());
        streetAddress=response.jsonPath().getString("results.location.street.name[0]");
        city=response.jsonPath().getString("results.location.city[0]");
        phoneNumber=response.jsonPath().getString("results.phone[0]");
        Log.info("*********StreetAddress is:***********"+streetAddress);
        Log.info("*********City Name is:***********"+city);
        Log.info("*********Phone Number is  :***********"+phoneNumber);
        shipping.waitForVisibility(shipping.streetAddress);
        shipping.findElement(shipping.streetAddress).sendKeys(streetAddress);
        shipping.findElement(shipping.city).sendKeys(city);
        shipping.findElement(shipping.telephone).sendKeys(phoneNumber);
    }

    @And("^User select value from state at index (\\d+) and country at index (\\d+) from dropdown$")
    public void userSelectValueAtIndexAndCountryAtIndexFromDropdown(int index1, int index2) throws Exception {
        Log.info("*********User select the state and Country:***********");
        shipping.waitForVisibility(shipping.stateProvince);
        shipping.selectValuefromDropdownviaIndex(shipping.stateProvince,index1);
        shipping.selectValuefromDropdownviaIndex(shipping.country,index2);
    }

    @And("^User clicks on Next button on the page$")
    public void userClicksOnNextButtonOnThePage() throws Throwable {
        Log.info("*********User click on Next button :***********");
        WebElement ele=driver.findElement(shipping.nextBtn);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", ele);
        Thread.sleep(4000);//page is refreshed after some time after selecting Country so need to give This Wait
        shipping.clickOnElementUsingJs(shipping.nextBtn);
    }

    @And("^User click on place order button on the page$")
    public void userClickOnPlaceOrderButtonOnThePage() throws Throwable{
        Log.info("*********It will click on place order button :***********");
        shipping.waitForVisibility(shipping.placeOrderBtn);
        shipping.waitForElementToBeClickable(shipping.placeOrderBtn);
        shipping.clickOnElementUsingJs(shipping.placeOrderBtn);
    }

    @And("^User enter the Zip code \"([^\"]*)\" in the field$")
    public void userEnterTheZipCodeInTheField(String zipCode) throws Throwable {
        Log.info("*********Zip code is  :***********"+zipCode);
        shipping.findElement(shipping.zipCode).sendKeys(zipCode);
    }

    @Then("^User verify the order has been placed with \"([^\"]*)\" message$")
    public void userVerifyTheOrderHasBeenPlacedWithMessage(String expectedMsg) throws Throwable {
        Log.info("*********Verify the order is placed :***********");
        shipping.waitForVisibility(shipping.thankYouMsg);
        String actualMsg=shipping.findElement(shipping.thankYouMsg).getText();
        Log.info("*********Actual msg  is  :***********"+actualMsg);
        Assert.assertEquals(actualMsg,expectedMsg,"Order has not been placed");//If Actual in not equal to expected then this message will be thrown
    }
}
