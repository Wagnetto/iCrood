import java.time.LocalDateTime;
import java.util.Scanner;

class MenuCliente {
    static Scanner input = new Scanner(System.in);
    private Client cliente;
    private Restaurante restaurante;
    private boolean entregue;
    private Vendor vendor;

    public void realizarEntrega(String cidade) {
        if (cidade.equalsIgnoreCase("Porto Alegre") || cidade.equalsIgnoreCase("POA")) {
            // Lógica para realizar a entrega
            this.entregue = true;
            System.out.println("Pedido realizado com sucesso!");

            // Salvar a entrega no arquivo de dados
            SalvarDados entrega = new SalvarDados(this.cliente.getIdCliente(), this.restaurante.getIdRestaurante(), LocalDateTime.now());
            entrega.salvarEntrega();

        } else {
            System.out.println("Desculpe, as entregas só podem ser feitas em Porto Alegre.");
        }
    }

    public void exibirListaRestaurantes(int i) { // exibe todos os restaurantes puxando de Cadastro
        for (LerDados.Restaurante restaurante : LerDados.lerRestaurantesDoArquivo()) {
            System.out.println(i + ". " + restaurante.getNome());
            i++;
        }
    }

    public void exibirMenuClienteJacadastrado() {
        System.out.println("1. Procurar restaurante e fazer Pedido.\n2. Exibir historico do cliente");
        int opcaoMenu = input.nextInt();
        if(opcaoMenu == 1){
            exibirListaRestaurantes(1);
            Pedido.selecionaRestaurante();
        } else if(opcaoMenu ==2) {
            exibirHistoricoCliente();
        }

    }

    //TODO listar os pedidos de um cliente VICTOR integrar BANCO
    public void exibirHistoricoCliente(){
    }





}
