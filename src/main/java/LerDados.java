import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class LerDados {

    public LerDados() {
        List<Restaurante> restaurantes = lerRestaurantesDoArquivo();

        if (restaurantes.isEmpty()) {
            System.out.println("Não há restaurantes para exibir.");
        } else {
            System.out.println("Restaurantes cadastrados:");
            for (Restaurante restaurante : restaurantes) {
                System.out.println(restaurante);
            }
        }}

    public static List<Restaurante> lerRestaurantesDoArquivo() {
        List<Restaurante> restaurantes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("Restaurante.data"))) {
            String line;
            Restaurante restaurante = null;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Nome do Restaurante:")) {
                    if (restaurante != null) {
                        restaurantes.add(restaurante);
                    }

                    restaurante = new Restaurante();
                    restaurante.setNome(line.substring(line.indexOf(":") + 1).trim());
                } else if (line.startsWith("ID:")) {
                    restaurante.setId(Integer.parseInt(line.substring(line.indexOf(":") + 1).trim()));
                } else if (line.startsWith("Endereço:")) {
                    restaurante.setEndereco(line.substring(line.indexOf(":") + 1).trim());
                } else if (line.startsWith("CEP:")) {
                    restaurante.setCep(line.substring(line.indexOf(":") + 1).trim());
                } else if (line.startsWith("Proprietário:")) {
                    String proprietario = line.substring(line.indexOf(":") + 1).trim();
                    if (!proprietario.equals("N/A")) {
                        restaurante.setProprietario(proprietario);
                    }
                }
            }

//            if (restaurante != null) {
//                restaurantes.add(restaurante);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return restaurantes;
    }

    static class Restaurante {
        private String nome;
        private int id;
        private String endereco;
        private String cep;
        private String proprietario;

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

        public String getProprietario() {
            return proprietario;
        }

        public void setProprietario(String proprietario) {
            this.proprietario = proprietario;
        }

//        @Override
//        public String toString() {
//            return "Nome do Restaurante: " + nome + "\n" +
//                    "ID: " + id + "\n" +
//                    "Endereço: " + endereco + "\n" +
//                    "CEP: " + cep + "\n" +
//                    "Proprietário: " + proprietario + "\n";
//        }
    }
}
