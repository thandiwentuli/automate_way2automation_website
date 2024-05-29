package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.AccountPage;
import pages.CustomerPage;
import pages.LoginPage;

public class Base {
    final WebDriver driver = BrowserFactory.startBrowser("firefox", "https://www.way2automation.com/angularjs-protractor/banking/#/login");
    final LoginPage login;
    final CustomerPage customerPage;
    final AccountPage accountPage;

    public Base(){
        login = PageFactory.initElements(driver, LoginPage.class);
        customerPage = PageFactory.initElements(driver, CustomerPage.class);
        accountPage = PageFactory.initElements(driver, AccountPage.class);
    }

    public LoginPage getLogin() {
        return login;
    }

    public CustomerPage getCustomerPage() {
        return customerPage;
    }

    public AccountPage getAccountPage() {
        return accountPage;
    }
}