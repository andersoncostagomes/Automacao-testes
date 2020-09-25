package pageObjects;

import elementMapper.AuthenticationPageElementMapper;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

import java.util.SplittableRandom;

public class AuthenticationPage extends AuthenticationPageElementMapper {

    public AuthenticationPage(){
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public String getTextNavigationPageName(){
        return navigationPageName.getText();
    }

    public boolean isAuthenticationPage(){
        return getTextNavigationPageName().equals("Authentication");
    }

    public void sendKeysEmail_create(String email){
        email_create.sendKeys(email);
    }

    public void clickToSubmitCreate(){
        submitCreate.click();
    }

    public void submitEmail(String email){
        sendKeysEmail_create(email);
        clickToSubmitCreate();

    }

}
