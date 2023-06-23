import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LerDados {

    public LerDados() {
        List<Restaurante> restaurantes = lerRestaurantesDoArquivo();

        if (restaurantes.isEmpty()) {
            System.out.println("Não há restaurantes para exibir.");
        } else {
            System.out.println("Restaurantes cadastrados:");
            for (Restaurante restaurante : restaurantes) {
                System.out.println(restaurante);
            }
        }

        // Mostrar o cardápio do primeiro restaurante (altere conforme necessário)
        if (!restaurantes.isEmpty()) {
            Restaurante primeiroRestaurante = restaurantes.get(0);
            primeiroRestaurante.mostraCardapio();
        }
    }

    public static List<Restaurante> lerRestaurantesDoArquivo() {
        List<Restaurante> restaurantes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("Restaurante.data"))) {
            String line;
            Restaurante restaurante = null;

            while ((line = reader.readLine()) != null) {
                String trim = line.substring(line.indexOf(":") + 1).trim();
                if (line.startsWith("Nome do Restaurante:")) {
                    if (restaurante != null) {
                        restaurantes.add(restaurante);
                    }

                    restaurante = new Restaurante();
                    restaurante.setNome(trim);
                } else if (line.startsWith("ID:")) {
                    restaurante.setId(Integer.parseInt(trim));
                } else if (line.startsWith("Endereço:")) {
                    restaurante.setEndereco(trim);
                } else if (line.startsWith("CEP:")) {
                    restaurante.setCep();
                }  else if (line.startsWith("Proprietário:")) {
                String proprietario = trim;
                if (!proprietario.equals("N/A")) {
                    restaurante.setProprietario(proprietario);
                }
            }
        }Restaurante.cardapio = new ArrayList<>();  // Corrigir a chamada do método getCardapio()
            // Add this line

            if (restaurante != null) {
                restaurantes.add(restaurante);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return restaurantes;
    }



    static class Restaurante {
        public static List <Produto> cardapio;
        private String nome;
        private int id;

        public String getNome() {
            return nome;
        }


        public void setNome(String nome) {
            this.nome = nome;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setEndereco(String endereco) {
        }

        public void setCep() {
        }

        public void setProprietario(String proprietario) {
        }
        public Vendor getVendorFromDataFile(String filename) {
            try (Scanner fileScanner = new Scanner(new File(filename))) {
                String nome = null;
                String cpf = null;
                LocalDate dataNascimento = null;
                String endereco = null;
                String telefone = null;
                String email = null;
                double saldo = 0.0;

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
                        int idDono = Integer.parseInt(line.substring(line.indexOf(":") + 1).trim());
                        return new Vendor(nome, cpf, dataNascimento, endereco, telefone, email, saldo, idDono, null);
                    }
                }
            } catch (FileNotFoundException e) {
                System.err.println("Arquivo não encontrado: " + e.getMessage());
            }
            return null; // Retorna null se não for possível ler as informações do arquivo
        }

        public static List<Produto> lerProdutosDoArquivo() {
            List<Produto> cardapio = new ArrayList<>();
            String nomeArquivo = "CardapioRestaurante.data";
            try {
                BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo));
                String linha;
                while ((linha = reader.readLine()) != null) {
                    if (linha.equals("Nome do Produto:")) {
                        String nome = "";
                        String descricao = "";
                        double valor = 0.0;

                        // Read the next three lines and validate their format
                        for (int i = 0; i < 3; i++) {
                            linha = reader.readLine();
                            if (linha != null && !linha.isEmpty()) {
                                String[] parts = linha.split(": ");
                                if (parts.length >= 2) {
                                    String value = parts[1].trim();
                                    if (parts[0].equals("Nome do Produto")) {
                                        nome = value;
                                    } else if (parts[0].equals("Descricao do Produto")) {
                                        descricao = value;
                                    } else if (parts[0].equals("Valor")) {
                                        valor = Double.parseDouble(value.replace("R$", ""));
                                    }
                                } else {
                                    throw new IOException("Invalid line format: " + linha);
                                }
                            } else {
                                throw new IOException("Empty line encountered.");
                            }
                        }

                        Produto produto = new Produto(nome, descricao, valor);
                        cardapio.add(produto);
                    }
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return cardapio;
        }

        public void mostraCardapio() {
            cardapio = lerProdutosDoArquivo();
            System.out.println("Cardápio do restaurante " + getNome() + ":");
            for (Produto produto : cardapio) {
                System.out.println(produto);
            }
        }

    }
}
