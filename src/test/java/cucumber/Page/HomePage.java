package cucumber.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = ("a[onclick=\"byCat('monitor')\"]"))
    public WebElement monitores;

    @FindBy(xpath = "//a[text()='ASUS Full HD']")
    public WebElement monitorEscolhido;

}
