package exercicio_01;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Jogador> list = new ArrayList<>();
        Boolean exit = true;
        int id = 0;

        while (exit){
            id++;
            System.out.printf("Nome Jogador: ");
            String nomeJogador = scanner.nextLine();
            System.out.printf("Apelido Jogador: ");
            String apelidoJogador = scanner.nextLine();
            System.out.printf("Data Nascimento 'dd/MM/yyyy': ");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataNascimento = LocalDate.parse(scanner.nextLine(),formatter);
            System.out.printf("Número Camisa: ");
            int numero = scanner.nextInt();
            System.out.printf("Posição: ");
            scanner.nextLine();
            String posicao = scanner.nextLine();
            System.out.printf("Qualidade: ");
            double qualidade = scanner.nextInt();
            System.out.printf("Cartões Amarelos: ");
            int cartoesAmarelos = scanner.nextInt();
            System.out.printf("Cartão Vermelho: ");
            int cartaoVermelho = scanner.nextInt();
            Cartao cartao = new Cartao(cartaoVermelho,cartoesAmarelos);
            Jogador jogador = new Jogador(id, nomeJogador, apelidoJogador, dataNascimento, numero, posicao, qualidade,cartao);
            list.add(jogador);

            System.out.printf("Continuar (s/n)? ");
            char opcao = scanner.next().charAt(0);
            exit = (Character.toUpperCase(opcao) == 'S' ? true : false );
            scanner.nextLine();

        }

        for(Jogador jogador : list){
            System.out.println(jogador.toString());
        }

        scanner.close();
    }

}
