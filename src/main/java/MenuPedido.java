import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

class MenuPedido {
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

    public void exibirRestaurantes() { // exibe todos os restaurantes puxando de Cadastro
        for (LerDados.Restaurante restaurante : LerDados.lerRestaurantesDoArquivo()) {
            System.out.println(restaurante.getNome());
        }
    }

    public Restaurante selecionaRestaurante() {

        // TODO
        //  estou com problema aonde variavel List<Restaurante> se transforma em List<LerDados.Restaurante>
        //  método exibir Restaurantes funciona mas selecionaRestaurantes não
        //  se conseguir ver classe LerDados e transformar List<LerDados.Restaurante> em List<Restaurante> normal é gege
        Scanner input = new Scanner(System.in);
        int entrada;

        System.out.println("Entre o número do Restaurante: ");
        entrada = input.nextInt();

        List<LerDados.Restaurante> restaurantes = LerDados.lerRestaurantesDoArquivo();

        if (entrada >= 1 && entrada <= restaurantes.size()) {
            // TODO esse método todo funcionava quando eu puxava a lista da Cadastro.getLista
            //  Quando tento puxar do banco a lista List<LerDados.Restaurante> da ruim. a ideia foi trocar toda a lista
            //   para Lerdados.Restaurante e trabalhar com ela mesma
            //   ou tenta mudar o tipo dela pq deve estar sendo transformada em LerDados.java
//            LerDados.Restaurante restauranteSelecionado = restaurantes.get(entrada - 1);
//            System.out.println("Restaurante selecionado: " + restauranteSelecionado.getNome());
//            this.restaurante = restauranteSelecionado;
//            return (LerDados)restauranteSelecionado;
            return null;
        } else {
            System.out.println("Opção inválida. Tente novamente.");
            return selecionaRestaurante();
        }
    }
}