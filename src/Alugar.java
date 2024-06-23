public class Alugar {
    void alugar(Filme f){
        f.status = Status.Locado;
    }

    void alugarSerie(Series s){
        s.status = Status.Locado;
    }

    public static void alugar(Scanner leitor) {
        static int valor = 15;
        static int idCounter = 0;
        System.out.println("*********************");
        System.out.println("----Alugar----");
        System.out.print("Nome do cliente: ");
        String nomeCliente = leitor.nextLine();
        System.out.print("ID do cliente: ");
        int idCliente = Integer.parseInt(leitor.nextLine());
        System.out.print("Nome do filme ou série: ");
        String nomeItem = leitor.nextLine();
        
        boolean encontrado = false;
        for (Filme filme : filmes) {
            if (filme.getTitulo().equalsIgnoreCase(nomeItem) && filme.getStatus() == Status.Disponivel) {
                Alugar alugar = new Alugar();
                alugar.alugar(filme);
                System.out.println("Aluguel realizado com sucesso:");
                System.out.println("Cliente: " + nomeCliente);
                System.out.println("Filme: " + filme.getTitulo());
                System.out.println("Tempo de aluguel: 7 dias");
                System.out.println("Valor: R$ "+ valor);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            for (Series serie : serie) {
                if (serie.getTitulo().equalsIgnoreCase(nomeItem) && serie.getStatus() == Status.Disponivel) {
                    Alugar alugar = new Alugar();
                    alugar.alugarSerie(serie);
                    System.out.println("Aluguel realizado com sucesso:");
                    System.out.println("Cliente: " + nomeCliente);
                    System.out.println("Série: " + serie.getTitulo());
                    System.out.println("Tempo de aluguel: 7 dias");
                    System.out.println("Valor: R$ "+ valor); 
                    encontrado = true;
                    break;
                }
            }
        }

        if (!encontrado) {
            System.out.println("Item não encontrado ou não disponível para aluguel.");
        }
    }

}
