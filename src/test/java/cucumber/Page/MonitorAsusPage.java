package cucumber.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MonitorAsusPage {

    private WebDriver driver;

    public MonitorAsusPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Add to cart']")
    public WebElement addCarrinho;

    @FindBy(id = "cartur")
    public WebElement clicarCarrinho;

}
