package testsuite.VanVo.Day14;

import AutomationConstant.AccountConstant;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class signupTest extends automation.common.CommonBase {
    @BeforeTest
    public void openApplication() {
        driver = initChromeDriver((AccountConstant.WebURL));
    }

    @Test
    public void signupSuccessfully() {
        SignupFactory factory = new SignupFactory(driver);
        factory.SignupFunction("Demoname", "Demoemail1122432@gmail.com", "123456@", "0912344484");
        pause(4000);
        danhSachKhoaHoc dskh = new danhSachKhoaHoc();
        WebElement expected = driver.findElement(dskh.textThongBao);
        assertTrue(expected.isDisplayed());
    }
}
