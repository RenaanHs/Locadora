import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente extends Pessoa {

    int id;
    static int idCounter = 0;

    public Cliente(int idade, String nome, String cpf, char genero, int id) {
        super(idade, nome, cpf, genero);
        this.id = id;
    }

    static List<Cliente> pessoa = new ArrayList<>();

    public static void cadastrarCliente(Scanner leitor) {
        System.out.print("Nome: ");
        String nome = leitor.nextLine();
        System.out.print("idade: ");
        int idade = Integer.parseInt(leitor.nextLine());
        System.out.print("Cpf: ");
        String cpf = leitor.nextLine();
        System.out.print("Genero\nM- Masculino\nF- Feminino\n :");
        char genero = leitor.next().charAt(0);

        int id = ++idCounter;
        pessoa.add(new Cliente(idade, nome, cpf, genero, idCounter));

        System.out.println("Cliente Cadastrado com sucesso!!");

    }

}