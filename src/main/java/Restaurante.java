import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Restaurante {
    private User dono;
    private String nome;
    private String endereco;
    private String cep;
    private int identificador;
    private List<Produto> cardapio;

    public Restaurante(String nome, String endereco, String cep, User dono) {
        this.nome = nome;
        this.endereco = endereco;
        this.cep = cep;
        this.identificador = gerarIdentificador();
        this.dono = dono;
        this.cardapio = new ArrayList<>();
    }

    public void adicionarPrato(Produto prato) {
        cardapio.add(prato);
    }

    public void removerPrato(Produto prato) {
        cardapio.remove(prato);
    }

    public List<Produto> getCardapio() {
        return cardapio;
    }

    // Getters e setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    private int gerarIdentificador() {
        // Gera um identificador aleatório
        Random random = new Random();
        return random.nextInt(9999) + 1;
    }
}
