import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Cadastro cadastro = new Cadastro();
        Scanner input = new Scanner(System.in);

        Fluxo fluxo = new Fluxo();

        // perguntar ja tem cadastro?
        fluxo.exibeTelaInicial();

        fluxo.exibirFluxo();


    }
}