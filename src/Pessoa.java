public abstract class Pessoa {

    String nome;
    String cpf;
    int idade;
    char genero;

    public Pessoa(int idade, String nome, String cpf, char genero) {
        this.idade = idade;
        this.nome = nome;
        this.cpf = cpf;
        this.genero = genero;
    }
}

