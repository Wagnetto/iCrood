import java.util.*;

//Classe dos estabelecimentos comerciais
public class Restaurante {
    // Atributos
    private String nomeRestaurante;
    private int idRestaurante;
    private Vendor proprietario;
    private String endereco;
    private String cep;
    private List<Produto> cardapio;

    // Construtor
    public Restaurante(String nomeRestaurante, int idRestaurante, String endereco, String cep, List<Produto> cardapio) {
        this.nomeRestaurante = nomeRestaurante;
        this.idRestaurante = idRestaurante;
        this.endereco = endereco;
        this.cep = cep;
        this.cardapio = cardapio;
    }

    // Getters e Setters

    public String getNomeRestaurante() {
        return nomeRestaurante;
    }

    public void setNomeRestaurante(String nomeRestaurante) {
        this.nomeRestaurante = nomeRestaurante;
    }

    public int getIdRestaurante() {
        return idRestaurante;
    }

    public Vendor getProprietario() {
        return proprietario;
    }

    public void setProprietario(Vendor proprietario) {
        this.proprietario = proprietario;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public List<Produto> getCardapio() {
        return cardapio;
    }

    public void setCardapio(List<Produto> cardapio) {
        this.cardapio = cardapio;
    }

    // Métodos
    public void AdicionarProdutoLista(String nomeProduto, String descricaoProduto, double valor) {
        // quando chamado, gera ID guarda em IDproduto
        UUID idProduto = UUID.randomUUID();
        // cria um objeto produto com os atributos de produto
        Produto produto = new Produto(idProduto, nomeProduto, descricaoProduto, valor);
        // adiciona à lista do restaurante Cardápio, a pergunta é como editar isso depois e onde vai ficar esse código
        cardapio.add(produto);
    }

    public void PedeItensAdicionarLista(int quantidadeItens) {
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < quantidadeItens; i++) {
            System.out.println("\nEntre com o nome do produto: ");
            String nomeProduto = scan.nextLine();

            System.out.println("Entre com a descrição do produto: ");
            String descricaoProduto = scan.nextLine();

            System.out.println("Entre com o valor do produto: ");
            double valorProduto = scan.nextDouble();

            scan.nextLine(); // Limpa o buffer do scanner

            AdicionarProdutoLista(nomeProduto, descricaoProduto, valorProduto);
        }
    }


    public void EditarListaRestaurante(int indexLista, String novoNomeProduto, String novaDescricaoProduto, double novoValor) {
        if (indexLista >= 0 && indexLista < cardapio.size()) {
            Produto produto = cardapio.get(indexLista);
            produto.setNomeProduto(novoNomeProduto);
            produto.setDescricaoProduto(novaDescricaoProduto);
            produto.setValor(novoValor);
            System.out.println("Produto atualizado com sucesso.");
        } else {
            System.out.println("Índice inválido. O produto não foi atualizado.");
        }
    }

    public void mostraCardapio() {
        for (Produto produto : cardapio) {
            System.out.println(produto.toString());
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Nome do Restaurante: ").append(nomeRestaurante).append("\n");
        sb.append("ID: ").append(idRestaurante).append("\n");
        sb.append("Endereço: ").append(endereco).append("\n");
        sb.append("CEP: ").append(cep).append("\n");
        sb.append("Propietário: ").append(proprietario.getNome()).append("\n");
        sb.append("Cardápio do restaurante ").append(nomeRestaurante).append(": ").append(cardapio);
        return sb.toString();
    }
}
