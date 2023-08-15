package testsuite.VanVo.Day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day12_Homework extends automation.common.CommonBase {
    @Test
    public void dropdownlist() {
        driver = initDriverTest("http://demo.seleniumeasy.com/input-form-demo.html");
        Select singleSelect = new Select(driver.findElement(By.xpath("//select[@name='state']")));
        System.out.println(singleSelect.getOptions().size());
        WebElement dropState = driver.findElement(By.xpath("//select[@name='state']"));
        dropState.click();
        singleSelect.selectByVisibleText("Arkansas");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals("Arkansas", singleSelect.getFirstSelectedOption().getText());
    }

    @Test
    public void handCheckbox() {
        driver = initChromeDriver("http://demo.seleniumeasy.com/input-form-demo.html");
        WebElement thisCheckbox = driver.findElement(By.xpath("//input[@value=\"yes\"]"));
        boolean check = thisCheckbox.isSelected();
        if (check == false) {
            thisCheckbox.click();
        }
        System.out.println(thisCheckbox.isSelected());
    }
}
