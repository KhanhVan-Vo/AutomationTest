package testsuite.VanVo.Day13;

import AutomationConstant.AccountConstant;
import AutomationPagelocator.DashboardPage;
import AutomationPagelocator.LoginPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends automation.common.CommonBase {
    @BeforeTest
    public void openPage() {
        driver = initChromeDriver(AccountConstant.webURL);
    }

    @Test
    public void loginSuccessfully() {
        LoginPage page = new LoginPage(driver);
        page.LoginFunction("admin@demo.com", "riseDemo");
        //Kiem tra ket qua sau khi dang nhap thanh cong
        DashboardPage dashboard = new DashboardPage(driver);
        WebElement expected = driver.findElement(dashboard.dashboardText);
        assertTrue(expected.isDisplayed());
    }

    @Test
    public void loginFail_IncorrectEmail() {
        LoginPage page = new LoginPage(driver);
        page.LoginFunction("admin_invalid@demo.com", "riseDemo");
        //Kiem tra ket qua sau khi dang nhap that bai
        WebElement expected = driver.findElement(page.authenFailText);
        assertTrue(expected.isDisplayed());
    }

    @Test
    public void loginFail_IncorrectPass() {
        LoginPage page = new LoginPage(driver);
        page.LoginFunction("admin@demo.com", "riseDemo_invalid");
        //Kiem tra ket qua sau khi dang nhap that bai
        WebElement expected = driver.findElement(page.authenFailText);
        assertTrue(expected.isDisplayed());
    }

    @Test
    public void loginFail_IncorrectBoth() {
        LoginPage page = new LoginPage(driver);
        page.LoginFunction("admin_invalid@demo.com", "riseDemo_invalid");
        //Kiem tra ket qua sau khi dang nhap that bai
        WebElement expected = driver.findElement(page.authenFailText);
        assertTrue(expected.isDisplayed());
    }
}
