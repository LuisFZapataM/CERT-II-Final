package StepDefinitions;

import Pages.LoginPage;
import Utilities.DriverManagerSingleton;
import io.cucumber.java.en.And;

public class LoginSteps {

    LoginPage loginPage = new LoginPage(DriverManagerSingleton.getDriverManager().driver);

    @And("I set the user name text box with {string}")
    public void setUserName(String name)
    {
        loginPage.setUserNameTextBox(name);
    }

    @And("I set the password text box with {string}")
    public void setPassword(String password)
    {
        loginPage.setPasswordTextBox(password);
    }

    @And("I click on the login button")
    public void clickLoginButton()
    {
        loginPage.clickOnLoginButton();
    }



}
