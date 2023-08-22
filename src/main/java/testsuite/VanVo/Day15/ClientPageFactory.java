package testsuite.VanVo.Day15;

import AutomationPagelocator.DashboardPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientPageFactory {
    private WebDriver driver;
    @FindBy(xpath = "//a[@title='Add client']")
    private WebElement btnAddClient;
    @FindBy(xpath = "//label[text()='Person']")
    private WebElement checkboxPerson;
    @FindBy(xpath = "//input[@name='company_name']")
    private WebElement textCompanyName;
    //gia tri cua tung Owner trong man Add client
    @FindBy(xpath="//div[@id='s2id_created_by']")
    private WebElement checkboxOwner;
    // Giá trị của từng Owner trong màn Add Client
    @FindBy(xpath="(//ul[@role='listbox'])[7]/li[1]")
    private WebElement ownerValue;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement btnSave;
    @FindBy(xpath = "//a[text()='Clients']")
    private WebElement clientTab;
    @FindBy(xpath = "//span[text()='Total clients']")
    private WebElement totalClientCard;
    @FindBy(xpath = "//input[@type='search']")
    private WebElement textboxSearch;
    @FindBy(xpath = "//td[@class=' all']//a[text()=admin@demo.com']")
    private WebElement searchResult;
    public ClientPageFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void AddClient(String companyName) throws InterruptedException{
        DashboardPage dashboard = new DashboardPage(driver);
        driver.findElement(dashboard.clientLink).click();
        btnAddClient.click();
        Thread.sleep(4000);
        checkboxPerson.click();
        textCompanyName.sendKeys(companyName);
        checkboxOwner.click();
        ownerValue.click();
//      clientTab.click(); Khong thuc hien duoc, bao loi element intercepted

    }
}
