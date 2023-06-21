import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cadastro cadastro = new Cadastro();
        Scanner input = new Scanner(System.in);
        Fluxo fluxo = new Fluxo();

        // TODO instancia entidades para testar
        // TODO fim de instancia

        // perguntar ja tem cadastro?
        fluxo.exibeTelaInicial();
//        fluxo.jaTemCadastro();
        fluxo.exibirFluxo();

    }
}
