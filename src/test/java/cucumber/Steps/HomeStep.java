package cucumber.Steps;

import cucumber.Tasks.HomeTask;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import static cucumber.TestBase.getDriver;

public class HomeStep {

    HomeTask homeTask = new HomeTask(getDriver());

    @Dado("que clico na opção monitores do menu")
    public void clicoOpcaoMonitores() throws Exception{
        homeTask.clicarOpcaoMonitores();
    }

    @E("seleciono o monitor o que desejo comprar")
    public void selecionoMonitor() throws Exception{
        //homeTask.clicarOpcaoMonitores();
    }

    @Quando("realizar o pagamento")
    public void realizarPagamento(){

    }
    @Entao("as informações da compra deverão aparecer em tela")
    public void validarCompra(){

    }
}
