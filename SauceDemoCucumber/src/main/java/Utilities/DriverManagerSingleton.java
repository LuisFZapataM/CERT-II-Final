package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManagerSingleton {


    private static DriverManagerSingleton singleton;

    public static WebDriver driver;

    private DriverManagerSingleton()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        driver = new ChromeDriver(option);
    }


    public static DriverManagerSingleton getDriverManager()
    {
        if(driver == null)
            singleton = new DriverManagerSingleton();
        return singleton;
    }


}
