package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPageElementMapper {

    @FindBy(className = "navigation_page")
    public WebElement navigationPageAccount;

    @FindBy(css = "a.account span")
    public WebElement accountName;

    @FindBy(className = "info-account")
    public WebElement info_account;
}
