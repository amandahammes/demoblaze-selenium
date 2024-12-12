package cucumber.Tasks;

import cucumber.Page.MonitorAsusPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MonitorAsusTask {
    private WebDriver driver;
    private MonitorAsusPage monitorAsusPage;

    public MonitorAsusTask(WebDriver driver) {
        this.driver = driver;
        this.monitorAsusPage = new MonitorAsusPage(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void adicionarAoCarrinho(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addCarrinho = wait.until(ExpectedConditions.visibilityOf(monitorAsusPage.addCarrinho));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addCarrinho);
        wait.until(ExpectedConditions.elementToBeClickable(addCarrinho));
        addCarrinho.click();
    }

    public void fecharPopUp(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
