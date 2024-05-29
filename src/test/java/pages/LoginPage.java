package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    final WebDriver driver;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-lg'][contains(.,'Customer Login')]")
    WebElement customerLoginBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyCustomerLogin() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(customerLoginBtn));
        customerLoginBtn.isDisplayed();
    }

    public void clickCustomerLoginButton() {
        customerLoginBtn.click();
    }

}

