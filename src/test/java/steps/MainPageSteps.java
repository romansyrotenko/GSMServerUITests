package steps;

import org.openqa.selenium.Keys;
import pages.MainPage;

import static core.ConfigTests.BASE_URL;

public class MainPageSteps {

    MainPage mainPage;

    public MainPageSteps(MainPage mainPage) {
        this.mainPage = mainPage;
    }

    public void open() {
        mainPage.open(BASE_URL);
    }

    public void searchProduct(String productName) {
        mainPage.searchBox.sendKeys(productName + Keys.ENTER);
    }

}
