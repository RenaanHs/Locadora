import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Compra {

    //histórico de compras filmes
    private static List<Filme> historicoComprasF = new ArrayList<>();
    
    //histórico de compras séries
    private static List<Series> historicoCompraS = new ArrayList<>();

    // disponibilidade de compra filme
    public static boolean disponibilidadeParaCompraFilme(String titulo) {
        return Estoque.verificarDisponibilidadeFilme(titulo);
    }

    // disponibilidade de compra série
    public static boolean disponibilidadeParaCompraSerie(String titulo) {
        return Estoque.verificarDisponibilidadeSerie(titulo);
    }
    
    // compra filme
    public static void CompraFilme(String titulo) {
        for (Filme filme : Estoque.filmes) {
            if (filme.titulo.equalsIgnoreCase(titulo)) {
                if (disponibilidadeParaCompra(titulo, true)) {
                    filme.status = Status.Indisponivel; // Depois de comprado ficara indisponível.
                    historicoComprasF.add(filme);
                    System.out.println("Compra registrada: " + filme.titulo + " agora está " + filme.status);
                } else {
                    System.out.println("O filme " + filme.titulo + " não está disponível .");
                }
                return;
            }
        }
        System.out.println("Filme não encontrado: " + titulo);
    }

    //compra série
    public static void CompraSerie(String titulo) {
        for (Series serie : Estoque.series) {
            if (serie.titulo.equalsIgnoreCase(titulo)) {
                if (disponibilidadeParaCompra(titulo, false)) {
                    serie.status = Status.Indisponivel; // Depois de comprada ficara indisponível.
                    historicoCompraS.add(serie);
                    System.out.println("Compra registrada: " + serie.titulo + " 
                                       Status " + serie.status);
                } else {
                    System.out.println("A série " + serie.titulo + " não está disponível.");
                }
                return;
            }
        }
        System.out.println("Série não encontrada: " + titulo);
    }

    //filmes disponíveis
    public static void filmesDisponiveisParaCompra() {
        boolean encontrouFilmes = false;
        System.out.println("Filmes Disponíveis para Compra:");
        for (Filme filme : Estoque.filmes) {
            if (filme.status == Status.Disponivel) {
                System.out.println("Título: " + filme.titulo + ", Categoria: " + filme.categoria +
                                   ", Classificação Indicativa: " + filme.classIndicativa + ", Status: " + filme.status);
                encontrouFilmes = true;
            }
        }
        if (!encontrouFilmes) {
            System.out.println("Nenhum filme disponível para compra.");
        }
    }

    //séries disponíveis
    public static void seriesDisponiveisParaCompra() {
        boolean encontrouSeries = false;
        System.out.println("Séries Disponíveis para Compra:");
        for (Series serie : Estoque.series) {
            if (serie.status == Status.Disponivel) {
                System.out.println("Título: " + serie.titulo + ", Categoria: " + serie.categoria +
                                   ", Classificação Indicativa: " + serie.classInficativa + ", Temporadas: " + serie.temporadas +
                                   ", Status: " + serie.status);
                encontrouSeries = true;
            }
        }
        if (!encontrouSeries) {
            System.out.println("Nenhuma série disponível para compra.");
        }
    }

    //histórico de compras filmes
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

    // histórico de compras series
    public static void historicoDeComprasS() {
        if (historicoCompraS.isEmpty()) {
            System.out.println("Nenhuma série foi comprada.");
        } else {
            System.out.println("Histórico de Compras de Séries:");
            for (Series serie : historicoCompraS) {
                System.out.println("Título: " + serie.titulo + ", Categoria: " + serie.categoria +
                                   ", Classificação Indicativa: " + serie.classInficativa + ", Temporadas: " + serie.temporadas);
            }
        }
    }

    //compra de filmes
    public static void menuCompraFilmes(Scanner leitor) {
        while (true) {
            System.out.println("*********************");
            System.out.println("***** COMPRAAAA *****");
            System.out.println("*********************");
            System.out.println("1 - Comprar Filme");
            System.out.println("2 - Filmes Disponíveis");
            System.out.println("3 - Histórico de Compra de Filmes");
            System.out.println("4 - Voltar ao Menu Principal");
            System.out.println("*********************");
            int opcao = Integer.parseInt(leitor.nextLine()); // retorna string convertido em num inteiro

            switch (opcao) {
                case 1:
                    System.out.println("Qual filme deseja comprar?");
                    String tituloCompra = leitor.nextLine();
                    CompraFilme(tituloCompra);
                    break;
                case 2:
                    filmesDisponiveisParaCompra();
                    break;
                case 3:
                    historicoDeCompraF();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    //compra de series
    public static void menuCompraS(Scanner leitor) {
        while (true) {
            System.out.println("*********************");
            System.out.println("***** COMPRAAAA *****");
            System.out.println("*********************");
            System.out.println("1 - Comprar Série");
            System.out.println("2 - Séries Disponíveis");
            System.out.println("3 - Histórico de Compra de Séries");
            System.out.println("4 - Voltar ao Menu Principal");
            System.out.println("*********************");
            int opcao = Integer.parseInt(leitor.nextLine()); // retorna string convertido em num inteiro

            switch (opcao) {
                case 1:
                    System.out.println("Qual série deseja comprar?");
                    String tituloCompra = leitor.nextLine();
                    CompraSerie(tituloCompra);
                    break;
                case 2:
                    seriesDisponiveisParaCompra();
                    break;
                case 3:
                    historicoDeCompraS();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
