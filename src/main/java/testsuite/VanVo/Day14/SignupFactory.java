package testsuite.VanVo.Day14;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupFactory {
    private WebDriver driver;
    @FindBy(id = "txtFirstname")
    private WebElement textboxFirstname;
    @FindBy(id = "txtEmail")
    private WebElement textboxEmail;
    @FindBy(id = "txtCEmail")
    private WebElement txtConfirmEmail;
    @FindBy(id = "txtPassword")
    private WebElement txtPassword;
    @FindBy(id="txtCPassword")
    private WebElement txtConfirmPassword;
    @FindBy(id = "txtPhone")
    private WebElement textPhone;
    @FindBy(xpath = "//*[@id=\"frmLogin\"]/div/div[8]/button")
    private WebElement buttonSignup;

    public SignupFactory(WebDriver _driver) {
        this.driver = _driver;
        PageFactory.initElements(_driver, this);
    }
    public void SignupFunction(String firstName, String email, String pass, String phone){
        textboxFirstname.sendKeys(firstName);
        textboxEmail.sendKeys(email);
        txtConfirmEmail.sendKeys(email);
        txtPassword.sendKeys(pass);
        txtConfirmPassword.sendKeys(pass);
        textPhone.sendKeys(phone);
        buttonSignup.click();
    }

}
