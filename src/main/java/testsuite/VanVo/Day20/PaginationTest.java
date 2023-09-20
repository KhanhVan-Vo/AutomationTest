package testsuite.VanVo.Day20;

import AutomationConstant.AccountConstant;
import AutomationPagelocator.LabelFactory;
import AutomationPagelocator.LoginPage;
import common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.testng.Assert.assertEquals;

public class PaginationTest extends CommonBase {
    // 1. Lấy tháng tiếp theo từ tháng hiện tại theo định dạng "October 2023"
    public String getNext1MonthFromCurrentMonth1() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("MMMM yyyy");
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
        String currentMonth = df.format(calendar.getTime());
        System.out.println("current Month: " + currentMonth);

        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
        String nextMonth = df.format(calendar.getTime());
        System.out.println("NextMonth from curent month: " + nextMonth);
        return nextMonth;
    }

    //2. Lấy tháng hiện tại theo định dạng "September 2023"
    public String getCurrentMonth() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("MMMM yyyy");
        String currentMonth = df.format(calendar.getTime());
        System.out.println("currentMonthAsString: " + currentMonth);
        return currentMonth;
    }

    // 1. Lấy tháng trước từ tháng hiện tại theo định dạng "October 2023"
    public String getPrevious1MonthFromCurrentMonth1() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("MMMM yyyy");
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
        String currentMonth = df.format(calendar.getTime());
        System.out.println("current Month: " + currentMonth);

        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
        String nextMonth = df.format(calendar.getTime());
        System.out.println("NextMonth from curent month: " + nextMonth);
        return nextMonth;
    }

    @BeforeTest
    public void openPage() {
        driver = initChromeDriver(AccountConstant.webURL);
        LoginPage login = new LoginPage(driver);
        login.LoginFunction("admin@demo.com", "riseDemo");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[text()='Events']")));
    }

    @Test(priority = 1)
    public void NextPage() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[@class='fc-next-button fc-button fc-button-primary']")));
        click(By.xpath("//h2[@class='fc-toolbar-title']"));
        WebElement element = driver.findElement(By.xpath("//h2[@class='fc-toolbar-title']"));
        String actualtext = element.getText();
        System.out.println("Tháng tiếp theo là: " + actualtext);
        assertEquals(getNext1MonthFromCurrentMonth1(), actualtext);
    }

    @Test(priority = 2)
    public void PreviousPage() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[@class='fc-prev-button fc-button fc-button-primary']")));
        click(By.xpath("//h2[@class='fc-toolbar-title']"));
        WebElement element = driver.findElement(By.xpath("//h2[@class='fc-toolbar-title']"));
        String actualText = element.getText();
        System.out.println("Tháng trước là: " + actualText);
        assertEquals(getPrevious1MonthFromCurrentMonth1(), actualText);
    }
}
