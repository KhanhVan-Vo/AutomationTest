package AutomationPagelocator;

import AutomationConstant.AccountConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;

public class DashboardPage extends automation.common.CommonBase {
    public By clientLink = By.xpath("//*[@id=\"sidebar-menu\"]/li[3]/a");

    public By dashboardText = By.xpath("//span[text()='Dashboard']");
    public By buttonUser = By.xpath("//a[@id='user-dropdown']");
    public By buttonLogout = By.xpath("//a[text()=' Sign Out']");
    public DashboardPage(WebDriver _driver) {
        this.driver = _driver;
    }

    public void LogoutFunction() {
        WebElement btnUser = driver.findElement(buttonUser);
        if (btnUser.isDisplayed()) {
            btnUser.click();
        }
        WebElement btnLogout = driver.findElement(buttonLogout);
        if (btnLogout.isDisplayed()) {
            btnLogout.click();
        }
    }
}

