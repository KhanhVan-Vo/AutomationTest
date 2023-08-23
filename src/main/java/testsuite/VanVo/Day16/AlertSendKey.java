package testsuite.VanVo.Day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AlertSendKey extends automation.common.CommonBase {
    @BeforeTest
    public void openPage(){
        driver = initChromeDriver("https://demo.automationtesting.in/Alerts.html");
    }
    @Test
    public void TestAlert02(){
        driver.findElement(By.xpath("//a[text()='Alert with Textbox ']")).click();
        pause(2000);
        driver.findElement(By.xpath("//button[text()='click the button to demonstrate the prompt box ']")).click();
        //Nhan sendKeys vao o text
        driver.switchTo().alert().sendKeys("Hello world!");
        pause(2000);
        driver.switchTo().alert().accept();
        WebElement element = getElementPresentDOM(By.id("demo1"));
        String actualText = element.getText();
        assertEquals(actualText, "Hello everyone!");
        pause(2000);
    }

    private WebElement getElementPresentDOM(By demo1) {
        return null;
    }

    @AfterTest
    public void closePage(){
        quitDriver(driver);
    }
}
