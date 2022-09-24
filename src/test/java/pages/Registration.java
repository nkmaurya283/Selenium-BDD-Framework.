package pages;
import framework.CommonMethods;
import framework.CreateSession;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

public class Registration extends CommonMethods {

    public Registration(WebDriver driver) throws IOException {
        super(driver);
    }

    public By createAnAccount = By.xpath("//div[@class='panel header']//a[contains(text(),'Create an Account')]");
    public By fName = By.id("firstname");
    public By LName = By.id("lastname");
    public By emailId = By.id("email_address");
    public By password = By.id("password");
    public By confirmPass = By.id("password-confirmation");
    public By createAccountBtn = By.xpath("//button//span[contains(text(),'Create an Account')]");
    public By gearMenu = By.xpath("//*[@id='store.menu']//span[contains(text(),'Gear')]");
    public By watches = By.xpath("//*[@id='store.menu']//span[contains(text(),'Watches')]");

}
