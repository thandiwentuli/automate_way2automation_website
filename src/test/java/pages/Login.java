package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login {
    public WebDriver driver;
    @FindBy(xpath = "//button[@class='btn btn-primary btn-lg'][contains(.,'Customer Login')]")
    WebElement customerLogin_xpath;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyCustomerLogin() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(customerLogin_xpath));
        customerLogin_xpath.isDisplayed();
    }

    public void clickCustomerLoginButton() {
        customerLogin_xpath.click();
    }

}

