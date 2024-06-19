public class Devolver {
    void devolver(Filme f){
        f.status = Status.Disponivel;
    }

    void devolverSerie(Series s){
        s.status = Status.Disponivel;
    }
}
