import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Comprar {

    private static final List<Filme> historicoComprasF = new ArrayList<>();

    private static final List<Series> historicoCompraS = new ArrayList<>();

    public static void listarFilmesParaCompra() {
        System.out.println("Filmes disponíveis para compra:");
        Estoque.listarFilmesDisponiveis();
    }

    public static void listarSeriesParaCompra() {
        System.out.println("Séries disponíveis para compra:");
        Estoque.listarSeriesDisponiveis();
    }

    public static void compraFilme(String titulo) {
        if (Estoque.DisponibilidadeFilme(titulo)) {
            for (Filme filme : Estoque.filmes) {
                if (filme.titulo.equalsIgnoreCase(titulo)) {
                    filme.status = Status.Vendido;
                    historicoComprasF.add(filme);
                    System.out.println("Compra registrada: " + filme.titulo + " agora está " + filme.status);

                    Estoque.atualizarArquivoFilmes(Devolver.filmesPath);
                    return;
                }
            }
        } else {
            System.out.println("Filme não encontrado ou não disponível: " + titulo);
        }
    }

    public static void compraSerie(String titulo) {
        if (Estoque.DisponibilidadeSerie(titulo)) {
            for (Series serie : Estoque.series) {
                if (serie.titulo.equalsIgnoreCase(titulo)) {
                    serie.status = Status.Vendido;
                    historicoCompraS.add(serie);
                    System.out.println("Compra registrada: " + serie.titulo + " agora está " + serie.status);

                    Estoque.atualizarArquivoSeries(Devolver.seriesPath);
                    return;
                }
            }
        } else {
            System.out.println("Série não encontrada ou não disponível: " + titulo);
        }
    }

    public static void historicoDeComprasF() {
        if (historicoComprasF.isEmpty()) {
            System.out.println("Nenhum filme foi comprado.");
        } else {
            System.out.println("Histórico de Compras de Filmes:");
            for (Filme filme : historicoComprasF) {
                System.out.println("Título: " + filme.titulo + ", Categoria: " + filme.categoria +
                        ", Classificação Indicativa: " + filme.classIndicativa);
            }
        }
    }

    public static void historicoDeComprasS() {
        if (historicoCompraS.isEmpty()) {
            System.out.println("Nenhuma série foi comprada.");
        } else {
            System.out.println("Histórico de Compras de Séries:");
            for (Series serie : historicoCompraS) {
                System.out.println("Título: " + serie.titulo + ", Categoria: " + serie.categoria +
                        ", Classificação Indicativa: " + serie.classInficativa + ", Temporadas: " + Series.temporadas);
            }
        }
    }

    public static void menuCompraFilmes(Scanner leitor) {
        while (true) {
            System.out.println("*********************");
            System.out.println("***** COMPRAR *****");
            System.out.println("*********************");
            System.out.println("1 - Comprar Filme");
            System.out.println("2 - Filmes Disponíveis");
            System.out.println("3 - Histórico de Compra de Filmes");
            System.out.println("4 - Voltar ao Menu Principal");
            System.out.println("*********************");
            int opcao = Integer.parseInt(leitor.nextLine());

            switch (opcao) {
                case 1:
                    System.out.println("Qual filme deseja comprar?");
                    String tituloCompra = leitor.nextLine();
                    compraFilme(tituloCompra);

                    break;
                case 2:
                    listarFilmesParaCompra();
                    break;
                case 3:
                    historicoDeComprasF();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public static void menuCompraS(Scanner leitor) {
        while (true) {
            System.out.println("*********************");
            System.out.println("***** COMPRAR *****");
            System.out.println("*********************");
            System.out.println("1 - Comprar Série");
            System.out.println("2 - Séries Disponíveis");
            System.out.println("3 - Histórico de Compra de Séries");
            System.out.println("4 - Voltar ao Menu Principal");
            System.out.println("*********************");
            int opcao = Integer.parseInt(leitor.nextLine());

            switch (opcao) {
                case 1:
                    System.out.println("Qual série deseja comprar?");
                    String tituloCompra = leitor.nextLine();
                    compraSerie(tituloCompra);
                    break;
                case 2:
                    listarSeriesParaCompra();
                    break;
                case 3:
                    historicoDeComprasS();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
