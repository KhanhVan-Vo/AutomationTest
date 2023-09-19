package testsuite.VanVo.Day20;

import AutomationConstant.AccountConstant;
import AutomationPagelocator.LoginPage;
import common.CommonBase;
import org.testng.annotations.BeforeTest;


public class FilterEventLabelTest extends CommonBase {
    @BeforeTest
    public void openPage() {
        driver = initChromeDriver(AccountConstant.webURL);
        LoginPage login = new LoginPage(driver);
        login.LoginFunction("admin@demo.com", "riseDemo");
        //Refresh web
        driver.get("https://accounts.google.com/SignUp");
        driver.navigate().refresh();
    }

}
