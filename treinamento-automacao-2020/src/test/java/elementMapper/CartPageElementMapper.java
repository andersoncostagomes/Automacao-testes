package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPageElementMapper {
    @FindBy(className = "navigation_page")
    public WebElement navigation_page;

    @FindBy(className = "cart_ref")
    public WebElement cart_ref;

    @FindBy(css = "span#total_price")
    public WebElement total_price;

    @FindBy(css = ".cart_description .product-name")
    public WebElement productNameCart;
}
