package exercicio_02;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Boolean sair = true;
        System.out.printf("Informe um nome para o estoque: ");
        String nomeEstoque = scanner.nextLine();
        Estoque estoque = new Estoque(nomeEstoque);

        while (sair) {

            String nomeProduto = new String();
            String nomePesquisa = new String();
            String sessaoProduto = new String();
            String tipoProduto = new String();
            String marcaProduto = new String();
            String marcaPesquisa = new String();
            int quantidadeEstoqueProduto = 0;

            System.out.printf("\n\nEscolha uma opção:\n");
            System.out.println("(1) - Inserir produto novo");
            System.out.println("(2) - Editar produto");
            System.out.println("(3) - Mostrar um produto");
            System.out.println("(4) - Excluir um produto");
            System.out.println("(5) - Listar Produtos Estoque");
            System.out.println("(6) - Editar nome do estoque");
            System.out.println("(0) - Sair");
            System.out.printf("Opção: ");
            int opcao = scanner.nextInt();

            System.out.printf("\n\n\n");

            switch (opcao) {
                case 0:
                    sair = false;
                    break;

                case 1:
                    System.out.println("*** Inserir Novo Produto ****");
                    System.out.printf("Nome: ");
                    scanner.nextLine();
                    nomeProduto = scanner.nextLine();
                    System.out.printf("Sessão: ");
                    sessaoProduto = scanner.nextLine();
                    System.out.printf("Marca: ");
                    marcaProduto = scanner.nextLine();
                    System.out.printf("Tipo: ");
                    tipoProduto = scanner.nextLine();
                    System.out.printf("Quantidade Estoque: ");
                    quantidadeEstoqueProduto = scanner.nextInt();
                    Produto produto = new Produto(nomeProduto, sessaoProduto, tipoProduto, marcaProduto, quantidadeEstoqueProduto);
                    estoque.novoProduto(produto);
                    break;

                case 2:
                    System.out.println("*** Editar Produto ***");
                    System.out.printf("Nome produto que vai editar: ");
                    scanner.nextLine();
                    nomePesquisa = scanner.nextLine();
                    System.out.printf("Marca produto que vai editar: ");
                    marcaPesquisa = scanner.nextLine();
                    System.out.printf("Novo nome ou ENTER para manter o atual: ");
                    nomeProduto = scanner.nextLine();
                    nomeProduto = (nomeProduto.equals("") ? null : nomeProduto);
                    System.out.printf("Nova marca ou ENTER para manter a atual: ");
                    marcaProduto = scanner.nextLine();
                    marcaProduto = (marcaProduto.equals("") ? null : marcaProduto);
                    System.out.printf("Nova sessão ou ENTER para manter a atual: ");
                    sessaoProduto = scanner.nextLine();
                    sessaoProduto = (sessaoProduto.equals("") ? null : sessaoProduto);
                    System.out.printf("Novo tipo ou ENTER para manter o atual: ");
                    tipoProduto = scanner.nextLine();
                    tipoProduto = (tipoProduto.equals("") ? null : tipoProduto);
                    estoque.editaProduto(nomePesquisa, marcaPesquisa, nomeProduto, marcaProduto, sessaoProduto, tipoProduto);
                    break;

                case 3:
                    System.out.println("*** Mostrar Produto ***");
                    scanner.nextLine();
                    System.out.printf("Nome: ");
                    nomePesquisa = scanner.nextLine();
                    System.out.printf("Marca: ");
                    marcaPesquisa = scanner.nextLine();
                    estoque.imprimeProduto(nomePesquisa, marcaPesquisa);
                    break;

                case 4:
                    System.out.printf("*** Excluir Produto ***");
                    scanner.nextLine();
                    System.out.printf("Nome: ");
                    nomePesquisa = scanner.nextLine();
                    System.out.printf("Marca: ");
                    marcaPesquisa = scanner.nextLine();
                    estoque.deletaProduto(nomePesquisa, marcaPesquisa);
                    break;

                case 5:
                    System.out.println("*** Lista Produtos - Estoque "+estoque.nome+" ***");
                    estoque.listarProdutos();
                    break;

                case 6:
                    System.out.println("*** Editar Nome Estoque ***");
                    scanner.nextLine();
                    System.out.printf("Novo Nome: ");
                    nomeEstoque = scanner.nextLine();
                    estoque.nome = nomeEstoque;
                    break;

                default:
                    System.out.println("*** OPÇÃO INVÁLIDA ***");
                    break;
            }

        }

        scanner.close();
    }
}
