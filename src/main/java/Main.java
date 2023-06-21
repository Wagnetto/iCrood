import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Cadastro cadastro = new Cadastro();
        Scanner input = new Scanner(System.in);
        Fluxo fluxo = new Fluxo();
        // perguntar ja tem cadastro?
        fluxo.exibeTelaInicial();
//        fluxo.jaTemCadastro();
        fluxo.exibirFluxo();
    }
}
