package cucumber.Tasks;

import cucumber.Page.CartPage;
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
    private WebDriverWait wait;
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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void finalizarCompra() {
        clicarElemento(cartPage.finalizarCompra);
    }

    public void preencherDadosCompra() {
        preencherCampo(cartPage.inputNome, nome);
        preencherCampo(cartPage.inputPais, pais);
        preencherCampo(cartPage.inputCidade, cidade);
        preencherCampo(cartPage.inputCredirCard, cartao);
        preencherCampo(cartPage.inputMes, mes);
        preencherCampo(cartPage.inputAno, ano);
        clicarElemento(cartPage.clicarPurchase);
    }

    public void validarInfosCompra() {
        WebElement infosConfirmacaoCompraElement = esperarVisibilidadeEProntoParaInteracao(cartPage.confirmacaoCompra);
        String textoSweetAlert = infosConfirmacaoCompraElement.getText();
        Assert.assertTrue("O texto do popup não contém o número do cartão.", textoSweetAlert.contains(cartao));
        Assert.assertTrue("O texto do popup não contém o nome do comprador.", textoSweetAlert.contains(nome));
        Assert.assertTrue("O texto do popup não contém a mensagem de confirmação.", textoSweetAlert.contains(textoConfirmacaoCompra));
    }

    private void preencherCampo(WebElement elemento, String valor) {
        WebElement elementoVisivel = esperarVisibilidadeEProntoParaInteracao(elemento);
        elementoVisivel.sendKeys(valor);
    }

    private void clicarElemento(WebElement elemento) {
        WebElement elementoVisivel = esperarVisibilidadeEProntoParaInteracao(elemento);
        elementoVisivel.click();
    }

    private WebElement esperarVisibilidadeEProntoParaInteracao(WebElement elemento) {
        WebElement elementoVisivel = wait.until(ExpectedConditions.visibilityOf(elemento));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementoVisivel);
        wait.until(ExpectedConditions.elementToBeClickable(elementoVisivel));
        return elementoVisivel;
    }
}
