package pageObjects;

import elementMapper.CartPageElementMapper;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class CartPage extends CartPageElementMapper {
    public CartPage() {
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public String getTextNavigation_page(){
        return navigation_page.getText();
    }

    public String getTextCart_ref(){
        return cart_ref.getText();
    }

    public String getTextTotal_price(){
        return total_price.getText();
    }
    public boolean isCartPage(){
        return getTextNavigation_page().equals("Your shopping cart");
    }

}
