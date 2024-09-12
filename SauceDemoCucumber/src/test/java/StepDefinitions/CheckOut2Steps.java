package StepDefinitions;

import Pages.CheckOutTwo;
import Utilities.DriverManagerSingleton;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class CheckOut2Steps {

    CheckOutTwo checkOutTwo = new CheckOutTwo(DriverManagerSingleton.getDriverManager().driver);



    @Then("The sum of the products should be correct")
    public void verifyProductsSum()
    {
        Assertions.assertTrue(checkOutTwo.checkProductPriceSum());
    }

}
