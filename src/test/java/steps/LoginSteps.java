package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Base;

public class LoginSteps extends Base {

    @Given("the User is on the homepage")
    public void the_user_is_on_the_homepage() {
        login.verifyCustomerLogin();
    }

    @When("the User Clicks the Customer Login Button")
    public void the_user_clicks_the_customer_login_button() {
        login.clickCustomerLoginButton();
    }

    @And("the User Clicks Dropdown List")
    public void the_user_clicks_dropdown_list() {
        customerPage.initialize();
        customerPage.verifyYourNameText();
        customerPage.clickCustomerDropDown();
    }

    @Then("the User Selects A Username")
    public void the_user_selects_your_name() {
        customerPage.selectCustomer(2);
    }

    @Then("the User Clicks on Login Button")
    public void the_user_clicks_on_login_button() {
        customerPage.clickLoginBtn();
    }

    @Then("^Welcome (.*)$")
    public void welcome_your_name_message_is_displayed(String customer) {
        accountPage.waitForElements();
        accountPage.verifyLoggedInUser(customer);
    }

    @Then("User Clicks on Account Dropdown List")
    public void user_clicks_on_account_dropdown_list() {
        accountPage.selectAcc();
    }

    @Then("Selects Account number")
    public void selects_account_number() {
        accountPage.checkBalance("0");
    }

    @Then("User verifies account balance")
    public void user_verifies_account_balance() {
    }
}
