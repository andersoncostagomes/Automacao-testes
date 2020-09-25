package pageObjects;

import elementMapper.MyAccountPageElementMapper;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class MyAccountPage extends MyAccountPageElementMapper {

    public MyAccountPage(){
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public String getTextNavigationPageAccount(){
        return navigationPageAccount.getText();
    }
    public boolean isMyAccountPage(){
        return getTextNavigationPageAccount().equals("My account");
    }

    public String getTextAccountName(){
        return accountName.getText();
    }

    public String getTextInfo_account(){
        return  info_account.getText();
    }

}
