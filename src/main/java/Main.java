import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Cadastro cadastro = new Cadastro();
        Scanner input = new Scanner(System.in);

        Fluxo fluxo = new Fluxo();
        // TODO começo zona de testes
        LocalDate hoje = LocalDate.now();
        Restaurante restaurante = new Restaurante("Restaurante 1", 988, "endereçoRestaurante", "14231243-76", new ArrayList<>());
        Cadastro.getRestaurantes().add(restaurante);
        Restaurante restaurante2 = new Restaurante("Restaurante 2", 786, "endereçoRestaurante2", "87567568-34", new ArrayList<>());
        Cadastro.getRestaurantes().add(restaurante2);
        Client cliente = new Client("Cliente 1", "123123-45", hoje,"endereçocliente1", "123123-34", "cliente@cliente.com", 0, 789);
        Cadastro.getClientes().add(cliente);
        Client cliente2 = new Client("Cliente 2", "123123-34", hoje, "endereçocliente2", "1231-5466", "cliente2@cliente2.com", 0, 678);
        Cadastro.getClientes().add(cliente2);
        Vendor vendor = new Vendor("Vendor 1", "123123-65", hoje, "endereçovendor1", "3425-6787", "vendor@vendor.com", 0, 456, new ArrayList<>());
        Cadastro.getVendors().add(vendor);
        Vendor vendor2 = new Vendor("Vendor 2", "1231321-67", hoje, "endereço2", "4356-8653", "vendor2@vendor2.com", 0, 123, new ArrayList<>());
        Cadastro.getVendors().add(vendor2);


        // TODO final zona de testes

        // perguntar ja tem cadastro?
        fluxo.exibeTelaInicial();

        fluxo.exibirFluxo(fluxo.jaTemCadastro());


    }
}