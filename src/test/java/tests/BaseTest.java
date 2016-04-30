package tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.CartPage;
import pages.MainPage;
import pages.ProductPage;
import pages.SearchResultsPage;
import steps.CartPageSteps;
import steps.MainPageSteps;
import steps.ProductPageSteps;
import steps.SearchResultsPageSteps;


public abstract class BaseTest {

    public static WebDriver driver;
    public static MainPageSteps mainPage;
    public static ProductPageSteps productPage;
    public static SearchResultsPageSteps searchResultsPage;
    public static CartPageSteps cartPage;

    @BeforeClass
    public static void initializeDriver() {
        driver = new FirefoxDriver();
    }

    @BeforeClass
    public static void initializePages() {
        mainPage = new MainPageSteps(new MainPage(driver));
        productPage = new ProductPageSteps(new ProductPage(driver));
        searchResultsPage = new SearchResultsPageSteps(new SearchResultsPage(driver));
        cartPage = new CartPageSteps(new CartPage(driver));
    }

    @After
    public void cleanAllCoockies() {
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }

}
