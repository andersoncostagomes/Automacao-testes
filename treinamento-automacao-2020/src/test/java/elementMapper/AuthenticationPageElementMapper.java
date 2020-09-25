package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPageElementMapper {

    @FindBy(css = "span.navigation_page")
    public WebElement navigationPageName;

    @FindBy(id = "email_create")
    public WebElement email_create;

    @FindBy(id = "SubmitCreate")
    public WebElement submitCreate;

}
