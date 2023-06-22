import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cadastro cadastro = new Cadastro();
        Scanner input = new Scanner(System.in);
        Fluxo fluxo = new Fluxo();
        MenuPedido menu = new MenuPedido();

        // TODO instancia entidades para testar
        // TODO fim de instancia



        // perguntar ja tem cadastro?
        menu.exibirRestaurantes();
        LerDados.lerRestaurantesDoArquivo();
//        fluxo.jaTemCadastro();
        fluxo.exibirFluxo();

    }
}
