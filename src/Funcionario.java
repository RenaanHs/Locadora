import java.util.Scanner;

public class Funcionario extends Pessoa{

    String cargo;
    float salario;

    public Funcionario(int idade, String nome, String cpf, char genero, String cargo, float salario) {
        super(idade, nome, cpf, genero);
        this.cargo = cargo;
        this.salario = salario;
    }

    public static void ListarFuncionarios(Scanner leitor) {

    }
}
