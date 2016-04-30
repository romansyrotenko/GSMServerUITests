package core;

import com.google.common.base.Function;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static core.ConfigTests.*;


public class AbstractPage {

    public WebDriver driver;
    public Wait wait;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(IMPLICITY_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        this.wait = new FluentWait(driver)
                .withTimeout(FLUENT_WAIT_TIMEOUT, TimeUnit.SECONDS)
                .pollingEvery(FLUENT_WAIT_POLLING, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        PageFactory.initElements(driver, this);
    }

    public void open(String url) {
        driver.get(url);
    }

    public void waitElement(Function function) {
        wait.until(function);
    }

}
