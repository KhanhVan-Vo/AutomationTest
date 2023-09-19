package testsuite.VanVo.Day14;

import AutomationConstant.AccountConstant;
import common.CommonBase;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class signupTest extends CommonBase {
    @BeforeTest
    public void openApplication() {
        driver = initChromeDriver(AccountConstant.webURL);
    }

    @Test
    public void signupSuccessfully() {
        SignupFactory factory = new SignupFactory(driver);
        factory.SignupFunction("Demoname", "Demoemail9273071@gmail.com", "123456@", "0912344484");
        danhSachKhoaHoc dskh = new danhSachKhoaHoc();
        pause(20000);
        WebElement expected = driver.findElement(dskh.textThongBao);
        assertTrue(expected.isDisplayed());
    }
}
