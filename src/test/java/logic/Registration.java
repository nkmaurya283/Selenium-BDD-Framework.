package logic;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import framework.CreateSession;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import pages.Homepage;
import logger.Log;
import java.io.IOException;
import static io.restassured.RestAssured.given;
public class Registration {

    WebDriver driver ;
    String concatValue="123$";
    pages.Registration registration;
    String firstName="";
    String lastName="";
    String email="";
    String password="";


    public Registration() throws IOException {
        driver = CreateSession.getWebDriver();
        registration=new pages.Registration(driver);
    }

    @Given("^User call the Get API endpoint \"([^\"]*)\" to fetch FirstName, LastName, Email, and Password\\.$")
    public void userCallTheGetAPIEndpointToFetchFirstNameLastNameEmailAndPassword(String apiEndPoint) throws Throwable {
        Log.info("*************User fetch the FirstName, LastName, Email and Password from random user api***************");
        RestAssured.baseURI = apiEndPoint;
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/")
                .then()
                .extract().response();
        System.out.println(response.asString());
        firstName=response.jsonPath().getString("results.name.first[0]");
        lastName=response.jsonPath().getString("results.name.last[0]");
        email=response.jsonPath().getString("results.email[0]");
        password=response.jsonPath().getString("results.login.password[0]");
        Log.info("*************First Name is:***************"+firstName);
        Log.info("*************Last Name is:***************"+lastName);
        Log.info("*************Email Name is:***************"+email);
        Log.info("*************Password Name is:***************"+password);

    }
    @And("^User click on Create an Account link on the page$")
    public void userClickOnCreateAnAccountOnThePage() {
        Log.info("*************User clicks on Create Account link on the page***************");
        registration.waitForVisibility(registration.createAnAccount);
        registration.clickOnElementUsingActions(registration.createAnAccount);
    }

    @And("^User Enter the FName , LName , Email , Password , and ConfirmPassword values in respective field$")
    public void userEnterTheFnameLnameEmailPasswordAndConfirmPasswordValuesInRespectiveField() throws Exception{
        Log.info("*************User enters Registration details***************");
        registration.waitForVisibility(registration.fName);
        registration.findElement(registration.fName).sendKeys(firstName);
        registration.findElement(registration.LName).sendKeys(lastName);
        registration.findElement(registration.emailId).sendKeys(email);
        registration.findElement(registration.password).sendKeys(password+concatValue);
        registration.findElement(registration.confirmPass).sendKeys(password+concatValue);

    }

    @And("^User click on Create account button at the bottom of the page$")
    public void userClickOnCreateAccountButtonAtTheBottomOfThePage() throws Exception {
        Log.info("*************User click on Create account button at the bottom of the page***************");
        registration.waitForElementToBeClickable(registration.createAccountBtn);
        registration.clickOnElementUsingActions(registration.createAccountBtn);
    }

    @And("^User Mouse hover on Gear in Header Menu and Click on Watches$")
    public void userMouseHoverOnGearInHeaderMenuAndClickOnWatches() throws Exception {
        Log.info("*************User Mouse hovers on Gear Menu and click on watches sub menu***************");
        registration.waitForVisibility(registration.gearMenu);
        registration.mouseHoverOnElement(registration.gearMenu);
        registration.clickOnElementUsingActions(registration.watches);
    }
}
