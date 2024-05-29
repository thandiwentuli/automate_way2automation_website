package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.DataTableType;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;
import pages.CustomerPage;
import utils.Base;
import utils.BrowserFactory;

import java.util.List;
import java.util.Map;

public class LoginSteps extends Base {

    @Given("the User is on the homepage")
    public void the_user_is_on_the_homepage() {
        getLogin().verifyCustomerLogin();
    }

    @When("the User Clicks the Customer Login Button")
    public void the_user_clicks_the_customer_login_button() {
        getLogin().clickCustomerLoginButton();
    }

    @And("the User Clicks Dropdown List")
    public void the_user_clicks_dropdown_list() {
        getCustomerPage().initialize();
        getCustomerPage().verifyYourNameText();
        getCustomerPage().clickCustomerDropDown();
    }

    @And("the User Selects A Username {string}")
    public void theUserSelectsAUsername(String customerYourName) {
        getCustomerPage().click_yourName_dropDownList(customerYourName);
    }

    @Then("the User Clicks on Login Button")
    public void the_user_clicks_on_login_button() {
        getCustomerPage().clickLoginBtn();
    }

    @Then("^Welcome (.*)$")
    public void welcome_your_name_message_is_displayed(String customer) {
        getAccountPage().waitForElements();
        getAccountPage().verifyLoggedInUser(customer);
    }

    @Then("User Clicks on Account {string} on Dropdown List")
    public void userClicksOnAccountOnDropdownList(String arg0) {
        getAccountPage().selectAcc(arg0);
    }

    @Then("Selects Account number")
    public void selects_account_number() throws InterruptedException {
        getAccountPage().checkBalance("0");
    }

    @Then("User verifies account balance")
    public void user_verifies_account_balance() {
    }

    @And("User logout")
    public void userLogout() {
        getAccountPage().clickLogoutButton();
    }

    @And("User deposits into accounts")
    public void userDepositsIntoMultpleAccounts(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : rows) {
            String accountNumber = row.get("AccountNumber");
            String depositAmount = row.get("DepositAmount");
            //select account number
            getAccountPage().selectAcc(accountNumber);
            getAccountPage().click_depositButton();

            //deposit amount
            getAccountPage().checkBalance("0", depositAmount);
            getAccountPage().click_finalDepositButton();
        }
    }

    @And("User clicks the withdrawal Button")
    public void userClicksTheWithdrawalButton() {
        getAccountPage().clickWithdrawalButton();
    }

    @And("User enters withdrawal amount")
    public void userEntersWithdrawalAmount(DataTable data) {
        try {
            List<Map<String, String>> rows = data.asMaps(String.class, String.class);

            for (Map<String, String> row : rows) {
                String withdrawalAmount = row.get("WithdrawalAmount");
                getAccountPage().performWithdrawal(withdrawalAmount);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @And("User clicks final withdrawal button")
    public void userClicksFinalWithdrawalButton() {
        getAccountPage().clickPerformWithdrawButton();
    }

    @Then("Validate that deposit appears under the transaction page")
    public void validateThatDepositAppearsUnderTheTransactionPage() {
        getAccountPage().openTransactions();
        getAccountPage().clickBackBtn();
    }

    @Then("Validate that withdrawal appears under the transaction page")
    public void validateThatWithdrawalAppearsUnderTheTransactionPage() {
        getAccountPage().openTransactions();
        getAccountPage().clickBackBtn();
        getAccountPage().validateTransactions("0");
    }

    @After
    public void addScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
        }
    }

    @After
    public void shutdownBrowser() {
        BrowserFactory.closeBrowser();
    }
}
