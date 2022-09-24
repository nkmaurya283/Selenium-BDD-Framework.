package pages;

import framework.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

public class Shipping extends CommonMethods {

    public Shipping(WebDriver driver) throws IOException {
        super(driver);
    }

    public By streetAddress = By.xpath("(//fieldset[@class='field street admin__control-fields required']//input[@class='input-text'])[1]");
    public By city = By.xpath("//input[@name='city']");
    public By stateProvince = By.xpath("//select[@name='region_id']");
    public By zipCode = By.xpath("//input[@name='postcode']");
    public By country = By.xpath("//select[@name='country_id']");
    public By telephone = By.xpath("//input[@name='telephone']");
    public By nextBtn = By.xpath("//span[contains(text(),'Next')]");
    public By placeOrderBtn = By.xpath("//span[contains(text(),'Place Order')]");
    public By thankYouMsg = By.xpath("//span[contains(text(),'Thank you for your purchase!')]");

}
