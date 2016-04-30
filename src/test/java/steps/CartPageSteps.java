package steps;

import pages.CartPage;

import static core.ConfigTests.BASE_URL;
import static core.ConfigTests.CART_PAGE_URL;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import static junit.framework.TestCase.assertEquals;

public class CartPageSteps {

    CartPage cartPage;

    public CartPageSteps(CartPage cartPage) {
        this.cartPage = cartPage;
    }

    public void open() {
        cartPage.open(BASE_URL + CART_PAGE_URL);
    }

    public float getProductAmount() {
        return parseFloat(cartPage.productAmount.getText());
    }

    public int getCountOfProduct() {
        return parseInt(cartPage.productQuantity.getAttribute("data-value"));
    }

    public void shouldBeProductPriceAndProductCountValid(int productCount, float productPrice) {
        assertEquals(productCount,getCountOfProduct());
        assertEquals(productPrice * productCount,getProductAmount());
    }

}
