package testsuite.VanVo.Day14;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class editInfoPage {
    private WebDriver driver;
//    @FindBy(xpath = "//*[@id=\"u_0_0_Ub\"]/div/div/div/div/div[1]/div/div[1]/div[3]/div[2]/div/div/svg/path[1]");
//    public WebElement btnCloseiFrame;
    @FindBy(xpath = "//*[@id=\"showsub\"]/a/div/img")
    public WebElement user;
    @FindBy(xpath = "//*[@id=\"subulmenu\"]/li[1]/div[2]/p[3]/a")
    public WebElement editInfoButton;
    @FindBy(xpath = "//*[@id=\"txtpassword\"]")
    public WebElement txtcurrentPassword;
    @FindBy(xpath = "//*[@id=\"txtnewpass\"]")
    public WebElement txtnewPassword;
    @FindBy(xpath = "//*[@id=\"txtrenewpass\"]")
    public WebElement txtconfirmPassword;
    @FindBy(xpath = "//*[@id=\"frmPassword\"]/button")
    public WebElement btnUpdatePass;

    public editInfoPage(WebDriver _driver) {
        this.driver = _driver;
        PageFactory.initElements(driver, this);
    }

    public void editPassword(WebDriver _driver) {
        this.driver = _driver;
        PageFactory.initElements(_driver, this);
    }
    public void editPassword(String currentPassword, String newPassword, String confirmPassword){
        user.click();
        editInfoButton.click();
        txtcurrentPassword.sendKeys(currentPassword);
        txtnewPassword.sendKeys(newPassword);
        txtconfirmPassword.sendKeys(confirmPassword);
        btnUpdatePass.click();
    }
}
