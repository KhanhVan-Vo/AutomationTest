package testsuite.VanVo.Day20;

import AutomationConstant.AccountConstant;
import AutomationPagelocator.EventManagementPage;
import AutomationPagelocator.LabelFactory;
import AutomationPagelocator.LoginPage;
import common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class FilterEventLabelTest extends CommonBase {
    @BeforeTest
    public void openPage() {
        driver = initChromeDriver(AccountConstant.webURL);
        LoginPage login = new LoginPage(driver);
        login.LoginFunction("admin@demo.com", "riseDemo");
    }

    @Test
    public void FilterEventLabelOnCurrentMonth() {
        //Add label
        LabelFactory addLabel = new LabelFactory(driver);
        addLabel.addLabelOnlyName("Label test");
        //Add Event
        EventManagementPage addEvent = new EventManagementPage(driver);
        addEvent.addEventSuccessfully_ShareWithAllTeam("Tilte", "Description Test", "20-9-2023", "20-9-2023", "Label test");
        //Refresh web
        driver.get("https://rise.fairsketch.com/events#");
        driver.navigate().refresh();
        pause(10000);
        //Filter label
        FilterEventLabel filterLabel_1 = new FilterEventLabel(driver);
        filterLabel_1.FilterEventLabel("Label test");
        WebElement element = driver.findElement(filterLabel_1.eventOnCurrentMonth);
        String actualText = element.getText();
        assertEquals(actualText, "Title");
    }

    @Test
    public void FilterEventLabelNotOnCurrentMonth() {
        //Add label
        LabelFactory addLabel = new LabelFactory(driver);
        addLabel.addLabelOnlyName("Label test 2");
        FilterEventLabel filterLabel_2 = new FilterEventLabel(driver);
        filterLabel_2.FilterEventLabel("Label test 2");
        //Add Event
        EventManagementPage addEvent = new EventManagementPage(driver);
        addEvent.addEventSuccessfully_ShareWithAllTeam("Tilte 2", "Description Test", "20-10-2023", "20-10-2023", "Label test 2");
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
