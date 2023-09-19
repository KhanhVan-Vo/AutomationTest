package testsuite.VanVo.Day12;

//import automation.common.CommonBase;
import AutomationConstant.AccountConstant;
import common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day12_Practice extends CommonBase {
    @Test
    public void handCheckbox() {
        driver = initChromeDriver(AccountConstant.webURL);
        WebElement thisCheckbox = driver.findElement(By.xpath("//div//input[@id='isAgeSelected']"));
        boolean check = thisCheckbox.isSelected();
        if (check == false) {
            thisCheckbox.click();
        }
        System.out.println(thisCheckbox.isSelected());
    }

    @Test
    public void isRadioSelected() {
        driver = initChromeDriver(AccountConstant.webURL);
        WebElement checkboxMale = driver.findElement(By.xpath("(//input[@value='Male' and @type='radio'])[1]"));
        boolean isSelected = checkboxMale.isSelected();
        if (isSelected == false) {
            checkboxMale.click();
            System.out.println(isSelected);
        } else {
            WebElement checkboxFemale = driver.findElement(By.xpath("(//input[@value='Female' and @type='radio'])[1]"));
            checkboxFemale.click();
            System.out.println("Female radio button is selected");
        }
        driver.close();
    }

    @Test
    public void selectDropdownlist() {
        driver = initDriverTest("http://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
        Select singleSelect = new Select(driver.findElement(By.id("select-demo")));
        System.out.println(singleSelect.getOptions().size());
        WebElement dropDay = driver.findElement(By.id("select-demo"));
        dropDay.click();
        singleSelect.selectByVisibleText("Monday");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals("Monday", singleSelect.getFirstSelectedOption().getText());
    }

    @Test
    public void multiCheckbox() throws InterruptedException {
        //Cach kiem tra cac checkbox da duoc click hay chua
        //1. Lay het list checkbox
        driver = initChromeDriver(AccountConstant.webURL);
        List<WebElement> listCheckbox = driver.findElements(By.xpath("(//div[@class='panel-body'])[3]//div[@class='checkbox']//input"));
        System.out.println("Tong so luong checkbox: " + listCheckbox.size());
        // 2. Duyet List tren de lay ra tung thang checkbox
        for (
                int i = 0; i < listCheckbox.size(); i++) {
                // Lay ra tung vi tri checkbox theo thu tu bat dau tu 0
                System.out.println("checkbox ở vị trí thứ " + i + " isSelected: " + listCheckbox.get(i).isSelected());
                // Tao bien luu gia tri True False de if else (dat dieu kien)
                boolean isCheckboxSelected = listCheckbox.get(i).isSelected(); // Tra ra True/False
                // 3.1 Cach lay tung item (WebElement) trong List de so sanh
                if (isCheckboxSelected == false) {
                    listCheckbox.get(i).click();
                    pause(4000);
                    System.out.println("Check box ở vị trí thứ " + i + " đã được checked");
            }
        }
        // 3.3 Cach lay ra tung element cu the - dua vao so luong item cua List tren
        System.out.println("--------------");
        // Duyet List tren de lay ra tung thang checkbox
        for (
                int i = 0; i < listCheckbox.size(); i++) {
            // Lay ra Element theo thu tu trong List WebElement da luu de kiem tra tung thang Checkbox
            WebElement itemCheckbox = driver.findElement(
                    By.xpath("((//div[@class='panel-body'])[3]//div[@class='checkbox']//input)[" + (i + 1) + "]"));
            System.out.println(itemCheckbox.isSelected());
        }
        pause(2000);
        driver.close();
    }
}
