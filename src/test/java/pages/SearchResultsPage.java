package pages;
import core.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.List;

public class SearchResultsPage extends AbstractPage {

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".title-long-text-wrapper")
    public WebElement searchResultString;

    @FindBy(css = "ul li .product-info-wrapper h2")
    public List<WebElement> searchResults;

}
