import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Series {
    String titulo;
    int classInficativa;
    String categoria;
    String status;
    int temporadas;

    List<Series> serie = new ArrayList<>();

    public Series(String titulo, int classInficativa, String categoria, String status, int temporadas) {
        this.titulo = titulo;
        this.classInficativa = classInficativa;
        this.categoria = categoria;
        this.status = status;
        this.temporadas = temporadas;
    }

    public void lerArquivo() {
        try {
            File arquivo = new File("C:\\Users\\renan\\IdeaProjects\\Loucadora\\src\\Filmes.txt");
            Scanner scanner = new Scanner(arquivo);

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] partes = linha.split(",");

                if (partes.length >= 4) {
                    String titulo = partes[0].trim();
                    String classIndicativaStr = partes[1].trim();
                    String categoriaStr = partes[2].trim();
                    String statusStr = partes[3].trim();
                    String temporadasStr = partes[4].trim();

                    // Variável para armazenar a classificação indicativa
                    int classIndicativa = 0; // Valor padrão caso não seja um número

                    // Verificar se classIndicativaStr é um número
                    try {
                        classIndicativa = Integer.parseInt(classIndicativaStr);
                    } catch (NumberFormatException e) {
                        // Se não for um número, pode ser tratado de outra forma
                        System.err.println("Classificação indicativa não é um número: " + classIndicativaStr);
                        // Aqui você pode definir um valor padrão ou ignorar este filme, dependendo do seu caso
                        continue; // Pula para a próxima iteração do loop
                    }

                    // Verificar e converter categoria para enum Categoria
                    Categoria categoria;
                    try {
                        categoria = Categoria.valueOf(categoriaStr);
                    } catch (IllegalArgumentException e) {
                        System.err.println("Categoria inválida: " + categoriaStr);
                        categoria = Categoria.Indefinida; // Ou outro tratamento adequado
                    }

                    // Verificar e converter status para enum Status
                    Status status;
                    try {
                        status = Status.valueOf(statusStr);
                    } catch (IllegalArgumentException e) {
                        System.err.println("Status inválido: " + statusStr);
                        status = Status.Indisponivel; // Ou outro tratamento adequado
                    }

                    try {
                        temporadas = Integer.parseInt(temporadasStr);
                    } catch (NumberFormatException e) {
                        // Se não for um número, pode ser tratado de outra forma
                        System.err.println("Temporadas não é um número: " + classIndicativaStr);
                        // Aqui você pode definir um valor padrão ou ignorar este filme, dependendo do seu caso
                        continue; // Pula para a próxima iteração do loop
                    }

                    // Adicionar o filme à lista
                    serie.add(new Series(titulo, classIndicativa, categoria, status, temporadas));

                } else {
                    System.err.println("Linha inválida no arquivo: " + linha);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: film.txt");
            e.printStackTrace();
        }
    }

    public void catalogo(Scanner leitor) {
        System.out.println("**********************");
        System.out.println("***Catalogo Series***");
        System.out.println("1 - Todos");
        System.out.println("2 - Categoria");
        int opcao = Integer.parseInt(leitor.nextLine());

        switch (opcao) {
            case 1:
                for (Series s : serie) {
                    System.out.println("Titulo: " + s.titulo + ", Categoria: " + s.categoria + ", Status: " + s.status);
                }
                break;
            case 2:
                System.out.println("Digite a categoria:");
                String categoriaDigitada = leitor.nextLine();
                boolean encontrouFilmes = false;
                for (Series s : serie) {
                    if (s.categoria.toString().equalsIgnoreCase(categoriaDigitada)) {
                        System.out.println("Titulo: " + s.titulo + ", Categoria: " + s.categoria + ", Status: " + s.status);
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

