package testsuite.VanVo.Day16;

import common.CommonBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AlertBasic extends CommonBase {
    @BeforeTest
    public void openPage() {
        driver = initChromeDriver();
    }

    @Test
    public void TestAlert01() {
        driver.findElement(By.name("cusid")).sendKeys("123456");
        driver.findElement(By.name("submit")).submit();
        //Khai bao chuyen huong den Alert voi doi tuong
        Alert alert = driver.switchTo().alert();
        //Get messenger tren alert
        String alertMessenger = driver.switchTo().alert().getText();
        //Hien ra tren console noi dung cua alert messenger
        System.out.println(alertMessenger);
        assertEquals(alertMessenger, "Do you realy want to delete this customer?");
        pause(2000);
        //accept() = nhan button OK
        //driver.switchTo().alert().getText();
        //Cach 1:
        String actualMessenger = driver.switchTo().alert().getText();
        assertEquals(actualMessenger, "Customer successfully delete!");
        alert.accept();
        //Cach 2: Nhan Cancel button
        //alert.dismiss();
        pause(2000);
    }

    @AfterTest
    public void closePage() {
        quitDriver(driver);
    }
}
