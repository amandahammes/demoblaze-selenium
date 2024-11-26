package cucumber.Tasks;

import cucumber.Page.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomeTask extends HomePage {
    private WebDriver driver;

    public HomeTask(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void clicarOpcaoMonitores(){
        monitores.click();
    }
}
