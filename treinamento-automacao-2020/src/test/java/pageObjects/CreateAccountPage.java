package pageObjects;

        import elementMapper.CreateAccountPageElementMapper;
        import org.openqa.selenium.support.PageFactory;
        import utils.Browser;

public class CreateAccountPage extends CreateAccountPageElementMapper {

    public CreateAccountPage(){
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public String getTextPage_heading(){
        return page_heading.getText();
    }

    public void clickToGender1(){
        gender1.click();
    }

    public void sendKeysCustomer_firstname(String firstname){
        customer_firstname.sendKeys(firstname);
    }

    public void sendKeysCustomer_lastname(String lastName){
        customer_lastname.sendKeys(lastName);
    }

    public void sendKeyspPasswd(String password){
        passwd.sendKeys(password);
    }

    public void sendKeysSelectDay(String day){
        selectDay.sendKeys(day);
    }

    public void sendKeysSelectMonth(String month){
        selectMonth.sendKeys(month);
    }

    public void sendKeysselectYear(String year){
        selectYear.sendKeys(year);
    }

    public void sendKeysCompany(String company){
        sendCompany.sendKeys(company);
    }

    public void sendKeysAddress1(String address){
        address1.sendKeys(address);
    }

    public void sendKeysToChooseCity(String city){
        toChooseCity.sendKeys(city);
    }

    public void sendKeysId_state(String state){
        id_state.sendKeys(state);
    }

    public void sendKeysSendPostcode(String code){
        sendPostcode.sendKeys(code);
    }

    public void sendKeysPhone_mobile(String mobile){
        phone_mobile.sendKeys(mobile);
    }

    public void clickToSubmitAccount(){
        submitAccount.click();
    }

    public void submitFormulary(String firstName, String lastName, String password, String day, String month, String year,
                                String company, String address, String city, String state, String code, String mobile){
        clickToGender1();
        sendKeysCustomer_firstname(firstName);
        sendKeysCustomer_lastname(lastName);
        sendKeyspPasswd(password);
        sendKeysSelectDay(day);
        sendKeysSelectMonth(month);
        sendKeysselectYear(year);
        sendKeysCompany(company);
        sendKeysAddress1(address);
        sendKeysToChooseCity(city);
        sendKeysId_state(state);
        sendKeysSendPostcode(code);
        sendKeysPhone_mobile(mobile);
        clickToSubmitAccount();

    }

}
