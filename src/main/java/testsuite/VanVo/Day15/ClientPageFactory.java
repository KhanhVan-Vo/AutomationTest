package testsuite.VanVo.Day15;

import AutomationPagelocator.DashboardPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertTrue;

public class ClientPageFactory {
    private WebDriver driver;
    @FindBy(xpath = "//a[@title='Add client']")
    private WebElement btnAddClient;
    @FindBy(xpath = "//label[text()='Person']")
    private WebElement checkboxPerson;
    @FindBy(xpath = "//input[@name='company_name']")
    private WebElement textPersonName;
    //xpath của Owner dropdownlist
    @FindBy(xpath = "//div[@id='s2id_created_by']")
    private WebElement checkboxOwner;
    // Giá trị của từng Owner trong màn Add Client
    @FindBy(xpath = "(//ul[@role='listbox'])[2]/li[1]")
    private WebElement ownerValue1;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement btnSave;
    @FindBy(xpath = "//a[text()='Clients']")
    private WebElement clientTab;
    @FindBy(xpath = "(//input[@placeholder='Search'])[2]")
    private WebElement textboxSearch;
    @FindBy(xpath = "//a[text()='Class28.6 Test']")
    private WebElement searchResult;


    public ClientPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void AddClient(String personName) throws InterruptedException {
        DashboardPage dashboard = new DashboardPage(driver);
        driver.findElement(dashboard.clientLink).click();
        btnAddClient.click();
        Thread.sleep(4000);
        checkboxPerson.click();
        textPersonName.sendKeys(personName);
        checkboxOwner.click();
        Thread.sleep(4000);
        ownerValue1.click();
        Thread.sleep(4000);
        btnSave.click();
        Thread.sleep(10000);
        //clientTab.click(); Khong thuc hien duoc, bao loi element intercepted
        ((JavascriptExecutor) driver).executeAsyncScript("arguments[0].click();", clientTab);
        Thread.sleep(10000);
        textboxSearch.sendKeys(personName);
        Thread.sleep(4000);
        assertTrue(searchResult.isDisplayed());
    }
}
