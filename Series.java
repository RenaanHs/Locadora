import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Series {
    public static List<Series> serie = new ArrayList<>();
    String titulo;
    int classInficativa;
    Categoria categoria;
    Status status;
    static int temporadas;
    private final int classIndicativa;

    public Series(String titulo, int classIndicativa, Categoria categoria2, Status status, int temporadas) {
        this.titulo = titulo;
        this.classIndicativa = classIndicativa;
        this.categoria = categoria2;
        this.status = status;
        Series.temporadas = temporadas;
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

    public static void lerArquivo(List<Series> serie) {
        try {
            File arquivo = new File("C:\\Users\\silvi\\Downloads\\Locadora-main\\Locadora-main\\src\\Series.txt");
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

                    int classIndicativa;

                    try {
                        classIndicativa = Integer.parseInt(classIndicativaStr);
                    } catch (NumberFormatException e) {

                        System.err.println("Classificação indicativa não é um número: " + classIndicativaStr);

                        continue;
                    }

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

                    try {
                        temporadas = Integer.parseInt(temporadasStr);
                    } catch (NumberFormatException e) {

                        System.err.println("Temporadas não é um número: " + classIndicativaStr);

                        continue;
                    }

                    serie.add(new Series(titulo, classIndicativa, categoria, status, temporadas));

                } else {
                    System.err.println("Linha inválida no arquivo: " + linha);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: Series.txt");
            e.printStackTrace();
        }
    }

    static void cadastrarSerie(Scanner leitor) {
        System.out.println("Digite o titulo da serie");
        String titulo = leitor.nextLine();
        System.out.println("Qual a classificação indicativa da serie?");
        int classificacao = Integer.parseInt(leitor.nextLine());
        System.out.println("Digite o genero da serie");
        String generos = leitor.nextLine();
        System.out.println("Quantas temporadas?");
        int temp = Integer.parseInt(leitor.nextLine());

        serie.add(new Series(titulo, classificacao,  Categoria.valueOf(generos), Status.Disponivel, temp));
        escreverArquivo();

    }

    public static void escreverArquivo() {
        try {
            FileWriter writer = new FileWriter("C:\\Users\\silvi\\Downloads\\Locadora-main\\Locadora-main\\src\\Series.txt", true);

            for (Series s : serie) {
                writer.write(s.titulo + ", " + s.classIndicativa + ", " + s.categoria + ", " + s.status + ", " + temporadas + "\n");
            }

            writer.close();
            System.out.println("Série cadastrada com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    public static void catalogoS(Scanner leitor) {
        System.out.println("**********************");
        System.out.println("***Catalogo Series***");
        System.out.println("1 - Todos");
        System.out.println("2 - Categoria");
        int opcao = Integer.parseInt(leitor.nextLine());

        switch (opcao) {
            case 1:
                for (Series s : Series.serie) {
                    System.out.println("Titulo: " + s.titulo + ", Categoria: " + s.categoria + ", Status: " + s.status);
                }
                break;
            case 2:
                System.out.println("Digite a categoria:");
                String categoriaDigitada = leitor.nextLine();
                boolean encontrouFilmes = false;
                for (Series s : Series.serie) {
                    if (s.categoria.toString().equalsIgnoreCase(categoriaDigitada)) {
                        System.out.println("Titulo: " + s.titulo + ", Categoria: " + s.categoria + ", Status: " + s.status);
                        encontrouFilmes = true;
                    }
                }
                if (!encontrouFilmes) {
                    System.out.println("Nenhuma serie encontrada nesta categoria.");
                }
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

}