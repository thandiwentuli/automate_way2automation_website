package pages;

import freemarker.template.utility.NullArgumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class CustomerPage {

    WebDriver driver;

    @FindBy(xpath = "//label[contains(.,'Your Name :')]")
    WebElement yourNameText;

    @FindBy(xpath = "//select[@name='userSelect']")
    WebElement customerDropDown;

    public CustomerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void initialize() {
        try{
            new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfAllElements(yourNameText, customerDropDown));

            if(yourNameText == null || customerDropDown == null) {
                System.out.println("Required elements have not been loaded!");
                return;
            }

            System.out.println("\n\nSuccess: Found all required elements!");

        }catch (Exception ex){
            System.out.printf("\n\nInitialize error -> %s", ex.getMessage());
        }
    }

    public void verifyYourNameText() {
        if(yourNameText == null)
            throw new NullArgumentException("yourNameText variable is null!" );

        String results = yourNameText.getText();
        Assert.assertEquals(results, "Your Name :");

    }

    public void clickCustomerDropDown() {
        if(customerDropDown == null)
            throw new NullArgumentException("customerDropDown variable is null!" );

        customerDropDown.click();
    }
}
