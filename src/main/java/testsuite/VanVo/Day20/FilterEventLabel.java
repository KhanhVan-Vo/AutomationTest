package testsuite.VanVo.Day20;

import AutomationPagelocator.DashboardPage;
import common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class FilterEventLabel extends CommonBase {
    private By eventLink = By.xpath("(//span[@class = 'menu-text '])[1]");
    public By filterEventLabel = By.xpath("//div[@class='select2-search']/parent::div");
    public By selectLabel = By.xpath("//div[@id='select2-result-label-27']");
    public By eventOnCurrentMonth = By.xpath("//span[@class='clickable p5 w100p inline-block']");
    private WebDriver driver;

    public FilterEventLabel(WebDriver _driver) {
        this.driver = _driver;
    }
    public void FilterEventOnCurrentMonth(){
        JavascriptExecutor js = (JavascriptExecutor) driver;


    }
}


