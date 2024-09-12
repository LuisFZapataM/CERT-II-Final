package StepDefinitions;

import Pages.CheckOutOne;
import Utilities.DriverManagerSingleton;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

import java.util.List;

public class CheckOut1Steps {

    CheckOutOne checkOutOne = new CheckOutOne(DriverManagerSingleton.driver);

    @And("I fill the data form with the values")
    public void fillInfoForm(DataTable clientInfo)
    {

        List<String> data = clientInfo.transpose().asList(String.class);

        if(!data.get(0).equalsIgnoreCase("null"))
            checkOutOne.setName(data.get(0));
        if(!data.get(1).equalsIgnoreCase("null"))
            checkOutOne.setLastName(data.get(1));
        if(!data.get(2).equalsIgnoreCase("null"))
            checkOutOne.setZipCode(data.get(2));

    }

    @And("I click on the continue button")
    public void clickContinueButton()
    {
        checkOutOne.clickContinueButton();
    }

    @And("The error message {string} should be displayed")
    public void CheckErrorMessage(String message)
    {
        checkOutOne.checkErrorMessage(message);
    }

}
