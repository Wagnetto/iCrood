import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;


//Classe dos estabelecimentos comerciais
public class Restaurante {

    static Scanner input = new Scanner(System.in);
    // Atributos
    private String nomeRestaurante;
    private int idRestaurante;
    private Vendor proprietario;
    private String endereco;
    private String cep;
    static List<Produto> cardapio;

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

    public static void exibirMenuDeRestaurante(){
        System.out.println("1 - Visualizar histórico de Pedidos\n2 - Adicionar produto ao cardápio\n3 - Encerrar programa");

        int opcaoMenu = input.nextInt();

        switch(opcaoMenu){
            case 1:
                //TODO VICTOR criar função
                //Restaurante.exibeHistoricoRestaurante();

                exibirMenuDeRestaurante();
                break;
            case 2:
                Restaurante.adicionaProdutoCardapio();
                exibirMenuDeRestaurante();
                break;
            case 3:
                System.out.println("Encerrando programa...!");
                break;
            default:
                System.out.println("Não deu");
        }


    }

    static public void adicionaProdutoCardapio() {
        System.out.println("Digite o nome do produto:\n");
        String nome = input.nextLine();

        System.out.println("Digite a descrição do produto:\n");
        String descricao = input.nextLine();

        System.out.println("Digite o valor do produto:\n");
        double valor = input.nextFloat();
        Produto produto = new Produto(nome, descricao, valor);
        cardapio.add(produto);

        System.out.println(produto);

    }

    public void pedeItensAdicionarLista(int quantidadeItens) {

        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < quantidadeItens; i++) {
            System.out.println("-------------------------------");
            System.out.println("Entre com o nome do produto: ");
            String nomeProduto = scan.nextLine();

            System.out.println("Entre com a descrição do produto: ");
            String descricaoProduto = scan.nextLine();

            System.out.println("Entre com o valor do produto: ");
            double valorProduto = scan.nextDouble();

            scan.nextLine(); // Limpa o buffer do scanner

            adicionarProdutoLista(nomeProduto, descricaoProduto, valorProduto);
        }
    }
    public void adicionarProdutoLista(String nomeProduto, String descricaoProduto, double valor) {
        Produto produto = new Produto(nomeProduto, descricaoProduto, valor);
        cardapio.add(produto);
    }
    public void editarCardapioRestaurante(int indexLista, String novoNomeProduto, String novaDescricaoProduto, double novoValor) {
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
        getIdRestaurante();
        System.out.println("Cardápio do restaurante " + nomeRestaurante + ":");
        for (Produto produto : cardapio) {
            System.out.println(produto);
        }
    }

    public static Vendor getVendorFromDataFile(String filename) {
        File file = new File(filename);

        if (!file.exists()) {
            System.err.println("Arquivo não encontrado: " + filename);
            return null;
        }

        try (Scanner fileScanner = new Scanner(file)) {
            String nome = null;
            String cpf = null;
            LocalDate dataNascimento = null;
            String endereco = null;
            String telefone = null;
            String email = null;
            double saldo = 0.0;
            int idDono = 0;

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                if (line.startsWith("Nome:")) {
                    nome = line.substring(line.indexOf(":") + 1).trim();
                } else if (line.startsWith("CPF:")) {
                    cpf = line.substring(line.indexOf(":") + 1).trim();
                } else if (line.startsWith("Data de Nascimento:")) {
                    String dataStr = line.substring(line.indexOf(":") + 1).trim();
                    dataNascimento = LocalDate.parse(dataStr);
                } else if (line.startsWith("Endereço:")) {
                    endereco = line.substring(line.indexOf(":") + 1).trim();
                } else if (line.startsWith("Telefone:")) {
                    telefone = line.substring(line.indexOf(":") + 1).trim();
                } else if (line.startsWith("E-mail:")) {
                    email = line.substring(line.indexOf(":") + 1).trim();
                } else if (line.startsWith("Saldo:")) {
                    String saldoStr = line.substring(line.indexOf(":") + 1).trim();
                    saldo = Double.parseDouble(saldoStr);
                } else if (line.startsWith("ID Dono:")) {
                    String idDonoStr = line.substring(line.indexOf(":") + 1).trim();
                    idDono = Integer.parseInt(idDonoStr);
                }
            }

            List<Restaurante> estabelecimentos = new ArrayList<>(); // Cria uma nova lista vazia

            return new Vendor(nome, cpf, dataNascimento, endereco, telefone, email, saldo, idDono, estabelecimentos);
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + e.getMessage());
        } catch (DateTimeParseException e) {
            System.err.println("Erro ao fazer parse da data: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erro ao fazer parse de um número: " + e.getMessage());
        }

        return null; // Retorna null se não for possível ler as informações do arquivo ou ocorrer algum erro
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n--------------------------------------\n");
        sb.append("Nome do Restaurante: ").append(nomeRestaurante).append("\n");
        sb.append("Endereço: ").append(endereco).append("\n");
        sb.append("CEP: ").append(cep).append("\n");

        if (proprietario != null) {
            sb.append("Proprietário: ").append(proprietario.getNome()).append("\n\n");
        } else {
            sb.append("Proprietário: N/A\n\n");
        }

        sb.append("ID: ").append(idRestaurante).append("\n");

        return sb.toString();
    }
}