package exercicio_03;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Funcionario extends Pessoa{
    protected String cargo;
    protected Double salario;

    public Funcionario (){}

    public Funcionario(String nome, String cpf, String rg, String cargo, Double salario, TipoPessoa tipo) {
        super(nome, cpf, rg, tipo);
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public void modificaPessoa(){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Nome: %s", this.nome);
        System.out.printf("\nNovo Nome ou ENTER para não alterar: ");
        String novoNome = scanner.nextLine();
        this.nome = (novoNome.isBlank() ? this.nome : novoNome );
        System.out.printf("CPF: %s", this.cpf);
        System.out.printf("\nNovo CPF ou ENTER para não alterar: ");
        String novoCpf = scanner.nextLine();
        this.cpf = (novoCpf.isBlank() ? this.cpf : novoCpf );
        System.out.printf("RG: %s", this.rg);
        System.out.printf("\nNovo RG ou ENTER para não alterar: ");
        String novoRg = scanner.nextLine();
        this.rg = (novoRg.isBlank() ? this.rg : novoRg );
        System.out.printf("Cargo: %s", this.cargo);
        System.out.printf("\nNovo Cargo ou ENTER para não alterar: ");
        String novoCargo = scanner.nextLine();
        this.rg = (novoCargo.isBlank() ? this.cargo : novoCargo );
        System.out.printf("Salário: %.2f", this.salario);
        System.out.printf("\nNovo Salário ou 0 (zero) para não alterar: ");
        Double novoSalario = scanner.nextDouble();
        this.salario = (novoSalario == 0 ? this.salario : novoSalario );

    }
    @Override
    public String toString() {
        return "{ nome: "+
                nome+
                "; CPF: "+
                cpf+
                "; RG: "+
                rg+
                "; Cargo: "+
                cargo+
                "; Salário $ "+
                String.format("%.2f",salario)+
                " }";


    }
}
