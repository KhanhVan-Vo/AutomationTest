package AutomationPagelocator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import AutomationConstant.AccountConstant;
import common.CommonBase;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class EventManagement extends CommonBase {
	@BeforeTest
	public void openPage() {
		driver = initChromeDriver(AccountConstant.webURL);
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("admin@demo.com", "riseDemo");
	}

	@Test
	public void addEventSuccessfully_OnlyMe() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		EventManagementPage eventPage = new EventManagementPage(driver);
		eventPage.addEventSuccessfully_ShareWithOnlyMe("Title Test", "Description Test", "15-09-2023", "16-09-2023", "Ha Noi", "Label test");
		pause(10000);
		eventPage.displayDetail();
		pause(5000);
		WebElement element =  driver.findElement(eventPage.eventTitleDetail);
		String actualText = element.getText();
		assertEquals(actualText, "Title Test");
	}
	
	@Test
	public void addEventSuccessfully_AllTeam() {
		pause(10000);
		EventManagementPage eventPage = new EventManagementPage(driver);
		eventPage.addEventSuccessfully_ShareWithAllTeam("Title Test", "Description Test", "15-09-2023", "16-09-2023");
		pause(10000);
		eventPage.displayDetail();
		pause(5000);
		WebElement element =  driver.findElement(eventPage.eventTitleDetail);
		String actualText = element.getText();
		assertEquals(actualText, "Title Test");
	}
	
	@Test
	public void addEventSuccessfully_SpecificMemeber() {
		pause(10000);
		EventManagementPage eventPage = new EventManagementPage(driver);
		eventPage.addEventSuccessfully_ShareWithSpecificMember("Title Test", "Description Test", "15-09-2023", "16-09-2023");
		pause(10000);
		eventPage.displayDetail();
		pause(5000);
		WebElement element =  driver.findElement(eventPage.eventTitleDetail);
		String actualText = element.getText();
		assertEquals(actualText, "Title Test");
	}
	
	@Test
	public void addEventFailWithEmptyTitle() {
		pause(10000);
		EventManagementPage eventPage = new EventManagementPage(driver);
		eventPage.addEventFailWithEmptyTitle("Description Test", "15-09-2023", "16-09-2023");
		WebElement element =  driver.findElement(eventPage.tittleError);
		String errorTitle = element.getText();
		assertEquals(errorTitle, "This field is required.");
	}
	
	@Test
	public void addEventFailWithEmptyStartDate() {
		pause(10000);
		EventManagementPage eventPage = new EventManagementPage(driver);
		eventPage.addEventFailWithEmptyStartDate("Title Test", "Description Test", "16-09-2023");
		WebElement element =  driver.findElement(eventPage.startDateError);
		String errorStartDate = element.getText();
		assertEquals(errorStartDate, "This field is required.");
	}
	
	@Test
	public void addEventFailWithEndDateSmallThanStartDate() {
		pause(10000);
		EventManagementPage eventPage = new EventManagementPage(driver);
		eventPage.addEventFailWittartDateSmallThanEndDate("Title Test", "Description Test", "17-09-2023", "16-09-2023");
		WebElement element =  driver.findElement(eventPage.endDateError);
		String errorEndDate = element.getText();
		assertEquals(errorEndDate, "End date must be equal or greater than Start date.");
	}
	
	@Test
	public void addEventFailWithEmptyAll() {
		pause(10000);
		EventManagementPage eventPage = new EventManagementPage(driver);
		eventPage.addEventFailWithEmptyAll();
		WebElement element1 =  driver.findElement(eventPage.tittleError);
		String errorTitle = element1.getText();
		assertEquals(errorTitle, "This field is required.");
		WebElement element2 =  driver.findElement(eventPage.startDateError);
		String errorStartDate = element2.getText();
		assertEquals(errorTitle, "This field is required.");
	}
	
	@Test
	public void deleteEvenSuccessfully() {
		pause(10000);
		EventManagementPage eventPage = new EventManagementPage(driver);
		eventPage.deleteEventSuccessfully();
		pause(1000);
		WebElement element =  driver.findElement(eventPage.deleteAlert);
		String deleteAlert = element.getText();
		assertEquals(deleteAlert, "The event has been deleted.");
	}
	
	@Test
	public void editEventSuccessfully() throws InterruptedException {
		EventManagementPage eventPage = new EventManagementPage(driver);
		eventPage.editEventSuccessfully("Title Edited", "Description Edited", "15-09-2023", "16-09-2023");
		eventPage.displayEdited();
		pause(5000);
		WebElement element =  driver.findElement(eventPage.eventTitleDetail);
		String actualText = element.getText();
		assertEquals(actualText, "Title Edited");
	}
	
	@Test
	public void editEventFailWithEmptyTitle() throws InterruptedException {
		EventManagementPage eventPage = new EventManagementPage(driver);
		eventPage.editEventFailWithEmptyTitle("Description Test", "15-09-2023");
		WebElement element =  driver.findElement(eventPage.tittleError);
		String errorTitle = element.getText();
		assertEquals(errorTitle, "This field is required.");
	}
	
	@Test
	public void editEventFailWithEmptyStartDate() throws InterruptedException {
		EventManagementPage eventPage = new EventManagementPage(driver);
		eventPage.editEventFailWithEmptyStartDate("Title Test", "Description Test");
		WebElement element =  driver.findElement(eventPage.startDateError);
		String errorStartDate = element.getText();
		assertEquals(errorStartDate, "This field is required.");
	}

	@Test
	public void editEventFailWithEmptySpecificMember() throws InterruptedException {
		EventManagementPage eventPage = new EventManagementPage(driver);
		eventPage.editEventFailWithEmptySpecificMember("Title Test", "Description Test");
		WebElement element =  driver.findElement(eventPage.specific_memberError);
		String errorSpecificMember = element.getText();
		assertEquals(errorSpecificMember, "This field is required.");
	}
	
	@Test
	public void editEventFailWithEndDateSmallThanStartDate() throws InterruptedException {
		pause(10000);
		EventManagementPage eventPage = new EventManagementPage(driver);
		eventPage.editEventFailWithEndDateSmallThanStartDate("Title Test", "Description Test", "17-09-2023", "16-09-2023");
		WebElement element =  driver.findElement(eventPage.endDateError);
		String errorEndDate = element.getText();
		assertEquals(errorEndDate, "End date must be equal or greater than Start date.");
	}
	
	@Test
	public void editEventFailWithEmptyAll() throws InterruptedException {
		pause(10000);
		EventManagementPage eventPage = new EventManagementPage(driver);
		eventPage.editEventFailWithEmptyAll();
		WebElement element1 =  driver.findElement(eventPage.tittleError);
		String errorTitle = element1.getText();
		assertEquals(errorTitle, "This field is required.");
		WebElement element2 =  driver.findElement(eventPage.startDateError);
		String errorStartDate = element2.getText();
		assertEquals(errorTitle, "This field is required.");
	}
}
