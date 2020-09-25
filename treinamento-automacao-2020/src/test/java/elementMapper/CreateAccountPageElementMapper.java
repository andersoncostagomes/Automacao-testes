package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPageElementMapper {

    @FindBy(className = "page-heading")
    public WebElement page_heading;

    @FindBy(id = "id_gender1")
    public WebElement gender1;

    @FindBy(id = "customer_firstname")
    public WebElement customer_firstname;

    @FindBy(id = "customer_lastname")
    public WebElement customer_lastname;

    @FindBy(id = "passwd")
    public WebElement passwd;

    @FindBy(id = "days")
    public WebElement selectDay;

    @FindBy(id = "months")
    public WebElement selectMonth;

    @FindBy(id = "years")
    public WebElement selectYear;

    @FindBy(id = "company")
    public WebElement sendCompany;

    @FindBy(id = "address1")
    public WebElement address1;

    @FindBy(id = "city")
    public WebElement toChooseCity;

    @FindBy(id = "id_state")
    public WebElement id_state;

    @FindBy(id = "postcode")
    public WebElement sendPostcode;

    @FindBy(id = "phone_mobile")
    public WebElement phone_mobile;

    @FindBy(id = "submitAccount")
    public WebElement submitAccount;


}
