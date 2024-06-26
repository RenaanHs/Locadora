import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

public class Alugar {

    public static void alugar(Scanner leitor) {
        int valor = 15;

        System.out.println("*********************");
        System.out.println("----Alugar----");
        System.out.print("Nome do cliente: ");
        String nomeCliente = leitor.nextLine();
        System.out.print("ID do cliente: ");
        int idCliente = Integer.parseInt(leitor.nextLine());
        Cliente.pesquisarId(idCliente,leitor);
        System.out.print("Nome do filme ou série: ");
        String nomeItem = leitor.nextLine();

        boolean encontrado = false;

        for (Filme filme : Filme.filmes) {
            if (filme.getTitulo().equalsIgnoreCase(nomeItem) && filme.getStatus() == Status.Disponivel) {
                alugarFilme(filme, nomeCliente, valor);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            for (Series serie : Series.serie) {
                if (serie.getTitulo().equalsIgnoreCase(nomeItem) && serie.getStatus() == Status.Disponivel) {
                    alugarSerie(serie, nomeCliente, valor);
                    encontrado = true;
                    break;
                }
            }
        }

        if (!encontrado) {
            System.out.println("Item não encontrado ou não disponível para aluguel.");
        }
    }

    private static void alugarFilme(Filme filme, String nomeCliente, int valor) {
        filme.setStatus(Status.Locado);

        String nomeArquivo = "alugueis.txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo, true))) {
            writer.println("Aluguel realizado com sucesso:");
            writer.println("Cliente: " + nomeCliente);
            writer.println("Filme: " + filme.getTitulo());
            writer.println("Tempo de aluguel: 7 dias");
            writer.println("Valor: R$ " + valor);
            writer.println("-------------------------------------");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o aluguel no arquivo.");
            e.printStackTrace();
        }

        System.out.println("Aluguel realizado com sucesso:");
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Filme: " + filme.getTitulo());
        System.out.println("Tempo de aluguel: 7 dias");
        System.out.println("Valor: R$ "+ valor);
    }

    private static void alugarSerie(Series serie, String nomeCliente, int valor) {
        serie.setStatus(Status.Locado);

        String nomeArquivo = "alugueis.txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo, true))) {
            writer.println("Aluguel realizado com sucesso:");
            writer.println("Cliente: " + nomeCliente);
            writer.println("Série: " + serie.getTitulo());
            writer.println("Tempo de aluguel: 7 dias");
            writer.println("Valor: R$ " + valor);
            writer.println("-------------------------------------");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o aluguel no arquivo.");
            e.printStackTrace();
        }

        System.out.println("Aluguel realizado com sucesso:");
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Série: " + serie.getTitulo());
        System.out.println("Tempo de aluguel: 7 dias");
        System.out.println("Valor: R$ "+ valor);
    }
}
