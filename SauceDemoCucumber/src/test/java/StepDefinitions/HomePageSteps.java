package StepDefinitions;

import Pages.HomePage;
import Utilities.DriverManagerSingleton;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class HomePageSteps {

    HomePage homePage = new HomePage(DriverManagerSingleton.getDriverManager().driver);


    @When("The home page should be displayed")
    public void verifyHomeTittle()
    {
        Assertions.assertTrue(homePage.verifyThatTittleIsDisplayed());
    }

    @And("I select the {string} option in the combobox")
    public void selectOptionCombobox(String option)
    {
        homePage.selectOptionComboBox(option);
    }

    @Then("The products should be sorted in ascending order by price")
    public void verifyThatProductsAreInAscendingOrderPrice()
    {
        Assertions.assertTrue(homePage.productsOrderInAscendingOrderPrice());
    }

    @And("I click on the shopping cart icon")
    public void clickOnShoppingCartIcon()
    {
        homePage.clickShoppingCartIcon();
    }


    @And("I click the Add product button in the products")
    public void clickAddProducts(DataTable products)
    {
        List<String> data = products.transpose().asList(String.class);

        for(int i = 0; i < data.size(); i++)
        {
            homePage.addProductToCart(data.get(i));
        }


    }

    @And("The shopping cart counter should be {int}")
    public void checkShoppingCartCounter(Integer count)
    {
        Assertions.assertTrue(homePage.checkShoppingCartCounter(count));
    }

    @And("I click on the remove button of the product {string}")
    public void removeProductFromCart(String name)
    {
        homePage.removeProductFromCart(name);
    }

}
