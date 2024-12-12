package cucumber.Tasks;

import cucumber.Page.HomePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeTask {
    private WebDriver driver;
    private HomePage homePage;

    public HomeTask(WebDriver driver) {
        this.driver = driver;
        this.homePage = new HomePage(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void clicarOpcaoMonitores(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement monitoresElement = wait.until(ExpectedConditions.visibilityOf(homePage.monitores));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", monitoresElement);
        wait.until(ExpectedConditions.elementToBeClickable(monitoresElement));
        monitoresElement.click();
    }

    public void clicarMonitorEscolhido(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement monitoresElement = wait.until(ExpectedConditions.visibilityOf(homePage.monitorEscolhido));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", monitoresElement);
        wait.until(ExpectedConditions.elementToBeClickable(monitoresElement));
        monitoresElement.click();
    }
}
