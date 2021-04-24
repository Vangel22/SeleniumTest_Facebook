package init;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public final WebDriverWait wait; //we wait for a certain condition to occur before proceeding
    protected WebDriver driver; //helps us to run automated test in Chrome with Selenium

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }
}
