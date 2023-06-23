import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Classe do vendedor, pode realizar compras e gerenciar seus estabelecimentos
public class Vendor extends User {
    static Scanner input = new Scanner(System.in);
    private int idVendor;
    private List<Restaurante> estabelecimentos;

    // Construtor
    public Vendor(String nome, String cpf, LocalDate dataNascimento, String endereco, String numeroTelefone, String email, double saldoCarteira, int idVendor, List<Restaurante> estabelecimentos) {
        super(nome, cpf, dataNascimento, endereco, numeroTelefone, email, saldoCarteira);
        this.idVendor = idVendor;
        this.estabelecimentos = estabelecimentos;
    }


    public int getIdVendor() {
        return idVendor;
    }

    public List<Restaurante> getEstabelecimentos() {
        return estabelecimentos;
    }

    // Métodos
    public static void possuiRestaurante(){
        System.out.println("Você possui Restaurante? 1-Sim       2-Não ");
        String filename = "Vendor.data";
        int resposta = input.nextInt();

        if (resposta == 1){
            System.out.println("Restaurante: ");
            Restaurante.exibirMenuDeRestaurante();
            }
        else if(resposta == 2){
            System.out.println("Cadastre seu restaurante: ");

            // TODO

            Vendor vendor = getVendorFromDataFile(filename);
            Cadastro.cadastrarApenasRestauranteCardapio(vendor);

        } else {
            System.out.println("Entrada Inválida. ");
            possuiRestaurante();
        }
    }
    public void adicionarRestaurante(Restaurante restaurante) {
        restaurante.setProprietario(this);
        estabelecimentos.add(restaurante);
    }

    public void removerRestaurante(Restaurante restaurante) {
        restaurante.setProprietario(null);
        estabelecimentos.remove(restaurante);
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

        return "-----------------------------" +
                "\n          Vendedor:\n" +
                "\nNome: " + getNome() +
                "\nCPF: " + getCpf() +
                "\nData de Nascimento: " + getDataNascimento() +
                "\nEndereço: " + getEndereco() +
                "\nTelefone: " + getNumeroTelefone() +
                "\nE-mail: " + getEmail() +
                "\nSaldo: " + getSaldoCarteira() +
                "\n-----------------------------" +
                "\nID Dono: " + getIdVendor() +
                "\n-----------------------------";
    }
}