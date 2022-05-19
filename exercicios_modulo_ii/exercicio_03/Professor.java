package exercicio_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Professor extends Funcionario{

    private List<String> turmaList;
    private List<Disciplina> disciplinaList;

    public Professor(){}

    public Professor(String nome, String cpf, String rg, String cargo, Double salario, TipoPessoa tipo) {
        super(nome, cpf, rg, cargo, salario, tipo);
        this.turmaList = turmaList = new ArrayList<>();
        this.disciplinaList = new ArrayList<>();
        this.cargo = "Professor";
        this.tipo = TipoPessoa.PROFESSOR;
    }


    public List<Disciplina> getDisciplinaList() {
        return disciplinaList;
    }

    public void adicionaDisciplina (){
        Scanner scanner = new Scanner(System.in);
        boolean sair = true;
        while (sair){
            System.out.printf("\nNome Disciplina: ");
            //scanner.nextLine();
            String nome = scanner.nextLine();
            disciplinaList.add(new Disciplina(nome,null));
            System.out.printf("Cadastrar mais disciplinas? (s) sim ou (n) não: ");
            char continuar = Character.toUpperCase( scanner.next().charAt(0));
            sair = ( Character.compare(continuar, 'N') == 0 ? false : true );
            scanner.nextLine();
        }
    }

    public void adicionaTurma(){
        Scanner scanner = new Scanner(System.in);
        boolean sair = true;
        while (sair){
            System.out.printf("\nNome Turma: ");
            //scanner.nextLine();
            String nome = scanner.nextLine();
            turmaList.add(nome);
            System.out.printf("Cadastrar mais Turma? (s) sim ou (n) não: ");
            char continuar = Character.toUpperCase( scanner.next().charAt(0));
            sair = ( Character.compare(continuar, 'N') == 0 ? false : true );
            scanner.nextLine();
        }
    }

    public void modificaDisciplinas(){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < disciplinaList.size(); i++ ){
            System.out.printf("Disciplina: %s", disciplinaList.get(i).getNome());
            System.out.printf("\nNova Disciplina ou ENTER para não alterar: ");
            String novaDisciplina = scanner.nextLine();
            if ( !novaDisciplina.isBlank() ){
                disciplinaList.get(i).setNome(novaDisciplina);
            }
        }
    }

    public void modificaTurmas(){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < turmaList.size(); i++ ){
            System.out.printf("Turma: %s", turmaList.get(i));
            System.out.printf("\nNova Turma ou ENTER para não alterar: ");
            String novaTurma = scanner.nextLine();
            if ( !novaTurma.isBlank() ){
                turmaList.set(i, novaTurma);
            }
        }
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
        System.out.printf("Salário: %.2f", this.salario);
        System.out.printf("\nNovo Salário ou 0 (zero) para não alterar: ");
        Double novoSalario = scanner.nextDouble();
        this.salario = (novoSalario == 0 ? this.salario : novoSalario );
        if ( this.disciplinaList.isEmpty() ){
            System.out.println("Não existem Disciplinas Cadastradas para este professor");
            System.out.printf("Deseja cadastrar Disciplinas (s) ou (n)? ");
            if (Character.toUpperCase(scanner.next().charAt(0)) == 'S'){
                adicionaDisciplina();
            }
        } else {
            System.out.printf("Alterar Disciplinas (s) ou (n)? ");
            if (Character.toUpperCase(scanner.next().charAt(0)) == 'S') {
                modificaDisciplinas();
            }
        }

        if ( this.turmaList.isEmpty() ){
            System.out.println("Não existem Turmas Cadastradas para este professor");
            System.out.printf("Deseja cadastrar Turmas (s) ou (n)? ");
            if (Character.toUpperCase(scanner.next().charAt(0)) == 'S'){
                adicionaTurma();
            }
        } else {
            System.out.printf("Alterar Turmas (s) ou (n)? ");
            if (Character.toUpperCase(scanner.next().charAt(0)) == 'S') {
                modificaTurmas();
            }
        }
    }
    @Override
    public String toString() {
        String disciplinas = "";
        for (Disciplina disciplina : this.disciplinaList){
            disciplinas += "\n"+disciplina.getNome();
        }
        String turmas = "";
        for (String turma : this.turmaList){
            turmas += "\n"+turma;
        }
        return "{ Professor - nome: "+
                nome+
                "; CPF: "+
                cpf+
                "; RG: "+
                rg+
                "; Salário $ "+
                String.format("%.2f",salario)+
                "\nDisciplinas:"+
                disciplinas+
                "\nTurmas:"+
                turmas+
                " }";
    }

}
