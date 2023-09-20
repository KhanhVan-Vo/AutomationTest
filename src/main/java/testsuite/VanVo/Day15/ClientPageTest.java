package testsuite.VanVo.Day15;

import AutomationConstant.AccountConstant;
import AutomationPagelocator.DashboardPage;
import common.CommonBase;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testsuite.VanVo.Day14.LoginPageFactory_Day14;

import static org.testng.Assert.assertTrue;

public class ClientPageTest extends CommonBase {
    @BeforeTest
    @Parameters("testNgBrowser")
    public void initDriver(@Optional("chrome") String browser) {
        setupDriver(browser);
        driver.get(AccountConstant.webURL);
    }

//    public void openApplication() {
//        driver = initChromeDriver();
//    }

    @Test
    public void addClientSuccessfully() throws InterruptedException {
        LoginPageFactory_Day14 login = new LoginPageFactory_Day14(driver);
        login.LoginFunction("admin@demo.com", "riseDemo");
        DashboardPage dashboard = new DashboardPage(driver);
        pause(4000);
        WebElement expected = driver.findElement(dashboard.dashboardText);
        assertTrue(expected.isDisplayed());
        ClientPageFactory client = new ClientPageFactory(driver);
        client.AddClient("Class 28.6 test");
    }
}
