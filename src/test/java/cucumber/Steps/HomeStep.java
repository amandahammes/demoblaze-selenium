package cucumber.Steps;

import cucumber.Tasks.HomeTask;
import cucumber.Tasks.MonitorAsusTask;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import static cucumber.TestBase.getDriver;

public class HomeStep {

    private HomeTask homeTask = new HomeTask(getDriver());
    private MonitorAsusTask monitorAsusTask = new MonitorAsusTask(getDriver());

    @Dado("que clico na opção monitores do menu")
    public void clicoOpcaoMonitores() throws Exception{
        homeTask.clicarOpcaoMonitores();
    }

    @E("adiciono o monitor o que desejo comprar ao carrinho")
    public void adicionoMonitor() throws Exception{
        homeTask.clicarMonitorEscolhido();
        monitorAsusTask.adicionarAoCarrinho();
        monitorAsusTask.fecharPopUp();
    }

    @Quando("realizar o pagamento")
    public void realizarPagamento(){

    }
    @Entao("as informações da compra deverão aparecer em tela")
    public void validarCompra(){

    }
}
