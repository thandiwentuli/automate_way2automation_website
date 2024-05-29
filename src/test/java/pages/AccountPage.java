package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class AccountPage {

    final WebDriver driver;

    @FindBy(xpath = "//button[@ng-class='btnClass1'][contains(.,'Transactions')]")
    WebElement transactionBtn;

    @FindBy(xpath = "//button[@ng-class='btnClass2'][contains(.,'Deposit')]")
    WebElement deposit;

    @FindBy(xpath = "//button[@ng-class='btnClass3'][contains(.,'Withdrawl')]")
    WebElement withdrawalBtn;

    @FindBy(xpath = "//button[@type='submit'][contains(.,'Withdraw')]")
    WebElement processWithdrawButton;

    @FindBy(xpath = "//select[contains(@name,'accountSelect')]")
    WebElement accountList;

    @FindBy(xpath = "//input[@ng-model='amount']")
    WebElement depositamount;

    @FindBy(xpath = "//button[contains(.,'Reset')]")
    WebElement resetBtn;

    @FindBy(xpath = "//button[contains(.,'Back')]")
    WebElement backBtn;

    @FindBy(xpath = "//span[contains(.,'Deposit Successful')]")
    WebElement successfulDeposit;

    @FindBy(xpath = "//button[@type='submit'][contains(.,'Deposit')]")
    WebElement depositBtn;
    @FindBy(xpath = "//button[contains(.,'Logout')]")
    WebElement logout;


    public static String transaction_button_xpath= "(//button[contains(@class,'btn btn-lg tab')])[2]";
    public static String deposit_button_xpath= "(//button[contains(@class,'btn btn-lg tab')])[2]";
    public static String final_deposit_button_xpath= "(//button[contains(.,'Deposit')])[2]";

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElements() {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfAllElements(transactionBtn, deposit, withdrawalBtn, accountList));
    }

    public void verifyLoggedInUser(String customer) {
        var container = driver.findElement(By.className("borderM"));

        if (container == null)
            return;

        var div = container.findElement(By.tagName("div"));

        if (div == null)
            return;

        var strong = div.findElement(By.tagName("strong"));

        if (strong == null)
            return;

        var span = div.findElement(By.tagName("span"));

        if (span == null)
            return;

        var user = span.getText();

        Assert.assertEquals(customer, user);
    }

    public void selectAcc(String AccountNumber) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[contains(@name,'accountSelect')]")));
        Select accountList = new Select(dropdown);
        accountList.selectByVisibleText(AccountNumber);
        List<WebElement> allOptions = accountList.getOptions();

        // Iterate the list using for loop
        for (WebElement allOption : allOptions) {

            if (allOption.getText().contains(AccountNumber)) {

                allOption.click();

                System.out.println("Selected " + "  " + allOption.getText());

                break;
            }
        }
    }

    public void click_depositButton(){
        driver.findElement(By.xpath(deposit_button_xpath)).click();
    }

    public void click_finalDepositButton(){
        driver.findElement(By.xpath(final_deposit_button_xpath)).click();
    }

    public void checkBalance(String balance) throws InterruptedException {
        var container = driver.findElement(By.className("borderM"));

        if (container == null)
            return;

        var div = container.findElements(By.tagName("div"));

        if (div == null)
            return;

        var strong = div.get(1).findElements(By.tagName("strong"));

        if (strong == null)
            return;

        var balanceAcc = Integer.parseInt(strong.get(1).getText());

        if (balanceAcc > 0) {
            transactionBtn.click();
            resetBtn.click();
            backBtn.click();
            deposit.click();
            setDepositamount("1500");

        } else {
            deposit.click();
            setDepositamount("1500");

        }

    }

    public void checkBalance(String balance, String depositBalance) throws InterruptedException {
        var container = driver.findElement(By.className("borderM"));

        if (container == null)
            return;

        var div = container.findElements(By.tagName("div"));

        if (div == null)
            return;

        var strong = div.get(1).findElements(By.tagName("strong"));

        if (strong == null)
            return;

        var balanceAcc = Integer.parseInt(strong.get(1).getText());

        if (balanceAcc > 0) {
            transactionBtn.click();
            resetBtn.click();
            backBtn.click();
        }
        deposit.click();
        setDepositamount(depositBalance);
    }

    public void setDepositamount(String depositamo) throws InterruptedException {
        Thread.sleep(1000);
        depositamount.sendKeys(depositamo);
        depositBtn.click();
        Assert.assertEquals(successfulDeposit.getText(), "Deposit Successful");
    }

    public void performWithdrawal(String withdrawalAmount) throws InterruptedException {
        Thread.sleep(1000);
        depositamount.sendKeys(withdrawalAmount);
        Assert.assertEquals(successfulDeposit.getText(), "Withdrawal Successful");
    }

    public void clickPerformWithdrawButton() {
        processWithdrawButton.click();
    }

    public void openTransactions(){
        transactionBtn.click();
        try{
            Thread.sleep(2000);
        }catch (Exception x){
            System.out.println(x.getMessage());
        }
    }

    public void clickBackBtn(){
        backBtn.click();
    }

    public void validateTransactions(String balance){
        var container = driver.findElement(By.className("borderM"));

        if (container == null)
            return;

        var div = container.findElements(By.tagName("div"));

        if (div == null)
            return;

        var strong = div.get(1).findElements(By.tagName("strong"));

        if (strong == null)
            return;

        var currentBal = strong.get(1).getText();

        Assert.assertEquals(currentBal, balance);
    }

    public void clickWithdrawalButton(){
        withdrawalBtn.click();
    }

    public void clickLogoutButton(){
        logout.click();
    }
}