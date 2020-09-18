package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPageElementMapper {

    @FindBy(xpath = "//*[@id=\"product_reference\"]/span")
    public WebElement product_reference;

    @FindBy(id = "our_price_display")
    public WebElement our_price_display;

    @FindBy(id = "short_description_content")
    public WebElement short_description_content;

    @FindBy(css = "button.exclusive")
    public WebElement add_to_cart;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
    public WebElement proceed_to_checkout;

}
