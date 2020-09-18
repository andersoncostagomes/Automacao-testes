package pageObjects;

import elementMapper.ProductPageElementMapper;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class ProductPage extends ProductPageElementMapper {

    public ProductPage(){
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public String getTextProduct_reference(){
        return product_reference.getText();
    }

    public String getTextOur_price_display(){
        return our_price_display.getText();
    }

    public String getTextShort_description_content(){
        return short_description_content.getText();
    }

    public void clickAdd_to_cart(){
        add_to_cart.click();
    }

    public void clickProceed_to_checkout(){
        proceed_to_checkout.click();
    }


}
