import java.util.List;
import java.util.UUID;

//Classe dos estabelecimentos comerciais
public class Restaurante {
    // Atributos
    private String nomeRestaurante;
    private UUID idRestaurante;
    private Vendor proprietario;
    private String endereco;
    private String cep;
    private List<Produto> cardapio;

    // Construtor
    public Restaurante(String nomeRestaurante, UUID idRestaurante, Vendor proprietario, String endereco, String cep, List<Produto> cardapio) {

        this.idRestaurante = idRestaurante;
        this.proprietario = proprietario;
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

    public UUID getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(UUID idRestaurante) {
        this.idRestaurante = idRestaurante;
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
    public void AdicionarProdutoLista(String nomeProduto, String descricaoProduto, double valor){
        // quando chamado, gera ID guarda em IDproduto
        UUID idProduto = UUID.randomUUID();
        // cria um objeto produto com os atributos de produto
        Produto produto = new Produto(idProduto, nomeProduto, descricaoProduto, valor);
        // adiciona à lista do restaurante Cardápio, a pergunta é como editar isso depois e onde vai ficar esse código
        cardapio.add(produto);
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
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("%s\n").append(nomeRestaurante);
        sb.append("%s\n").append(idRestaurante);
        sb.append("Endereço= %s ").append(endereco).append('\'');
        sb.append(", %s \n").append(cep).append('\'');
        sb.append("Propietário:%s\n").append(proprietario);
        sb.append("Cardápio do restaurante %s :").append(nomeRestaurante).append(cardapio);
        sb.append('}');
        return sb.toString();
    }
}