package testsuite.VanVo.Day20;

import static org.testng.Assert.assertTrue;

import AutomationConstant.AccountConstant;
import AutomationPagelocator.DashboardPage;
import common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import AutomationPagelocator.LabelFactory;

public class manageLables extends CommonBase {
	@BeforeTest
	public void openPage()
	{
		driver = initChromeDriver(AccountConstant.webURL);
	}
	
	@Test (priority =1)
	public void manageLabel()
	{
		//Login
		LabelFactory factory = new LabelFactory(driver);
		factory.loginPage("admin@demo.com", "riseDemo");
		DashboardPage dashboard1 = new DashboardPage(driver);
		WebElement expected1 = driver.findElement(dashboard1.lblDash);
		assertTrue(expected1.isDisplayed());
		
		pause(2000);
		//Add label
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",driver.findElement(By.xpath("//span[text()='Events']")));
		//dashboardPage dashboard2 = new dashboardPage();
		//WebElement expected2 = driver.findElement(dashboard2.lblEvent);
		//assertTrue(expected2.isDisplayed());

		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",driver.findElement(By.xpath("//a[@title='Manage labels']")));
		//click(By.xpath("//a[@title='Manage labels']"));
		
		factory.addLabelOnlyName("test 1");
		String text1 = driver.findElement(By.xpath("//div[@id='label-show-area']/descendant::span")).getText();
		Assert.assertEquals(text1, "test 1");
		
		//close manage label
		click(By.xpath("(//button[normalize-space()='Close'])[1]"));
		pause(2000);
		
		//edit label
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",driver.findElement(By.xpath("//a[@title='Manage labels']")));
		factory.editLabelOnlyName("test 2");
		pause(2000);
		String text2 = driver.findElement(By.xpath("//div[@id='label-show-area']/descendant::span")).getText();
		Assert.assertEquals(text2, "test 2");
		
		//close manage label
		click(By.xpath("(//button[normalize-space()='Close'])[1]"));
		pause(2000);
				
		//delete label
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",driver.findElement(By.xpath("//a[@title='Manage labels']")));
		factory.deleteLabel();
		pause(2000);
		//String text3 = driver.findElement(By.xpath("//div[@id='label-show-area']/descendant::span")).getText();
		//Assert.assertNotEquals(text3, "test 2");
		
		//close manage label
		pause(2000);
		click(By.xpath("(//button[normalize-space()='Close'])[1]"));
		
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}
	

}
