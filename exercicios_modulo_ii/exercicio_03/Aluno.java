package exercicio_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aluno extends Pessoa{
    private Integer idade;
    private String turma;
    private List<Disciplina> disciplinaList = new ArrayList<>();

    public Aluno(String nome, String cpf, String rg, TipoPessoa tipo, Integer idade, String turma) {
        super(nome, cpf, rg, tipo);
        this.idade = idade;
        this.turma = turma;
        this.tipo = TipoPessoa.ALUNO;
        this.disciplinaList = new ArrayList<>();
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public void adicionaDisciplina (){
        Scanner scanner = new Scanner(System.in);
        boolean sair = true;
        while (sair){
            System.out.printf("\nNome Disciplina: ");
            //scanner.nextLine();
            String nome = scanner.nextLine();
            System.out.printf("Nota: ");
            Float nota = scanner.nextFloat();
            disciplinaList.add(new Disciplina(nome, nota));
            System.out.printf("Cadastrar mais disciplinas? (s) sim ou (n) não: ");
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
            System.out.printf("Nota da disciplina %s: %.2f", disciplinaList.get(i).getNome(), disciplinaList.get(i).getNota());
            System.out.printf("\nNova Nota ou 0 (zero) para não alterar: ");
            float novaNota = scanner.nextFloat();
            if (novaNota != disciplinaList.get(i).getNota() ){
                disciplinaList.get(i).setNota(novaNota);
            }
            scanner.nextLine();
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
        System.out.printf("Idade: %s", this.idade);
        System.out.printf("\nNova Idade ou 0 (zero) para não alterar: ");
        Integer novaIdade = scanner.nextInt();
        this.idade = (novaIdade == 0 ? this.idade : novaIdade );
        System.out.printf("Turma: %s", this.turma);
        System.out.printf("\nNova Turma ou ENTER para não alterar: ");
        scanner.nextLine();
        String novaTurma = scanner.nextLine();
        this.turma = (novaTurma.equals("") ? this.turma : novaTurma );
        if (this.disciplinaList.isEmpty()){
            System.out.println("Não existem disciplinas cadastradas para este Aluno");
            System.out.printf("Deseja cadastrar (s) ou (n)? ");
            if (Character.toUpperCase(scanner.next().charAt(0)) == 'S') {
                adicionaDisciplina();
            }
        } else {
            modificaDisciplinas();
        }

    }

    @Override
    public String toString() {
        String disciplinas = "";
        Double somaNotas = 0.0;
        for (Disciplina disciplina : disciplinaList){
            disciplinas += disciplina.getNome()+" - "+String.format("%.2f",disciplina.getNota())+"\n";
            somaNotas += disciplina.getNota();
        }
        return "{ ALUNO - nome: "+
                nome+
                "; CPF: "+
                cpf+
                "; RG: "+
                rg+
                "; Idade: "+
                idade+
                "; Turma: "+
                turma+
                "\nDisciplinas:\n"+
                disciplinas+
                "\nMédia das Notas:\n"+
                String.format("%.2f\n", ( somaNotas / disciplinaList.size() ))+
                " }";
    }
}
