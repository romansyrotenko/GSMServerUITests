package pages;

import core.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPage extends AbstractPage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".hide-outline")
    public WebElement searchBox;

}
