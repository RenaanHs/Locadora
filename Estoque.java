import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Estoque {

    public static List<Filme> filmes = new ArrayList<>();

    public static List<Series> series = new ArrayList<>();

    public static boolean DisponibilidadeFilme(String titulo) {
        for (Filme filme : filmes) {
            if (filme.titulo.equalsIgnoreCase(titulo) && filme.status == Status.Disponivel) {
                return true;
            }
        }
        return false;
    }

    public static boolean DisponibilidadeSerie(String titulo) {
        for (Series serie : series) {
            if (serie.titulo.equalsIgnoreCase(titulo) && serie.status == Status.Disponivel) {
                return true;
            }
        }
        return false;
    }

    public static void listarFilmesDisponiveis() {
        boolean encontrouFilmes = false;
        System.out.println("Filmes Disponíveis:");
        for (Filme filme : filmes) {
            if (filme.status == Status.Disponivel) {
                System.out.println("Título: " + filme.titulo + ", Categoria: " + filme.categoria +
                        ", Classificação Indicativa: " + filme.classIndicativa + ", Status: " + filme.status);
                encontrouFilmes = true;
            }
        }
        if (!encontrouFilmes) {
            System.out.println("Nenhum filme disponível no momento.");
        }
    }

    public static void listarSeriesDisponiveis() {
        boolean encontrouSeries = false;
        System.out.println("Séries Disponíveis:");
        for (Series serie : series) {
            if (serie.status == Status.Disponivel) {
                System.out.println("Título: " + serie.titulo + ", Categoria: " + serie.categoria +
                        ", Classificação Indicativa: " + serie.classInficativa + ", Temporadas: " + Series.temporadas + ", Status: " + serie.status);
                encontrouSeries = true;
            }
        }
        if (!encontrouSeries) {
            System.out.println("Nenhuma série disponível no momento.");
        }
    }

    public static void carregarFilmes(List<Filme> listaFilmes) {
        filmes.addAll(listaFilmes);
    }


    public static void carregarSeries(List<Series> listaSeries) {
        series.addAll(listaSeries);
    }

    public static void atualizarArquivoFilmes() {
        String filePath = "C:\\Users\\silvi\\Downloads\\Locadora-main\\Locadora-main\\src\\Filmes.txt";

        try (FileWriter writer = new FileWriter(filePath)) {
            for (Filme filme : filmes) {
                writer.write(filme.titulo + ", " + filme.classIndicativa + ", " + filme.categoria + ", " + filme.status + "\n");
            }
        } catch (IOException e) {
            System.err.println("Erro ao atualizar o arquivo de filmes: " + e.getMessage());
        }
    }

    public static void atualizarArquivoSeries() {
        String filePath = "C:\\Users\\silvi\\Downloads\\Locadora-main\\Locadora-main\\src\\Series.txt";

        try (FileWriter writer = new FileWriter(filePath)) {
            for (Series serie : series) {
                writer.write(serie.titulo + ", " + serie.classInficativa + ", " + serie.categoria + ", " + serie.status + ", " + Series.temporadas + "\n");
            }
        } catch (IOException e) {
            System.err.println("Erro ao atualizar o arquivo de séries: " + e.getMessage());
        }
    }

}



