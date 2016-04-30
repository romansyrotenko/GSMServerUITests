package pages;

import core.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".product-short-info-wrapper .product-button.ga-add-to-cart")
    public WebElement addToCardButton;

    @FindBy(css = ".plus.btn")
    public WebElement plusButton;

    @FindBy(css = ".product-short-info-wrapper .product-price")
    public WebElement productPrice;

    @FindBy(css = ".header-right-icons.cart-icon.empty")
    public WebElement cartIcon;

    @FindBy(css = ".product-button-wrapper .quantity-input > input")
    public WebElement CurrentProductCount;

}

