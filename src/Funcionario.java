import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Funcionario extends Pessoa {

    static List<Funcionario> funcionarios = new ArrayList<>();
    String cargo;
    float salario;

    public Funcionario(int idade, String nome, String cpf, char genero, String cargo, float salario) {
        super(idade, nome, cpf, genero);
        this.cargo = cargo;
        this.salario = salario;
    }
    public abstract void realizarAcao ();

    public static void ListarFuncionarios(Scanner leitor) {
        funcionarios.add(new Gerente(35, "João", "123456789", 'M', "Gerente", 5000));
        funcionarios.add(new Repositor(25, "Maria", "987654321", 'F', "Repositor", 2500));
        funcionarios.add(new Estoquista(28, "Pedro", "456789123", 'M', "Estoquista", 3000));
        funcionarios.add(new Caixa(30, "Ana", "654321987", 'F', "Caixa", 3500));

        System.out.println("Listagem de Funcionários:");
        for (Funcionario func : funcionarios) {
            System.out.printf("Nome: %s | Cargo: %s | ", func.nome, func.cargo);
            System.out.println();
            func.realizarAcao();
        }

    }
}
