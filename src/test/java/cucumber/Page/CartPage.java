package cucumber.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ("//button[text()='Place Order']"))
    public WebElement finalizarCompra;

    @FindBy(id="name")
    public WebElement inputNome;

    @FindBy(id="country")
    public WebElement inputPais;

    @FindBy(id="city")
    public WebElement inputCidade;

    @FindBy(id="card")
    public WebElement inputCredirCard;

    @FindBy(id="month")
    public WebElement inputMes;

    @FindBy(id="year")
    public WebElement inputAno;

    @FindBy(xpath = ("//button[text()='Purchase']"))
    public WebElement clicarPurchase;

    @FindBy(id = "totalm")
    public WebElement valorTotal;

    @FindBy(xpath = ".lead.text-muted")
    public WebElement infosCompra;

    @FindBy(className = "sweet-alert")
    public WebElement confirmacaoCompra;
}
