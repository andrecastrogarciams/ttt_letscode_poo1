package exercicio_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Escola {
    private String nome;
    private List<Pessoa> pessoaList;

    public Escola(String nome) {
        this.nome = nome;
        this.pessoaList = new ArrayList<Pessoa>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Pessoa> getPessoaList() {
        return pessoaList;
    }

    public Pessoa buscarPessoa(String stringBusca){
        for (Pessoa pessoa : this.pessoaList){
            if (pessoa.cpf.equals(stringBusca) || pessoa.nome.equals(stringBusca)){
                return pessoa;
            }
        }
        return null;
    }

    public void inserirPessoa(TipoPessoa tipoPessoa){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("CPF: ");
        String cpf = scanner.nextLine();
        Pessoa pessoaBusca = buscarPessoa(cpf);
        if (pessoaBusca != null){
            System.out.println("CPF já possui cadastro");
            System.out.println(pessoaBusca);
        } else {
            System.out.printf("Nome: ");
            String nome = scanner.nextLine();
            System.out.printf("RG: ");
            String rg = scanner.nextLine();
            if (tipoPessoa == TipoPessoa.FUNCIONARIO || tipoPessoa == TipoPessoa.PROFESSOR){
                System.out.printf("Salário: ");
                Double salario = scanner.nextDouble();
                String cargo = new String();
                if (tipoPessoa == TipoPessoa.FUNCIONARIO ) {
                    System.out.printf("Cargo: ");
                    scanner.nextLine();
                    cargo = scanner.nextLine();
                    pessoaList.add(new Funcionario(nome, cpf, rg, cargo, salario, tipoPessoa));
                } else {
                    cargo = "Professor";
                    Professor novoProfessor = new Professor(nome, cpf, rg, cargo, salario, tipoPessoa);
                    System.out.printf("Cadastrar Disciplina? (s) sim ou (n) não: ");
                    if (Character.toUpperCase( scanner.next().charAt(0)) == 'S' ){
                        novoProfessor.adicionaDisciplina();
                    }
                    System.out.printf("Cadastrar Turma? (s) sim ou (n) não: ");
                    if (Character.toUpperCase( scanner.next().charAt(0)) == 'S' ){
                        novoProfessor.adicionaTurma();
                    }
                    pessoaList.add(novoProfessor);
                }

            } else if (tipoPessoa == TipoPessoa.ALUNO){
                System.out.printf("Idade: ");
                int idade = scanner.nextInt();
                System.out.printf("Turma: ");
                scanner.nextLine();
                String turma = scanner.nextLine();
                Aluno novoAluno = new Aluno(nome, cpf, rg, TipoPessoa.ALUNO, idade, turma);
                System.out.println("Adicionar Discipllinas (s) ou (n)?");
                if ( Character.toUpperCase(scanner.next().charAt(0)) == 'S' ){
                    novoAluno.adicionaDisciplina();
                }

                pessoaList.add(novoAluno);
            }

        }
    }

    public void listarPessoa(TipoPessoa tipoPessoa){
        System.out.println("***** "+ this.nome +" *****");
        for(Pessoa pessoa : pessoaList){
            if (pessoa.tipo == tipoPessoa){
                System.out.println(pessoa);
            }
        }
        System.out.printf("\n\n");
    }

    public void modificaPessoa(String cpf){
        for (int i = 0; i < this.pessoaList.size(); i++){
            if (this.pessoaList.get(i).cpf.equals(cpf)){
                this.pessoaList.get(i).modificaPessoa();
                System.out.println("Modificação realizada com Sucesso!");
                break;
            }
        }
    }

    public void excluiPessoa(String cpf){
        for (int i = 0; i < this.pessoaList.size(); i++){
            if (this.pessoaList.get(i).cpf.equals(cpf)){
                this.pessoaList.remove(i);
                System.out.println("Exlusão realizada com Sucesso!");
                break;
            }
        }
    }
}
