package AutomationPagelocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private By txtemail = By.xpath("//input[@id='email']");
    private By txtpassword = By.xpath("//input[@id='password']");
    public By buttonLogin = By.xpath("//button[text()='Sign in']");
    private WebDriver driver;
    public By authenFailText = By.xpath("//div[normalize-space()='Authentication failed!' and @role='alert']");


    public LoginPage(WebDriver _driver) {
        this.driver = _driver;
    }

    public void LoginFunction(String email, String password) {
        WebElement textboxEmail = driver.findElement(txtemail);
        if (textboxEmail.isDisplayed()) {
            textboxEmail.clear();//Do trang login duoc nhap san text nen can phai clear
            textboxEmail.sendKeys((email));
        }
        WebElement textboxPass = driver.findElement(txtpassword);
        if (textboxPass.isDisplayed()) {
            textboxPass.clear();//Do trang login duoc nhap san text nen can phai clear
            textboxPass.sendKeys((password));
        }
        //Nhap chuot vao button login
        //WebElement
        WebElement btnLogin = driver.findElement(buttonLogin);
        if (btnLogin.isDisplayed()) {
            btnLogin.click();
        }
    }

}
