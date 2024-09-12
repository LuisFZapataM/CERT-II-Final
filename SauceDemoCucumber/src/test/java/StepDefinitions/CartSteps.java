package StepDefinitions;

import Pages.CartPage;
import Utilities.DriverManagerSingleton;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class CartSteps {

    CartPage cartPage = new CartPage(DriverManagerSingleton.getDriverManager().driver);

    @And("I click on the checkout button")
    public void clickCheckOutButton()
    {
        cartPage.clickCheckOutButton();
    }

    @Then("The checkout button should be disabled")
    public void checkOutButtonDisabled()
    {
        Assertions.assertFalse(cartPage.checkOutButtonIsEnabled());
    }

}
