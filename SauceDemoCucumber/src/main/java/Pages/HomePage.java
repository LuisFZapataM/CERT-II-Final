package Pages;

import com.google.common.collect.Ordering;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

    WebDriver driver;

    @FindBy(className = "app_logo")
    WebElement homeTittle;

    @FindBy(className = "product_sort_container")
    WebElement sortComboBox;

    @FindBy(className = "inventory_item_price")
    List<WebElement> products;

    @FindBy(id = "shopping_cart_container")
    WebElement cartIcon;

    @FindBy(className = "shopping_cart_badge")
    WebElement cartCounter;


    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public boolean verifyThatTittleIsDisplayed()
    {
        return homeTittle.isDisplayed();
    }


    public void selectOptionComboBox(String option)
    {
        Select filterSelect = new Select(sortComboBox);
        filterSelect.selectByVisibleText(option);
    }

    public boolean productsOrderInAscendingOrderPrice()
    {
        List<Double> productPrices = new ArrayList<>();

        for(WebElement we : products)
        {
            productPrices.add(Double.parseDouble(we.getText().replace("$", "")));
        }
        return Ordering.natural().isOrdered(productPrices);
    }

    public void clickShoppingCartIcon()
    {
        cartIcon.click();
    }

    public void addProductToCart(String productName)
    {
        String productId = "add-to-cart-"+productName.replace(" ", "-").toLowerCase();
        WebElement productAddToCartButton = driver.findElement(By.id(productId));
        productAddToCartButton.click();
    }

    public boolean checkShoppingCartCounter(Integer count)
    {
        return count.equals(Integer.parseInt(cartCounter.getText()));
    }


    public void removeProductFromCart(String productName)
    {
        String productId = "remove-"+productName.replace(" ", "-").toLowerCase();
        WebElement productAddToCartButton = driver.findElement(By.id(productId));
        productAddToCartButton.click();
    }
}
