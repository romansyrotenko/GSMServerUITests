package steps;

import pages.ProductPage;

import static core.ConfigTests.BASE_URL;
import static core.ConfigTests.PRODUCT_PAGE_URL;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import static junit.framework.TestCase.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.attributeContains;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class ProductPageSteps {

    ProductPage productPage;

    public ProductPageSteps(ProductPage productPage) {
        this.productPage = productPage;
    }

    public void open() {
        productPage.open(BASE_URL + PRODUCT_PAGE_URL);
    }

    public void addProductToCart(int count) {
        productPage.addToCardButton.click();
        if (count > 1) {
            for(int i = 1; i < count; i++) {
                productPage.waitElement(elementToBeClickable(productPage.plusButton));
                productPage.plusButton.click();
            }
        }
        productPage.waitElement(attributeContains(productPage.cartIcon, "data-cart-quantity", getCountOfCurrentProductInCart()));
    }

    public float getProductPrice() {
        String productPrice = productPage.productPrice.getText();
        return parceProductPriceString(productPrice);
    }

    public int getCountOfProductsInCart() {
        return parseInt(productPage.cartIcon.getAttribute("data-cart-quantity"));
    }

    public String getCountOfCurrentProductInCart() {
        return productPage.CurrentProductCount.getAttribute("data-value");
    }

    public void productShouldBeAddedtoCartNTimes(int count) {
        assertEquals(count, parseInt(getCountOfCurrentProductInCart()));
    }

    private float parceProductPriceString(String productPrice) {
        float price = parseFloat(productPrice.replaceAll("[^\\d+\\.]", ""));
        return price;
    }
}
