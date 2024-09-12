package StepDefinitions;

import Utilities.DriverManagerSingleton;
import io.cucumber.java.en.Given;


public class CommonSteps {

    @Given("I am in Sauce Demo Web Page")
    public void GoToSauceDemoPage()
    {
        DriverManagerSingleton.getDriverManager();
        DriverManagerSingleton.driver.get("https://www.saucedemo.com/");
        DriverManagerSingleton.driver.manage().window().maximize();
    }

}
