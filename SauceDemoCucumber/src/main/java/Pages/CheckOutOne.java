package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutOne {


    WebDriver driver;

    @FindBy(id = "first-name")
    WebElement firstNameTextBox;

    @FindBy(id = "last-name")
    WebElement lastNameTextBox;

    @FindBy(id = "postal-code")
    WebElement zipCodeTextBox;

    @FindBy(id = "continue")
    WebElement continueButton;

    @FindBy(css = "h3[data-test='error']")
    WebElement errorLabel;


    public CheckOutOne(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setName(String name)
    {
        firstNameTextBox.sendKeys(name);
    }

    public void setLastName(String lastname)
    {
        lastNameTextBox.sendKeys(lastname);
    }

    public void setZipCode(String zipCode)
    {
        zipCodeTextBox.sendKeys(zipCode);
    }

    public void clickContinueButton()
    {
        continueButton.click();
    }

    public boolean checkErrorMessage(String message)
    {
        return message.equalsIgnoreCase(errorLabel.getText());
    }



}
