package pages;

import core.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".sortable-table tbody .product-amount")
    public WebElement productAmount;

    @FindBy(css = ".quantity-input>input")
    public WebElement productQuantity;

}
