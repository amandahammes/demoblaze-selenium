package cucumber.Tasks;

import cucumber.Page.CartPage;
import cucumber.Page.HomePage;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartTask {

    private WebDriver driver;
    private CartPage cartPage;
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    private String nome = "Julia Fulana";
    private String pais = "Zambia";
    private String cidade = "Ulala";
    private String cartao = "0000";
    private String mes = "03";
    private String ano = "1990";
    private String textoConfirmacaoCompra = "Thank you for your purchase!";

    public CartTask(WebDriver driver) {
        this.driver = driver;
        this.cartPage = new CartPage(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void finalizarCompra(){
        WebElement finalizarCompraElement = wait.until(ExpectedConditions.visibilityOf(cartPage.finalizarCompra));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", finalizarCompraElement);
        wait.until(ExpectedConditions.elementToBeClickable(finalizarCompraElement));
        finalizarCompraElement.click();
    }

    public void preencherDadosCompra(){
        WebElement inputNameElement = wait.until(ExpectedConditions.visibilityOf(cartPage.inputNome));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inputNameElement);
        wait.until(ExpectedConditions.elementToBeClickable(inputNameElement));
        WebElement inputPaisElement = wait.until(ExpectedConditions.visibilityOf(cartPage.inputPais));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inputPaisElement);
        wait.until(ExpectedConditions.elementToBeClickable(inputPaisElement));
        WebElement inputCidadeElement = wait.until(ExpectedConditions.visibilityOf(cartPage.inputCidade));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inputCidadeElement);
        wait.until(ExpectedConditions.elementToBeClickable(inputCidadeElement));
        WebElement inputCartaoElement = wait.until(ExpectedConditions.visibilityOf(cartPage.inputCredirCard));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inputCartaoElement);
        wait.until(ExpectedConditions.elementToBeClickable(inputCartaoElement));
        WebElement inputMesElement = wait.until(ExpectedConditions.visibilityOf(cartPage.inputMes));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inputMesElement);
        wait.until(ExpectedConditions.elementToBeClickable(inputMesElement));
        WebElement inputAnoElement = wait.until(ExpectedConditions.visibilityOf(cartPage.inputAno));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inputAnoElement);
        wait.until(ExpectedConditions.elementToBeClickable(inputAnoElement));
        inputNameElement.sendKeys(nome);
        inputPaisElement.sendKeys(pais);
        inputCidadeElement.sendKeys(cidade);
        inputCartaoElement.sendKeys(cartao);
        inputMesElement.sendKeys(mes);
        inputAnoElement.sendKeys(ano);
        WebElement botaoPurchaseElement = wait.until(ExpectedConditions.visibilityOf(cartPage.clicarPurchase));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", botaoPurchaseElement);
        wait.until(ExpectedConditions.elementToBeClickable(botaoPurchaseElement));
        botaoPurchaseElement.click();
    }

    public void validarInfosCompra(){
        WebElement infosConfirmacaoCompraElement = wait.until(ExpectedConditions.visibilityOf(cartPage.confirmacaoCompra));
        wait.until(ExpectedConditions.elementToBeClickable(infosConfirmacaoCompraElement));
        String textoSweetAlert = infosConfirmacaoCompraElement.getText();
        Assert.assertTrue("O texto do popup não contém o número do cartão.", textoSweetAlert.contains(cartao));
        Assert.assertTrue("O texto do popup não contém o nome do comprador.", textoSweetAlert.contains(nome));
        Assert.assertTrue("O texto do popup não contém o nome do comprador.", textoSweetAlert.contains(textoConfirmacaoCompra));
    }
}
