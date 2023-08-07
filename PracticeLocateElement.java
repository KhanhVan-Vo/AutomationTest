package automation.testsuite.VanVo;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import automation.common.CommonBase;

public class PracticeLocateElement extends CommonBase {
    @BeforeMethod
    public void init() {
        driver = initDriverTest("https://selectorshub.com/xpath-practice-page//");
    }

    @Test
    public void Demo_Testcase() {
        //User Name
        WebElement userEmail = driver.findElement(By.id("userId"));
        System.out.println("user email is " + userEmail.toString());
        WebElement userEmailName = driver.findElement(By.name("email"));
        System.out.println("user email name is " + userEmailName.toString());
//        WebElement className = driver.findElement(By.className("selectors-input jsSelector"));
//        System.out.println("Class name is " + className.toString());
        WebElement tagName = driver.findElement(By.tagName("input"));
        System.out.println("Tag name is " + tagName.toString());
        //Password
        WebElement userPass = driver.findElement(By.id("pass"));
        System.out.println("user pass is " + userPass.toString());
        WebElement userPassName = driver.findElement(By.name("Password"));
        System.out.println("user pass name is " + userPassName.toString());
        //Company
        WebElement userCompanyName = driver.findElement(By.name("company"));
        System.out.println("user company name is " + userCompanyName.toString());
//        WebElement userCompanyClass = driver.findElement(By.className("form-control"));
//        System.out.println("user company class is " + userCompanyClass.toString());
        //Mobile phone
        WebElement userPhoneName = driver.findElement(By.name("mobile number"));
        System.out.println("user phone name is " + userPhoneName.toString());
    }
}
