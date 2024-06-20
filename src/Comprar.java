import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Compra {
    
    // Lista para armazenar o histórico de compras
    private static List<Filme> historicoCompras = new ArrayList<>();

    // Método para verificar a disponibilidade de um filme para compra
    public static boolean verificarDisponibilidadeParaCompra(String titulo) {
        for (Filme filme : Filme.filmes) {
            if (filme.titulo.equalsIgnoreCase(titulo) && filme.status == Status.Disponivel) {
                return true;
            }
        }
        return false;
    }

    // Método para registrar a compra de um filme
    public static void registrarCompra(String titulo) {
        for (Filme filme : Filme.filmes) {
            if (filme.titulo.equalsIgnoreCase(titulo)) {
                if (filme.status == Status.Disponivel) {
                    filme.status = Status.Indisponivel; // Após a compra, o filme fica indisponível para aluguel.
                    historicoCompras.add(filme);
                    System.out.println("Compra registrada: " + filme.titulo + " agora está " + filme.status);
                } else {
                    System.out.println("O filme " + filme.titulo + " não está disponível para compra.");
                }
                return;
            }
        }
        System.out.println("Filme não encontrado no catálogo: " + titulo);
    }

    // Método para exibir filmes disponíveis para compra
    public static void exibirFilmesDisponiveisParaCompra() {
        boolean encontrouFilmes = false;
        for (Filme filme : Filme.filmes) {
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

    // Método para exibir o histórico de compras
    public static void exibirHistoricoDeCompras() {
        if (historicoCompras.isEmpty()) {
            System.out.println("Nenhuma compra foi registrada ainda.");
        } else {
            System.out.println("Histórico de Compras:");
            for (Filme filme : historicoCompras) {
                System.out.println("Título: " + filme.titulo + ", Categoria: " + filme.categoria +
                                   ", Classificação Indicativa: " + filme.classIndicativa);
            }
        }
    }

    // Método principal para gerenciamento de compras
    public static void menuCompra(Scanner leitor) {
        while (true) {
            System.out.println("*********************");
            System.out.println("*****MENU COMPRA*****");
            System.out.println("*********************");
            System.out.println("1 - Comprar Filme");
            System.out.println("2 - Exibir Filmes Disponíveis para Compra");
            System.out.println("3 - Exibir Histórico de Compras");
            System.out.println("4 - Voltar ao Menu Principal");
            System.out.println("*********************");
            int opcao = Integer.parseInt(leitor.nextLine());

            switch (opcao) {
                case 1:
                    System.out.println("Digite o título do filme que deseja comprar:");
                    String tituloCompra = leitor.nextLine();
                    registrarCompra(tituloCompra);
                    break;
                case 2:
                    exibirFilmesDisponiveisParaCompra();
                    break;
                case 3:
                    exibirHistoricoDeCompras();
                    break;
                case 4:
                    return; // Sai do menu de compra e retorna ao menu principal
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}

