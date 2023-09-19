package testsuite.VanVo.Day15;

import AutomationConstant.AccountConstant;
import common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandlePickerReadonly extends CommonBase {
    @BeforeTest
    public void openSystemUnderTest(){
        driver = initChromeDriver(AccountConstant.webURL);
    }
    //Choose Date pickerOneway
    @Test
    public void ChooseDatePicker(){
        WebElement datebox = driver.findElement(By.xpath(("(//label[text()='Departing']/following-sibling::div//input[@name='daterange-single'])[1]")));
        //Fill date as dd/mm/yyyy as 25/09/2024
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')", datebox);
        //Press tab to shift focus to time field
        datebox.clear();
        datebox.sendKeys("14092024");
        datebox.sendKeys(Keys.TAB);
    }
}
