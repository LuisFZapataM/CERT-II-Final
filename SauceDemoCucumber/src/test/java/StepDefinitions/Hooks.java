package StepDefinitions;

import Utilities.DriverManagerSingleton;
import io.cucumber.java.After;

public class Hooks {

    @After
    public  void afterScenario()
    {
      DriverManagerSingleton.getDriverManager().driver.quit();
      DriverManagerSingleton.getDriverManager().driver = null;

    }


}
