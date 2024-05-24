package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AccountPage {

    WebDriver driver;

    @FindBy(xpath = "//button[@ng-class='btnClass1'][contains(.,'Transactions')]")
    WebElement transactionBtn;

    @FindBy(xpath = "//button[@ng-class='btnClass2'][contains(.,'Deposit')]")
    WebElement deposit;

    @FindBy(xpath = "//button[@ng-class='btnClass2'][contains(.,'Deposit')]")
    WebElement withdrawalBtn;

    @FindBy(xpath = "//select[contains(@name,'accountSelect')]")
    WebElement accountList;

    public AccountPage(WebDriver driver){
        this.driver = driver;
    }

    public void waitForElements(){
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfAllElements(transactionBtn, deposit, withdrawalBtn, accountList));
    }

    public void verifyLoggedInUser(String customer){
        var container = driver.findElement(By.className("borderM"));

        if(container == null)
            return;

        var div = container.findElement(By.tagName("div"));

        if(div == null)
            return;

        var strong = div.findElement(By.tagName("strong"));

        if(strong == null)
            return;

        var span = div.findElement(By.tagName("span"));

        if(span == null)
            return;

        var user = span.getText();

        Assert.assertEquals(customer, user);
    }
}
