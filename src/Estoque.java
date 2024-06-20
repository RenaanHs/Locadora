public class Estoque {
    public static boolean verificarDisponibilidadeFilme(String titulo) {
        for (Filme filme : filmes) {
            if (filme.titulo.equalsIgnoreCase(titulo) && filme.status == Status.Disponivel) {
                return true;
            }
        }
        return false;
    }
    public static boolean verificarDisponibilidadeSerie(String titulo) {
        for (Series serie : series) {
            if (serie.titulo.equalsIgnoreCase(titulo) && serie.status == Status.Disponivel) {
                return true;
            }
        }
        return false;
    }
    public static void exibirCatalogoCompleto() {
        for (Filme filme : Filme.filmes) {
            if (filme.status == Status.Disponivel){
            System.out.println("Título: " + filme.titulo + ", Categoria: " + filme.categoria + ", Classificação Indicativa: " + filme.classIndicativa + ", Status: " + filme.status);
            encontrouFilme = true;    
        }
        }
        if (!encontrouFilme) {
            System.out.println("Nenhum Filme disponível no momento.");
        }
    }
    public static void listarSeriesDisponiveis() {
        boolean encontrouSeries = false;
        System.out.println("Séries Disponíveis:");
        for (Series serie : series) {
            if (serie.status == Status.Disponivel) {
                System.out.println("Título: " + serie.titulo + ", Categoria: " + serie.categoria +", Classificação Indicativa: " + serie.classInficativa + ", Temporadas: " + serie.temporadas +", Status: " + serie.status);
                encontrouSeries = true;
            }
        }
        if (!encontrouSeries) {
            System.out.println("Nenhuma série disponível no momento.");
        }
    }

}

