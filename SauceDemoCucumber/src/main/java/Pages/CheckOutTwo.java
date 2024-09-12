package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckOutTwo {


    WebDriver driver;


    @FindBy(className = "inventory_item_price")
    List<WebElement> productsPrice;

    @FindBy(className = "summary_subtotal_label")
    WebElement subTotalLabel;


    public CheckOutTwo(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public boolean checkProductPriceSum()
    {
        double calcProductPrice = 0.0;
        for(WebElement we : productsPrice)
            calcProductPrice += Double.parseDouble(we.getText().replace("$",""));

        calcProductPrice = (double) Math.round(calcProductPrice * 100) / 100;

        String auxsubTotal = subTotalLabel.getText().split(":")[1];

        double labelPrice = Double.parseDouble(auxsubTotal.replace("$",""));
        return calcProductPrice == labelPrice;

    }

}
