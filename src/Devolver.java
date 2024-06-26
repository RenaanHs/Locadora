import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Devolver {

    static final String filmesPath = "C:\\Users\\autologon\\Downloads\\Locadora-main\\src\\Filmes.txt";
    static final String seriesPath = "C:\\Users\\autologon\\Downloads\\Locadora-main\\src\\Series.txt";
    
    public void devolverFilme(Filme f) {
        f.status = Status.Disponivel;
        System.out.println("Filme " + f.getTitulo() + " devolvido com sucesso.");
    }

    public void devolverSerie(Series s) {
        s.status = Status.Disponivel;
        System.out.println("Série " + s.getTitulo() + " devolvida com sucesso.");
    }

    public static void devolver(Scanner leitor) {
        System.out.println("*********************");
        System.out.println("----Devolver----");
        System.out.print("Nome do cliente: ");
        String nomeCliente = leitor.nextLine();
        System.out.print("ID do cliente: ");
        int idCliente = Integer.parseInt(leitor.nextLine());
        Cliente.pesquisarId(idCliente, leitor);
        System.out.print("Nome do filme ou série: ");
        String nomeItem = leitor.nextLine();

        boolean encontrado = false;
        for (Filme filme : Estoque.filmes) {
            if (filme.getTitulo().equalsIgnoreCase(nomeItem) && filme.getStatus() == Status.Locado) {
                Devolver devolver = new Devolver();
                devolver.devolverFilme(filme);
                System.out.println("Devolução realizada com sucesso:");
                System.out.println("Cliente: " + nomeCliente);
                System.out.println("Filme: " + filme.getTitulo());
                devolvido(nomeCliente, filme.getTitulo(), "Filme");
                Estoque.atualizarArquivoFilmes(filmesPath);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            for (Series serie : Estoque.series) {
                if (serie.getTitulo().equalsIgnoreCase(nomeItem) && serie.getStatus() == Status.Locado) {
                    Devolver devolver = new Devolver();
                    devolver.devolverSerie(serie);
                    System.out.println("Devolução realizada com sucesso:");
                    System.out.println("Cliente: " + nomeCliente);
                    System.out.println("Série: " + serie.getTitulo());
                    devolvido(nomeCliente, serie.getTitulo(), "Série");
                    Estoque.atualizarArquivoSeries(seriesPath);
                    encontrado = true;
                    break;
                }
            }
        }

        if (!encontrado) {
            System.out.println("Item não encontrado ou não disponível para devolução.");
        }
    }

    public static void devolvido(String nomeCliente, String tituloItem, String tipoItem) {
        String registroPath = "C:\\Users\\autologon\\Downloads\\Locadora-main\\src\\RegistroDevolucoes.txt";

        try (FileWriter fw = new FileWriter(registroPath, true);
             PrintWriter pw = new PrintWriter(fw)) {

            pw.println("Cliente: " + nomeCliente + " devolveu " + tipoItem + ": " + tituloItem);

        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo de registro: " + e.getMessage());
        }
    }

}
