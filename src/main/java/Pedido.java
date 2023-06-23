import java.util.List;
import java.util.Scanner;

public class Pedido {

    //Declarando aqui LISTA simples com os possíveis estados pra evitar divergência
    static final String [] statusPossiveis = {"0 - Em produção", "1 - Pronto", "2 - Em trânsito", "3 - Entregue"};

    int idPedido;


    //TODO essa lista deve ser uma lista de objetos produto?
    // ou uma lista dos IDs deles, que apenas apontam para um produto registrado no Banco ?
    private List<Produto> carrinho;


    //TODO VICTOR: como fazer para vincular o id de um restaurante existente a um pedido. SEM o usuário ter qu digitar no construtor?
    int idRestaurante;

    double valorTotalPedido;

    public void setValorTotalPedido(double valorTotalPedido) {
        this.valorTotalPedido = valorTotalPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }

    String statusPedido;

    //generate constructor

    public static Restaurante selecionaRestaurante() {
        System.out.println("Digite o Número do Restaurante");
        Scanner input = new Scanner(System.in);
        int entrada = input.nextInt();

        List<LerDados.Restaurante> restaurantes = LerDados.lerRestaurantesDoArquivo();

        if (entrada >= 1 && entrada <= restaurantes.size()) {
            // Restaurante válido selecionado
            LerDados.Restaurante restauranteSelecionado = restaurantes.get(entrada - 1);
            System.out.println("Restaurante selecionado: " + restauranteSelecionado.getNome());

            restauranteSelecionado.mostraCardapio();
            // todo talvez botar um for aqui e instanciar outros produtos
            System.out.println("Nome do Produto: batata1 | Descricao do Produto: desc | Valor: R$100.0");

            // Retorna o restaurante selecionado

        } else {
            System.out.println("Opção inválida. Tente novamente.");

            // Chamada recursiva para selecionar novamente o restaurante (fallback)
            return selecionaRestaurante();
        }
        return null;
    }

    public double calcularPrecoTotal() {
        double precoTotal = 0.0;

        for (Produto produto : carrinho) {
            precoTotal += produto.getValor();
            setValorTotalPedido(precoTotal);

        }

        return precoTotal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---------------------------------\n");
        sb.append("Seu pedido:\n\n");
        for (Produto produto : carrinho) {
            sb.append(produto.toString()).append("\n");
        }
        sb.append("\nPreço total: R$").append(calcularPrecoTotal());
        return sb.toString();
    }





}
