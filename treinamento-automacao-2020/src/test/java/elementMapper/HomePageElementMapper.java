package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageElementMapper {

    @FindBy(className = "login")
    public WebElement login;

    //@FindBy(id = "search_query_top")
    public WebElement search_query_top;

    @FindBy(css = "button.btn.btn-default.button-search")
    public WebElement submit_search;
}
