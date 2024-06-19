public class Alugar {
    void alugar(Filme f){
        f.status = Status.Locado;
    }

    void alugarSerie(Series s){
        s.status = Status.Locado;
    }
}
