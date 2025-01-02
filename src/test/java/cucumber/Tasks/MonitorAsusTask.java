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
    private WebDriverWait wait;

    public MonitorAsusTask(WebDriver driver) {
        this.driver = driver;
        this.monitorAsusPage = new MonitorAsusPage(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void adicionarAoCarrinho(){
        WebElement addCarrinho = wait.until(ExpectedConditions.visibilityOf(monitorAsusPage.addCarrinho));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addCarrinho);
        wait.until(ExpectedConditions.elementToBeClickable(addCarrinho));
        addCarrinho.click();
    }

    public void fecharPopUp(){
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void irParaCarrinho(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement carrinhoElement = wait.until(ExpectedConditions.visibilityOf(monitorAsusPage.clicarCarrinho));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", carrinhoElement);
        wait.until(ExpectedConditions.elementToBeClickable(carrinhoElement));
        carrinhoElement.click();
    }
}
