import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaDeRestaurantes.prePopulaListaRestaurantes();
        Cadastro cadastro = new Cadastro();
        Fluxo fluxo = new Fluxo();
        fluxo.exibirFluxo();

    }
}
