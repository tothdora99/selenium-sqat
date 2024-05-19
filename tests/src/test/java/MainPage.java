import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;



class MainPage extends PageBase {

    // complex xpath 
    private By profileBy = By.xpath("/html/body/header/div[1]/div/div/div[6]/div[3]/span/i[1]");
    
    private By usernameBy = By.id("login_email");
    private By passwordBy = By.id("login_pass");
    private By logginBtnBy = By.id("login_button");
    // complex xpath
    private By checkLoggedInBy = By.xpath("/html/body/div[2]/div/div[1]/div/h2/span");

    // complex xpath
    private By logoutBtnBy = By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/ul/li[9]/a");
    // complex xpath
    private By checkLoggedOutBy = By.xpath("/html/body/div[2]/div/div/div[1]/div/h1");
     
    // complex xpath
    private By modifyProfileBy = By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div[1]/div/div[1]/div[3]/a");
    private By numeBy = By.id("date_personale_nume");
    // complex xpath
    private By modifyBtnBy = By.xpath("//*[@id='changeInfoForm']/div[4]/div[1]/button");
    // complex xpath
    private By checkModifyBy = By.xpath("//*[@id='changeInfoForm']/div[1]");

    // complex xpath
    private By footerBy = By.xpath("/html/body/footer/div[2]/div[2]/div/p[1]");


    private By whiskyBy = By.xpath("/html/body/header/div[3]/div/ul/li[1]/ul/li[2]/a/span[2]/span");
    private By allWhiskyBy = By.xpath("/html/body/header/div[3]/div/ul/li[1]/ul/li[2]/ul/li[3]/ul/li/a");
    private By ordersDescBy = By.xpath("/html/body/div[3]/div/div/div[1]/div[3]/div[2]/div[2]/ul/li[2]/span/label");
    private By checkFirstBy = By.xpath("//*[@id='productsList']/div[1]/div/div[1]/div/div[4]/a");
    
    
    public MainPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://www.finestore.ro/");
    }    

    public String login(String username, String password) {
        this.waitAndReturnElement(profileBy).click();
        // Fill input 
        this.waitAndReturnElement(usernameBy).sendKeys(username);
        // Fill input 
        this.waitAndReturnElement(passwordBy).sendKeys(password);
        this.waitAndReturnElement(logginBtnBy).click();
        System.out.println(this.waitAndReturnElement(checkLoggedInBy).getText());
        return this.waitAndReturnElement(checkLoggedInBy).getText();
    }
    
    public String logout() {
        this.waitAndReturnElement(logoutBtnBy).click();
        System.out.println(this.waitAndReturnElement(checkLoggedOutBy).getText());
        return this.waitAndReturnElement(checkLoggedOutBy).getText();
    }
    
    public String updateProfile(String username) {
        this.waitAndReturnElement(modifyProfileBy).click();
        // Fill input 
        this.waitAndReturnElement(numeBy).clear();
        this.waitAndReturnElement(numeBy).sendKeys(username);
        this.waitAndReturnElement(modifyBtnBy).click();
        System.out.println(this.waitAndReturnElement(checkModifyBy).getText());

        return this.waitAndReturnElement(checkModifyBy).getText();
    }
    
    public String orderByNameDesc() {
        this.waitAndReturnElement(whiskyBy).click();
        this.waitAndReturnElement(allWhiskyBy).click();
        this.waitAndReturnElement(ordersDescBy).click();
        
        return this.waitAndReturnElement(checkFirstBy).getText();
    }

    public String getFooterText() {
        return this.waitAndReturnElement(footerBy).getText();
    }
}
