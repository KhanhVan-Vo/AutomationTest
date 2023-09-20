package AutomationPagelocator;

import common.CommonBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

//import com.datatorrent.lib.appdata.schemas.DimensionalConfigurationSchema.Key;
//
//import automation.common.CommonBase;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Keys;

public class EventManagementPage extends CommonBase {
	private By eventLink = By.xpath("(//span[@class = 'menu-text '])[2]");
	public By event = By.xpath("//span[contains(text(),'Title Test')]");
	public By eventEdited = By.xpath("//span[contains(text(),'Title Edited')]");
	// private By event = By.xpath("(//span[@class = 'clickable p5 w100p
	// inline-block'])[5]");
	private By addEventButton = By.xpath("//a[@class = 'btn btn-default add-btn']");
	private By editEventButton = By.xpath("//a[@title = 'Edit event']");
	private By deleteEventButton = By.xpath("//a[@id = 'delete_event']");
	private By eventTitle = By.xpath("//input[@name = 'title']");
	private By eventDescription = By.xpath("//textarea[@name = 'description' ]");
	private By startDate = By.xpath("//input[@name = 'start_date']");
	private By startTime = By.xpath("//input[@name = 'start_time']");
	private By endDate = By.xpath("//input[@name = 'end_date']");
	private By endTime = By.xpath("//input[@name = 'end_time']");
	private By location = By.xpath("//input[@name = 'location']");
	private By label = By.xpath("//input[@id = 's2id_autogen15']");
	private By cilentDrop = By.id("(//span[@class = 'select2-chosen'])[2]");
	private By onlyMeRadio = By.xpath("//input[@id = 'only_me']");
	private By allTeamRadio = By.xpath("//input[@id = 'share_with_all']");
	private By specificMemeberRadio = By.xpath("//input[@id = 'share_with_specific_radio_button']");
	private By repeatCheckbox = By.xpath("//input[@name = 'recurring']");
	private By repeatEvery = By.xpath("//input[@name = 'repeat_every']");
	private By repeatType = By.xpath("//div[@id = 's2id_repeat_type']");
	private By noOfCycle = By.xpath("//input[@id = 'no_of_cycles']");
	private By saveButton = By.xpath("//button[@class = 'btn btn-primary']");
	private By closeButton = By.xpath("(//button[@class = 'btn btn-default'])[1]");
	public By eventDescripDetail = By.xpath("//blockquote[@class = 'font-14 text-justify']");
	public By eventTitleDetail = By.xpath("//h4[@class = 'mt0 float-start']");
	public By tittleError = By.xpath("//span[@id = 'title-error']");
	public By startDateError = By.xpath("//span[@id = 'start_date-error']");
	public By endDateError = By.xpath("//span[@id = 'end_date-error']");
	public By specific_memberError = By.xpath("//span[@id = 'share_with_specific-error']");
	private By specificMemeberTxt = By.xpath("//input[@id = 's2id_autogen5']");
	private By yesButton = By.xpath("//button[@class = 'btn btn-danger btn-sm w100p confirmation-confirm-button']");
	public By deleteAlert = By.xpath("//div[contains(@class, 'app-alert-message')]");

	private WebDriver driver;

	public EventManagementPage(WebDriver _driver) {
		this.driver = _driver;
	}

	public void addEventSuccessfully_ShareWithOnlyMe(String Title, String Description, String StartDate, String EndDate, String Location, String Label) {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		clickJavaScript(eventLink);
		click(addEventButton);
		type(eventTitle, Title);
		pause(1000);
		type(eventDescription, Description);
		type(startDate, StartDate);
		type(endDate, EndDate);
		type(location, Location);
		type(label, Label);
		//type(cilentDrop, Client);
		//driver.findElement(cilentDrop).sendKeys(Keys.TAB);
		click(saveButton);
	}

	public void addEventSuccessfully_ShareWithAllTeam(String Title, String Description, String StartDate, String EndDate) {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		clickJavaScript(eventLink);
		click(addEventButton);
		type(eventTitle, Title);
		type(eventDescription, Description);
		type(startDate, StartDate);
		//type(startTime, "8:00");
		type(endDate, EndDate);
		//type(endTime, "10:00");
		type(location, "Ha Noi");
		clickJavaScript(allTeamRadio);
		click(saveButton);
	}

	public void addEventSuccessfully_ShareWithSpecificMember(String Title, String Description, String StartDate, String EndDate) {
		clickJavaScript(eventLink);
		click(addEventButton);
		type(eventTitle, Title);
		type(eventDescription, Description);
		type(startDate, StartDate);
		type(endDate, EndDate);
		type(location, "Ha Noi");
		click(specificMemeberRadio);
		type(specificMemeberTxt, "Sara Ann");
		driver.findElement(specificMemeberTxt).sendKeys(Keys.TAB);
		click(saveButton);
	}

	public void addEventFailWithEmptyTitle(String Description, String StartDate, String EndDate) {
		clickJavaScript(eventLink);
		click(addEventButton);
		type(eventDescription, Description);
		type(startDate, StartDate);
		type(endDate, EndDate);
		type(location, "Ha Noi");
		click(saveButton);
	}

	public void addEventFailWithEmptyStartDate(String Title, String Description, String EndDate) {
		clickJavaScript(eventLink);
		click(addEventButton);
		type(eventTitle, Title);
		type(eventDescription, Description);
		type(endDate, EndDate);
		type(location, "Ha Noi");
		click(saveButton);
	}
	
	public void addEventFailWittartDateSmallThanEndDate(String Title, String Description,String StartDate, String EndDate) {
		clickJavaScript(eventLink);
		click(addEventButton);
		type(eventTitle, Title);
		type(eventDescription, Description);
		type(startDate, StartDate);
		type(endDate, EndDate);
		type(location, "Ha Noi");
		click(saveButton);
	}
	
	public void addEventFailWithEmptyAll() {
		clickJavaScript(eventLink);
		click(addEventButton);
		click(saveButton);
	}

	public void displayDetail() {
		click(event);
	}

	public void displayEdited() {
		click(eventEdited);
	}
	
	public void deleteEventSuccessfully() {
		clickJavaScript(eventLink);
		click(event);
		click(deleteEventButton);
		click(yesButton);
	}
	
	public void editEventSuccessfully(String Title, String Description,String StartDate, String EndDate) throws InterruptedException {
		clickJavaScript(eventLink);
		click(event);
		click(editEventButton);
		Thread.sleep(4000);
		WebElement title = driver.findElement(eventTitle);
		if (title.isDisplayed()) {
			title.clear();
			type(eventTitle, Title);
		}
		WebElement descrip = driver.findElement(eventDescription);
		if (descrip.isDisplayed()) {
			descrip.clear();
			type(eventDescription, Description);
		}
		WebElement startdate = driver.findElement(startDate);
		if (startdate.isDisplayed()) {
			startdate.clear();
			type(startDate, StartDate);
		}
		WebElement enddate = driver.findElement(endDate);
		if (enddate.isDisplayed()) {
			enddate.clear();
			type(endDate, EndDate);
		}
		click(saveButton);
	}

	public void editEventFailWithEmptyTitle(String Description,String StartDate) throws InterruptedException {
		clickJavaScript(eventLink);
		click(event);
		click(editEventButton);
		Thread.sleep(4000);
		WebElement title = driver.findElement(eventTitle);
		if (title.isDisplayed()) {
			title.clear();
		}
		WebElement descrip = driver.findElement(eventDescription);
		if (descrip.isDisplayed()) {
			descrip.clear();
			type(eventDescription, Description);
		}
		WebElement startdate = driver.findElement(startDate);
		if (startdate.isDisplayed()) {
			startdate.clear();
			type(startDate, StartDate);
		}
		click(saveButton);
	}
	
	public void editEventFailWithEmptyStartDate(String Title, String Description) throws InterruptedException {
		clickJavaScript(eventLink);
		click(event);
		click(editEventButton);
		Thread.sleep(4000);
		WebElement title = driver.findElement(eventTitle);
		if (title.isDisplayed()) {
			title.clear();
			type(eventTitle, Title);
		}
		WebElement descrip = driver.findElement(eventDescription);
		if (descrip.isDisplayed()) {
			descrip.clear();
			type(eventDescription, Description);
		}
		WebElement startdate = driver.findElement(startDate);
		startdate.clear();
		click(saveButton);
	}
	
	public void editEventFailWithEmptySpecificMember(String Title, String Description) throws InterruptedException {
		clickJavaScript(eventLink);
		click(event);
		click(editEventButton);
		Thread.sleep(4000);
		WebElement title = driver.findElement(eventTitle);
		if (title.isDisplayed()) {
			title.clear();
			type(eventTitle, Title);
		}
		WebElement descrip = driver.findElement(eventDescription);
		if (descrip.isDisplayed()) {
			descrip.clear();
			type(eventDescription, Description);
		}
		click(specificMemeberRadio);
		WebElement specificTxt = driver.findElement(specificMemeberTxt);
		if (descrip.isDisplayed()) {
			descrip.clear();
		}
		click(saveButton);
	}
	
	public void editEventFailWithEndDateSmallThanStartDate(String Title, String Description, String StartDate, String EndDate) throws InterruptedException {

		clickJavaScript(eventLink);
		click(event);
		click(editEventButton);
		Thread.sleep(4000);
		WebElement title = driver.findElement(eventTitle);
		if (title.isDisplayed()) {
			title.clear();
			type(eventTitle, Title);
		}
		WebElement descrip = driver.findElement(eventDescription);
		if (descrip.isDisplayed()) {
			descrip.clear();
			type(eventDescription, Description);
		}
		WebElement startdate = driver.findElement(startDate);
		if (startdate.isDisplayed()) {
			startdate.clear();
			type(startDate, StartDate);
		}
		WebElement enddate = driver.findElement(endDate);
		if (enddate.isDisplayed()) {
			enddate.clear();
			type(endDate, EndDate);
		}
		click(saveButton);
	}
	
	public void editEventFailWithEmptyAll() throws InterruptedException {
		clickJavaScript(eventLink);
		click(event);
		click(editEventButton);
		Thread.sleep(4000);
		WebElement title = driver.findElement(eventTitle);
		if (title.isDisplayed()) {
			title.clear();
		}
		WebElement descrip = driver.findElement(eventDescription);
		if (descrip.isDisplayed()) {
			descrip.clear();
		}
		WebElement startdate = driver.findElement(startDate);
		if (startdate.isDisplayed()) {
			startdate.clear();
		}
		WebElement enddate = driver.findElement(endDate);
		if (enddate.isDisplayed()) {
			enddate.clear();
		}
		click(saveButton);
	}
}
