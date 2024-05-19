import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import java.util.*;  

import java.net.URL;
import java.net.MalformedURLException;

import java.nio.charset.StandardCharsets;


public class SeleniumTest {
    public WebDriver driver;
    
    @Before
    public void setup()  throws MalformedURLException  {
        ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        driver.manage().window().maximize();
    }

    @Test
    public void testTitle() {
        MainPage mainPage = new MainPage(this.driver);

        // Reading the page title:
        Assert.assertEquals(this.driver.getTitle(), "FineStore - Magazin Online De Bauturi Alcoolice");
    }
    
    // Fill simple form and send (Login)
    // Logout
    @Test
    public void testLoginLogout() {
        MainPage mainPage = new MainPage(this.driver);
        String username = "tothdoratest@yahoo.com";
        String password = "Password.12";
        Assert.assertTrue(mainPage.login(username, password).contains("Salut, Dora"));
        Assert.assertTrue(mainPage.logout().contains("Intra in contul tau Finestore"));
    }

    // Form sending with user
    // Send a form
    @Test
    public void testUpdateProfile() {
        MainPage mainPage = new MainPage(this.driver);
        String username = "tothdoratest@yahoo.com";
        String password = "Password.12";
        Assert.assertTrue(mainPage.login(username, password).contains("Salut, Dora"));
        Assert.assertTrue(mainPage.updateProfile("Nora").contains("Datele personale au fost salvate."));
    }

    // Static Page test
    @Test
    public void testFooter() {
        MainPage mainPage = new MainPage(this.driver);
        Assert.assertTrue(mainPage.getFooterText().contains("FineStore este marca inregistrata a Finestore Distribution SRL (RO 33364695)."));
    }

    @Test
    public void testOrder() {
        MainPage mainPage = new MainPage(this.driver);
        Assert.assertTrue(mainPage.orderByNameDesc().contains("Yellow"));
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
