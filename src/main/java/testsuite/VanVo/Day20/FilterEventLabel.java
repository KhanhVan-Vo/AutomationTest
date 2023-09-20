package testsuite.VanVo.Day20;

import AutomationPagelocator.DashboardPage;
import common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class FilterEventLabel extends CommonBase {
    private By eventLink = By.xpath("(//span[@class = 'menu-text '])[1]");
    public By filterEventLabel = By.xpath("//*[@id=\"s2id_event-labels-dropdown\"]/a");
    public By selectLabel = By.xpath("//div[@id='select2-result-label-27']");
    public By eventOnCurrentMonth = By.xpath("//td[@data-date='2023-09-20']");
    public By eventOnNextMonth = By.xpath("//td[@data-date='2023-10-20']");
    public By nextButton = By.xpath("//button[@class='fc-next-button fc-button fc-button-primary']");
    public By previousButton = By.xpath("//button[@class='fc-prev-button fc-button fc-button-primary']");
    private WebDriver driver;

    public FilterEventLabel(WebDriver _driver) {
        this.driver = _driver;
    }

    public void FilterEventLabel(String Label) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        js.executeScript(eventLink + ".click()");
        clickJavaScript(eventLink);
        pause(2000);
        type(filterEventLabel, Label);
        pause(5000);
    }
}


