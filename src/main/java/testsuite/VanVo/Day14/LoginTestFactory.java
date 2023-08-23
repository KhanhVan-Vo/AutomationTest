package testsuite.VanVo.Day14;

import AutomationConstant.AccountConstant;
import AutomationPagelocator.DashboardPage;
import AutomationPagelocator.LoginPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTestFactory extends automation.common.CommonBase {
    @BeforeTest
    public void openApplication() {
        driver = initChromeDriver(AccountConstant.webURL);
    }

    @Test
    public void loginSuccessfully() throws InterruptedException {
        LoginPageFactory_Day14 page = new LoginPageFactory_Day14(driver);
        page.LoginFunction("admin@demo.com", "riseDemo");
        pause(4000);
        //Kiem tra ket qua sau khi dang nhap thanh cong
        DashboardPage dashboard = new DashboardPage(driver);
        WebElement expected = driver.findElement(dashboard.dashboardText);
        assertTrue(expected.isDisplayed());

    }

    @AfterTest
    public void quitDriver() {
        driver.close();
    }
}
