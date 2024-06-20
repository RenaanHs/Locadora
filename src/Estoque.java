import java.util.ArrayList;
import java.util.List;

public class Estoque {

 public static List<Filme> filmes = new ArrayList<>();
 public static List<Series> series = new ArrayList<>();
    
    //disponibilidade de filmes no estoque
    public static boolean DisponibilidadeFilme(String titulo) {
        for (Filme filme : filmes) {
            if (filme.titulo.equalsIgnoreCase(titulo) && filme.status == Status.Disponivel) {
                return true;
            }
        }
        return false;
    }
    //disponibilidade de series no estoque
    public static boolean DisponibilidadeSerie(String titulo) {
        for (Series serie : series) {
            if (serie.titulo.equalsIgnoreCase(titulo) && serie.status == Status.Disponivel) {
                return true;
            }
        }
        return false;
    }
     //lista filmes disponiveis no estoque
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
    //lista series disponiveis no estoque
    public static void listarSeriesDisponiveis() {
        boolean encontrouSeries = false;
        System.out.println("Séries Disponíveis:");
        for (Series serie : series) {
            if (serie.status == Status.Disponivel) {
                System.out.println("Título: " + serie.titulo + ", Categoria: " + serie.categoria +
                        ", Classificação Indicativa: " + serie.classInficativa + ", Temporadas: " + serie.temporadas +", Status: " + serie.status);
                encontrouSeries = true;
            }
        }
        if (!encontrouSeries) {
            System.out.println("Nenhuma série disponível no momento.");
        }
    }
    //carrega filmes no estoque
    public static void carregarFilmes(List<Filme> listaFilmes) {
        filmes.addAll(listaFilmes);
    }

    //carrega séries no estoque
    public static void carregarSeries(List<Series> listaSeries) {
        series.addAll(listaSeries);
    }

    //exibi o catálogo completo de filmes
    public static void exibirCatalogoCompletoFilmes() {
        for (Filme filme : filmes) {
            System.out.println("Título: " + filme.titulo + ", Categoria: " + filme.categoria +
                               ", Classificação Indicativa: " + filme.classIndicativa + ", Status: " + filme.status);
        }
    }

    //exibi o catálogo completo de séries
    public static void exibirCatalogoCompletoSeries() {
        for (Series serie : series) {
            System.out.println("Título: " + serie.titulo + ", Categoria: " + serie.categoria +
                               ", Classificação Indicativa: " + serie.classInficativa + ", Status: " + serie.status +
                               ", Temporadas: " + serie.temporadas);
        }
    }
}
