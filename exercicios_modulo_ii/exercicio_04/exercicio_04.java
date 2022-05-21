package exercicio_04;

import java.util.Scanner;

public class exercicio_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Boolean sair = true;
        Jogo jogo = new Jogo("Jogo");


        while(sair){
            System.out.println("**** Escolha uma Opção ****");
            System.out.println("(0) - Sair");
            System.out.println("(1) - Criar Personagem");
            System.out.println("(2) - Listar Personagens Criados");
            System.out.println("(3) - Embate entre Personagens");
            System.out.printf(": ");
            int opcao = scanner.nextInt();
            switch (opcao){
                case 0:
                    sair = false;
                    break;
                case 1:
                    jogo.criarPersonagem();
                    break;
                case 2:
                    jogo.listarPersonagens();
                    break;
                case 3:
                    jogo.embatePersonagens();
                    jogo.listarPersonagens();
                    break;
                default:
                    System.out.printf("Opção Inválida");
                    break;
            }

        }

        scanner.close();

    }
}
