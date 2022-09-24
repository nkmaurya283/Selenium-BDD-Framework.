package logic;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import framework.CreateSession;
import org.openqa.selenium.WebDriver;
import pages.Homepage;
import logger.Log;
import java.io.IOException;

/**
 * This class contains methods to perform action on home page.
 * @author Navneet
 *
 */
public class HomePageHelper  {

	Homepage homepage;
	WebDriver driver ;
	String url;

	public HomePageHelper() throws IOException{
		driver = CreateSession.getWebDriver();
		homepage = new Homepage(driver);
	}

	@Given("^User launch the Application url \"([^\"]*)\"$")
	public void user_launch_the_Application_url(String url) throws Throwable {
		Log.info("*********User enter the url:***********");
		homepage.get(url);
	}

}
