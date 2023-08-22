package testsuite.VanVo.Day14;

import AutomationConstant.AccountConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class editInfoTest extends automation.common.CommonBase {
    @BeforeTest
    public void signUp(){
        driver = initChromeDriver((AccountConstant.WebURL));
        SignupFactory factory = new SignupFactory(driver);
        factory.SignupFunction("Demoname", "Demoemail927071@gmail.com", "123456@", "0912344484");
    }
    @Test
    public void userInfo(){
        editInfoPage page = new editInfoPage(driver);
        pause(4000);
        //Switch frame de tat man hinh nho neu man hinh nay che mat button chinh sua
//        driver.switchTo().frame(0);
//        WebElement closeiFrame=driver.findElement(page.btnCloseiFrame);
//        pause(4000);
//        driver.switchTo().defaultContent();
        WebElement userAvatar = driver.findElement((By) page.user);
        userAvatar.click();
        pause(1000);
        WebElement btnEditInfo = driver.findElement((By) page.editInfoButton);
        btnEditInfo.click();
    }
    @Test
    public void editPassword(){
        editInfoPage page = new editInfoPage(driver);
        pause(1000);
        page.editPassword("123456@", "shfjhcjks", "shfjhcjks");
        assertTrue(ExpectedConditions.alertIsPresent()!=null);
    }

}
