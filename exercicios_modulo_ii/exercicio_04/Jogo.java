package exercicio_04;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Jogo {
    private String nome;
    private List<Personagem> personagemList;

    public Jogo (String nome){
        this.nome = nome;
        this.personagemList = new ArrayList<Personagem>();
    }

    public void criarPersonagem(){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\nInforme um nome para o personagem: ");
        String nomePersonagem = scanner.nextLine();
        System.out.printf("Qual o tipo de personagem ?");
        System.out.printf("\n(1) - Genérico");
        System.out.printf("\n(2) - Vampiro");
        System.out.printf("\n(3) - Cobra");
        System.out.printf("\n(4) - Gigante");
        System.out.printf("\n: ");
        int tipoPersonagem = scanner.nextInt();
        switch (tipoPersonagem){
            case 1:
                personagemList.add(new Generico(nomePersonagem,100));
                break;
            case 2:
                personagemList.add(new Vampiro(nomePersonagem,100));
                break;
            case 3:
                personagemList.add(new Cobra(nomePersonagem,100));
                break;
            case 4:
                personagemList.add(new Gigante(nomePersonagem,100));
                break;
            default:
                System.out.printf("Opção Inválida");
                break;
        }
    }

    public void listarPersonagens(){
        int i = 0;
        for (Personagem personagem : personagemList){
            i++;
            if (personagem instanceof Generico){
                System.out.println("("+ i +") "+ personagem.nome+" (GENÉRICO) - Vida: "+personagem.vida);
            }
            if (personagem instanceof Vampiro){
                System.out.println("("+ i +") "+ personagem.nome+" (VAMPIRO) - Vida: "+personagem.vida);
            }

            if (personagem instanceof Cobra){
                System.out.println("("+ i +") "+ personagem.nome+" (COBRA) - Vida: "+personagem.vida);
            }
            if (personagem instanceof Gigante){
                System.out.println("("+ i +") "+ personagem.nome+" (GIGANTE) - Vida: "+personagem.vida);
            }
        }
    }

    public void embatePersonagens(){
        Scanner scanner = new Scanner(System.in);
        listarPersonagens();
        Random random = new Random();
        System.out.printf("Escolha o jogador 1: ");
        int jogador1 = scanner.nextInt() - 1;
        System.out.printf("Escolha o JOGADOR 2: ");
        int jogador2 = scanner.nextInt() - 1;
        int ataque = random.nextInt(2) + 1;
        int idDano = random.nextInt(3) + 1;
        TipoDano tipoDano;
        int dano = 0;
        if (idDano == 1){
            tipoDano = TipoDano.PERFURANTE;
        } else if (idDano == 2){
            tipoDano = TipoDano.PANCADA;
        } else {
            tipoDano = TipoDano.FOGO;
        }
        if (ataque == 1){
            System.out.printf("\n\n");
            System.out.println("**** "+personagemList.get(jogador1).nome+" ****");
            dano = personagemList.get(jogador1).ataque();
            System.out.printf("\n");
            System.out.println("**** "+personagemList.get(jogador2).nome +" ****");
            personagemList.get(jogador2).apanhar(dano, tipoDano );
            System.out.printf("\n\n");
        } else if (ataque == 2){
            System.out.printf("\n\n");
            System.out.println("**** "+personagemList.get(jogador2).nome+" ****");
            dano = personagemList.get(jogador2).ataque();
            System.out.printf("\n");
            System.out.println("**** "+personagemList.get(jogador1).nome +" ****");
            personagemList.get(jogador1).apanhar(dano, tipoDano );
            System.out.printf("\n\n");
        }



    }
}
