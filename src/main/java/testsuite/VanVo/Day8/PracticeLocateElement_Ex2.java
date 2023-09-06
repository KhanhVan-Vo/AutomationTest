package testsuite.VanVo.Day8;

import common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeLocateElement_Ex2 extends CommonBase {
    @BeforeMethod
    public void init() {
        driver = initDriverTest("https://automationfc.github.io/basic-form/index.html");
    }

    @Test
    public void Demo_TestCases() {
        //Name
        WebElement userNameID = driver.findElement(By.id("name"));
        System.out.println(userNameID.toString());
        WebElement name = driver.findElement(By.name("name"));
        System.out.println(name.toString());
        //Address
        WebElement addressID = driver.findElement(By.id("address"));
        System.out.println(addressID.toString());
        WebElement addressName = driver.findElement(By.name("address"));
        System.out.println(addressName.toString());
        //Email
        WebElement emailID = driver.findElement(By.id("email"));
        System.out.println(emailID.toString());
        WebElement emailName = driver.findElement(By.name("email"));
        System.out.println(emailName.toString());
        //Password
        WebElement passlID = driver.findElement(By.id("password"));
        System.out.println(passlID.toString());
        WebElement passName = driver.findElement(By.name("password"));
        System.out.println(passName.toString());
    }
}
