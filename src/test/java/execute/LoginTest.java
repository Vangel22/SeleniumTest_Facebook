package execute;

import init.LoginSuccess;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import init.LoginPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class LoginTest {
    private WebDriver driver;

    @BeforeTest
    public void setup(){
        driver = getDriver();
    }

    @Test
    public void testLoginSuccess() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("X", "X");
        //ova e testirano i raboti -> ostaveno e so X za da se zacuva privatnosta na mojot mejl i lozinka
        assertTrue(new LoginSuccess(driver).isLoaded());
    }

    @Test
    public void testInvalidCredentialsAndErrorMessage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("standard_user", "secret");
        String errorMessage = loginPage.getErrorMessage();
        assertEquals(errorMessage,
        "The email or mobile number you entered isn’t connected to an account. Find your account and log in.");
    }

    @Test
    public void testNoUsernameAndWithPasswordGetErrorMessage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("", "secret");
        String errorMessage = loginPage.getErrorMessage();
        assertEquals(errorMessage,
                "The email or mobile number you entered isn’t connected to an account. Find your account and log in.");
    }

    private WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/vange/IdeaProjects/SoftwareTesting3/src/main/resources/chrome_driver/chromedriver.exe");
        return new ChromeDriver();
    }
}
