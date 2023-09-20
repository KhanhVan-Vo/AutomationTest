package testsuite.VanVo.Day20;

import AutomationConstant.AccountConstant;
import AutomationPagelocator.EventManagement;
import AutomationPagelocator.EventManagementPage;
import AutomationPagelocator.LabelFactory;
import common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class FilterEventLabelTest extends CommonBase {
    @BeforeTest
    public void openPage() {
        driver = initChromeDriver(AccountConstant.webURL);
//        LoginPage login = new LoginPage(driver);
//        login.LoginFunction("admin@demo.com", "riseDemo");
        LabelFactory factory = new LabelFactory(driver);
        factory.loginPage("admin@demo.com", "riseDemo");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",driver.findElement(By.xpath("//span[text()='Events']")));
    }

    @Test (priority = 1)
    public void FilterEventLabelOnCurrentMonth() {
        //Add label
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",driver.findElement(By.xpath("//a[@title='Manage labels']")));
        LabelFactory factory = new LabelFactory(driver);
        factory.addLabelOnlyName("Label test");
        pause(2000);
        click(By.xpath("(//button[normalize-space()='Close'])[1]"));
        //Add Event
        pause(2000);
        EventManagementPage eventPage = new EventManagementPage(driver);
        eventPage.addEventSuccessfully_ShareWithOnlyMe("Title Test", "Description Test", "15-09-2023", "16-09-2023", "Ha Noi", "Label test");
        //Refresh web
        driver.get("https://rise.fairsketch.com/events#");
        driver.navigate().refresh();
        pause(10000);
        //Filter label
        FilterEventLabel filterLabel_1 = new FilterEventLabel(driver);
        filterLabel_1.FilterEventLabel("Label test");
        WebElement element = driver.findElement(filterLabel_1.eventOnCurrentMonth);
        String actualText = element.getText();
        assertEquals(actualText, "Title test");
    }

    @Test (priority = 2)
    public void FilterEventLabelNotOnCurrentMonth() {
        //Add Label
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",driver.findElement(By.xpath("//a[@title='Manage labels']")));
        LabelFactory factory = new LabelFactory(driver);
        factory.addLabelOnlyName("Label test 2");
        pause(2000);
        click(By.xpath("(//button[normalize-space()='Close'])[1]"));
        //Add Event
        EventManagementPage addEvent = new EventManagementPage(driver);
        addEvent.addEventSuccessfully_ShareWithOnlyMe("Title Test", "Description Test", "15-09-2023", "16-09-2023", "Ha Noi", "Label test");
        //Refresh web
        driver.get("https://rise.fairsketch.com/events#");
        driver.navigate().refresh();
        pause(10000);
        //Next Page
        click(By.xpath("//button[@class='fc-next-button fc-button fc-button-primary']"));
        //Filter label
        FilterEventLabel filterLabel_1 = new FilterEventLabel(driver);
        filterLabel_1.FilterEventLabel("Label test 2");
        WebElement element = driver.findElement(filterLabel_1.eventOnNextMonth);
        String actualText = element.getText();
        assertEquals(actualText, "Title 2");
    }
}
