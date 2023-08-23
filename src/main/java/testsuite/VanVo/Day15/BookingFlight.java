package testsuite.VanVo.Day15;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingFlight {
    private WebDriver driver;
    @FindBy(xpath = "//a[@aria-controls=’one-way’]")
    private WebElement checkOneWay;
    @FindBy(xpath = "//div[@id='one-way']//label[text()='Flying from']/following-sibling::div//child::input")
    private WebElement inputFlyingFrom;
    @FindBy(xpath = "//div[@id='one-way']//label[text()='Flying to']/following-sibling::div//child::input")
    private WebElement inputFlyingTo;
    @FindBy(xpath = "//div[@id='one-way']//label[text()='Departing']/following-sibling::div/child::input")
    private WebElement inputDeparting;


}
