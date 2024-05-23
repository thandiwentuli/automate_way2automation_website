package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.CustomerPage;
import pages.Login;

import static utils.BrowserFactory.driver;

public class Base {
    BrowserFactory browserFactory = new BrowserFactory();
    final WebDriver driver = browserFactory.startBrowser("firefox", "https://www.way2automation.com/angularjs-protractor/banking/#/login");
    public  Login login = PageFactory.initElements(driver, Login.class);
    public CustomerPage customerPage = PageFactory.initElements(driver, CustomerPage.class);
}