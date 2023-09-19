package AutomationPagelocator;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LabelFactory {
	private By txtNameLabel = By.xpath("//input[@name='title']");
	private By sltRedColor = By.xpath("//div[@class='color-palet']//span[@data-color='#e74c3c']");
	private By sltYelColor = By.xpath("//div[@class='color-palet']//span[@data-color='#f1c40f']");
	private By sltCurrentColor = By.xpath("//input[@id='custom-color']");
	private By lblLabel1 = By.xpath("//div[@id='label-show-area']/descendant::span");
	private By lblLabel2 = By.xpath("//div[@id='label-show-area']/descendant::span[last()-1]");
	private By btnSave = By.xpath("//button[@type='submit']");
	private By btnDelete = By.xpath("//button[@id='label-delete-btn']");
	private By btnCancel = By.xpath("//button[@id='cancel-edit-btn']");
	//private By btnClose = By.xpath("//button[@id='cancel-edit-btn']");
	
	private By txtemail = By.id("email");
	private By txtpassword = By.id("password");
	private By buttonLogin = By.xpath("//button[text()='Sign in']");
		
	private WebDriver driver;

	public LabelFactory(WebDriver _driver) {
		this.driver = _driver;
	}
	
	public void loginPage(String email, String password)
	{
		WebElement txtEmail = driver.findElement(txtemail);
		if (txtEmail.isDisplayed())
		{
			txtEmail.clear();
			txtEmail.sendKeys(email);
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		}
		
		WebElement txtPass = driver.findElement(txtpassword);
		if (txtPass.isDisplayed())
		{
			txtPass.clear();
			txtPass.sendKeys(password);
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		}
		
		WebElement btnLogin = driver.findElement(buttonLogin);
		if (btnLogin.isDisplayed())
		{
			btnLogin.click();
		}
	}
	
	public void addLabelOnlyName(String nameLabel)
	{
		WebElement txtNaLal = driver.findElement(txtNameLabel);
		txtNaLal.clear();
		txtNaLal.sendKeys(nameLabel);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement buttonnSave = driver.findElement(btnSave);
		if (buttonnSave.isDisplayed())
		{
			buttonnSave.click();
		}
	}
	
	
	public void addLabelNameandColor(String nameLabel)
	{
		WebElement selectRed = driver.findElement(sltRedColor);
		if (selectRed.isDisplayed())
		{
			selectRed.click();
		}
		WebElement txtNaLal = driver.findElement(txtNameLabel);
		txtNaLal.clear();
		txtNaLal.sendKeys(nameLabel);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement buttonnSave = driver.findElement(btnSave);
		if (buttonnSave.isDisplayed())
		{
			buttonnSave.click();
		}
	}
	
	public void editLabelOnlyName(String nameLabel)
	{
		WebElement selectLabel = driver.findElement(lblLabel1);
		if (selectLabel.isDisplayed())
		{
			selectLabel.click();
		}
		WebElement txtEditName = driver.findElement(txtNameLabel);
		txtEditName.clear();
		txtEditName.sendKeys(nameLabel);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement buttonnSave = driver.findElement(btnSave);
		if (buttonnSave.isDisplayed())
		{
			buttonnSave.click();
		}
	}
	
	public void editLabelNameandColor(String nameLabel)
	{
		WebElement selectYel = driver.findElement(sltYelColor);
		if (selectYel.isDisplayed())
		{
			selectYel.click();
		}
		WebElement selectLabel = driver.findElement(lblLabel2);
		if (selectLabel.isDisplayed())
		{
			selectLabel.click();
		}
		WebElement txtEditName = driver.findElement(txtNameLabel);
		txtEditName.clear();
		txtEditName.sendKeys(nameLabel);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement buttonnSave = driver.findElement(btnSave);
		if (buttonnSave.isDisplayed())
		{
			buttonnSave.click();
		}
	}
	
	public void deleteLabel()
	{
		WebElement lblDel = driver.findElement(lblLabel1);
		if (lblDel.isDisplayed())
		{
			lblDel.click();
		}
		WebElement buttonDel = driver.findElement(btnDelete);
		if (buttonDel.isDisplayed())
		{
			buttonDel.click();
		}
	}

}
