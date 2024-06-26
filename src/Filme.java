import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Filme {

    public static List<Filme> filmes = new ArrayList<>();
    String titulo;
    int classIndicativa;
    Categoria categoria;
    Status status;

    public Filme(String titulo, int classIndicativa, Categoria categoria, Status status) {
        this.titulo = titulo;
        this.classIndicativa = classIndicativa;
        this.categoria = categoria;
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public static void lerArquivo(List<Filme> filmes) {
        try {
            File arquivo = new File("C:\\Users\\autologon\\Downloads\\Locadora-main\\src\\Filmes.txt");
            Scanner scanner = new Scanner(arquivo);

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] partes = linha.split(",");

                if (partes.length >= 4) {
                    String titulo = partes[0].trim();
                    String classIndicativaStr = partes[1].trim();
                    String categoriaStr = partes[2].trim();
                    String statusStr = partes[3].trim();

                    int classIndicativa = 0;

                    try {
                        classIndicativa = Integer.parseInt(classIndicativaStr);
                    } catch (NumberFormatException e) {
                        System.err.println("Classificação indicativa não é um número: " + classIndicativaStr);
                        continue;
                    }

                    // Verificar e converter categoria para enum Categoria
                    Categoria categoria;
                    try {
                        categoria = Categoria.valueOf(categoriaStr);
                    } catch (IllegalArgumentException e) {
                        System.err.println("Categoria inválida: " + categoriaStr);
                        categoria = Categoria.Indefinida;
                    }

                    Status status;
                    try {
                        status = Status.valueOf(statusStr);
                    } catch (IllegalArgumentException e) {
                        System.err.println("Status inválido: " + statusStr);
                        status = Status.Indisponivel;
                    }


                    filmes.add(new Filme(titulo, classIndicativa, categoria, status));

                } else {
                    System.err.println("Linha inválida no arquivo: " + linha);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: Filmes.txt");
            e.printStackTrace();
        }
    }

    static void cadastrarFilme(Scanner leitor) {
        System.out.println("Digite o titulo do filme");
        String titulo = leitor.nextLine();
        System.out.println("Qual a classificação indicativa do filme?");
        int classificacao = Integer.parseInt(leitor.nextLine());
        System.out.println("Digite o genero do filme");
        String generof = leitor.nextLine();

        filmes.add(new Filme(titulo, classificacao, Categoria.valueOf(generof), Status.Disponivel));

        escreverArquivo();

    }

    public static void escreverArquivo() {
        String filePath = "C:\\Users\\autologon\\Downloads\\Locadora-main\\src\\Filmes.txt";

        try (FileWriter writer = new FileWriter(filePath, true)) {
            Filme ultimoFilme = filmes.get(filmes.size() - 1);

            writer.write(ultimoFilme.titulo + ", " + ultimoFilme.classIndicativa + ", " + ultimoFilme.categoria + ", " + ultimoFilme.status + "\n");

            System.out.println("Filme cadastrado com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }


    public static void catalogoF(Scanner leitor) {
        System.out.println("**********************");
        System.out.println("***Catalogo Filmes***");
        System.out.println("1 - Todos");
        System.out.println("2 - Categoria");
        int opcao = Integer.parseInt(leitor.nextLine());

        switch (opcao) {
            case 1:
                for (Filme f : Filme.filmes) {
                    System.out.println("Titulo: " + f.titulo + ", Categoria: " + f.categoria + ", Status: " + f.status);
                }
                break;
            case 2:
                System.out.println("Digite a categoria:");
                String categoriaDigitada = leitor.nextLine();
                boolean encontrouFilmes = false;
                for (Filme f : Filme.filmes) {
                    if (f.categoria.toString().equalsIgnoreCase(categoriaDigitada)) {
                        System.out.println("Titulo: " + f.titulo + ", Categoria: " + f.categoria + ", Status: " + f.status);
                        encontrouFilmes = true;
                    }
                }
                if (!encontrouFilmes) {
                    System.out.println("Nenhum filme encontrado nesta categoria.");
                }
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

}
