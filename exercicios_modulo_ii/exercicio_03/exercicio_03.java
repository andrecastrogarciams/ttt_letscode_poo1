package exercicio_03;

import java.util.List;
import java.util.Scanner;

public class exercicio_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Nome da Escola: ");
        Escola escola = new Escola(scanner.nextLine());

        boolean sair = true;
        while (sair) {

            System.out.println("***** Escolha uma Opção *****");
            System.out.println("(0) - Sair");
            System.out.println("(1) - Cadastrar Pessoa");
            System.out.println("(2) - Listar Pessoas");
            System.out.println("(3) - Pesquisar uma Pessoa");
            System.out.println("(4) - Modificar uma Pessoa");
            System.out.println("(5) - Excluir uma Pessoa");
            System.out.println("(6) - Calcular Média de um Aluno");
            System.out.printf(": ");
            int opcao = scanner.nextInt();
            TipoPessoa tipoPessoa;
            switch (opcao) {
                case 0:
                    sair = false;
                    break;

                case 1:
                    System.out.printf("*** Cadastrar Pessoa ***\n");
                    tipoPessoa = escolhaTipoPessoa();
                    if (tipoPessoa != null) {
                        escola.inserirPessoa(tipoPessoa);
                    }
                    break;
                case 2:
                    System.out.printf("*** Listar Pessoas ***\n");
                    tipoPessoa = escolhaTipoPessoa();
                    if (tipoPessoa != null) {
                        escola.listarPessoa(tipoPessoa);
                    }
                    break;
                case 3:
                    System.out.printf("*** Pesquisar uma Pessoa ***\n");
                    Pessoa pessoaBusca = buscarPessoa(escola);
                    if (pessoaBusca != null){
                        System.out.println(pessoaBusca);
                    } else {
                        System.out.println("PESSOA NÃO ENCONTRADA");
                    }
                    break;
                case 4:
                    System.out.printf("*** Modificar Pessoas ***\n");
                    Pessoa modificaPessoa = buscarPessoa(escola);
                    if (modificaPessoa != null){
                            escola.modificaPessoa(modificaPessoa.cpf);
                    } else {
                        System.out.println("PESSOA NÃO ENCONTRADA");
                    }
                    break;
                case 5:
                    System.out.printf("*** Excluir uma Pessoa ***\n");
                    Pessoa pessoaExclui = buscarPessoa(escola);
                    if (pessoaExclui != null){
                        escola.excluiPessoa(pessoaExclui.cpf);
                    } else {
                        System.out.println("PESSOA NÃO ENCONTRADA");
                    }
                    break;
                case 6:
                    System.out.printf("*** Calcular Média de uma Aluno ***\n");
                    Pessoa pessoaMedia = buscarPessoa(escola);
                    if (pessoaMedia != null && pessoaMedia.tipo == TipoPessoa.ALUNO){
                        System.out.println(pessoaMedia);
                    } else {
                        System.out.println("ALUNO NÃO ENCONTRADO");
                    }
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        }
    }

    public static TipoPessoa escolhaTipoPessoa(){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Escolha um tipo:\n(1) Aluno\n(2) Professor\n(3) Funcionário\n:");
        int tipo = scanner.nextInt();
        switch (tipo) {
            case 1:
                return TipoPessoa.ALUNO;
            case 2:
                return TipoPessoa.PROFESSOR;
            case 3:
                return TipoPessoa.FUNCIONARIO;
            default:
                System.out.println("Tipo de Pessoa Inválido");
                break;
        }
        System.out.printf("\n\n");
        return null;
    }

    public static Pessoa buscarPessoa(Escola escola){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("CPF ou Nome para busca: ");
        String stringBusca = scanner.nextLine();
        Pessoa pessoaBusca = escola.buscarPessoa(stringBusca);
        return pessoaBusca;
    }

}
