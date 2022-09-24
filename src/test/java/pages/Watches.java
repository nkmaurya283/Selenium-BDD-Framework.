package pages;

import framework.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

public class Watches extends CommonMethods {

    public Watches(WebDriver driver) throws IOException {
        super(driver);
    }

    public By firstElement = By.xpath("(//span[@class='product-image-container'])[1]");
    public By addToCart = By.xpath("//button[@title='Add to Cart']//span");
    public By cartIcon = By.xpath("//a[starts-with(@class,'action showcart')]");
    public By proceedToCheckout = By.id("top-cart-btn-checkout");

}
