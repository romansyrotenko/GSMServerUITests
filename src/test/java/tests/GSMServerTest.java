package tests;

import org.junit.Test;

import static core.ConfigTests.SEARCH_PRODUCT_NAME;

public class GSMServerTest extends BaseTest {

    @Test
    public void testSearchPage() {
        openMainPageAndSearchProduct();
        searchResultsPage.shouldBeOnSearchPage(SEARCH_PRODUCT_NAME);
    }

    @Test
    public void testAddProductToCartTwice() {
        productPage.open();
        productPage.addProductToCart(2);
        productPage.productShouldBeAddedtoCartNTimes(2);
    }

    @Test
    public void testFindProductOnSearchResultsPage() {
        openMainPageAndSearchProduct();
        searchResultsPage.ProductShouldBeOnSearchResults(SEARCH_PRODUCT_NAME);
    }

    @Test
    public void testCheckProductCountAndPriceOnCart() {
        productPage.open();
        productPage.addProductToCart(2);
        int productCount = productPage.getCountOfProductsInCart();
        float productPrice = productPage.getProductPrice();
        cartPage.open();
        cartPage.shouldBeProductPriceAndProductCountValid(productCount, productPrice);
    }

    private void openMainPageAndSearchProduct() {
        mainPage.open();
        mainPage.searchProduct(SEARCH_PRODUCT_NAME);
    }

}
