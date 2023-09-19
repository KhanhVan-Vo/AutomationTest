package testsuite.VanVo.Day13;

import AutomationConstant.AccountConstant;
import AutomationPagelocator.DashboardPage;
import AutomationPagelocator.LoginPage;
import common.CommonBase;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LogoutTest extends CommonBase {
    @BeforeTest
    public void openPage() {
        driver = initChromeDriver(AccountConstant.webURL);
    }

    @Test
    public void Logout() {
        LoginPage page = new LoginPage(driver);
        page.LoginFunction("admin@demo.com", "riseDemo");
        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.LogoutFunction();
        //Kiem tra ket qua sau khi dang xuat
        WebElement expected = driver.findElement(page.buttonLogin);
    }
}

