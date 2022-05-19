package exercicio_01;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Jogador {
    Integer id;
    String nome;
    String apelido;
    LocalDate dataNascimento;
    Integer numero;
    String posicao;
    Double qualidade;
    Cartao cartao;
    Boolean suspenso;
    Boolean partidaJogada;
    Boolean treinamento;

    public Jogador(){
        //construtor vazio
    }

    Jogador(Integer id, String nome, String apelido, LocalDate dataNascimento, Integer numero, String posicao, Double qualidade, Cartao cartao) {
        this.id = id;
        this.nome = nome;
        this.apelido = apelido;
        this.dataNascimento = dataNascimento;
        this.numero = numero;
        this.posicao = posicao;
        this.qualidade = qualidade;
        this.cartao = cartao;
    }

    Boolean verificarCondicaoDeJogo (){
        if (this.cartao.amarelo < 3 && this.cartao.vermelho == 0){
            return true;
        }
        return false;
    }

    void aplicarCartaoAmarelo (Integer quantidade){
        this.cartao.amarelo += quantidade;
    }

    void aplicarCartaoVermelho (){
        this.cartao.vermelho = 1;
    }

    void cumprirSuspensao(){
        this.cartao.vermelho = 0;
        this.cartao.amarelo = 0;
    }

    public String toString (){
        return "Atacante - "+this.nome+"( "+this.apelido+" ) - "+dataNascimento.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+
    " - Condição: "+( verificarCondicaoDeJogo() ? "Pode Jogar" : "Não Pode Jogar" );
    }

    public void sofrerLesao (){
        Random random = new Random();
        int gravidadeLesao = (random.nextInt(99) + 1);
        if (gravidadeLesao <= 5){
            this.qualidade -= this.qualidade * 0.15;
        } else if(gravidadeLesao <= 10){
            this.qualidade -= this.qualidade * 0.10;
        } else if (gravidadeLesao <= 15){
            this.qualidade -= this.qualidade * 0.05;
        } else if (gravidadeLesao <= 30){
            this.qualidade -= 2;
        } else if (gravidadeLesao <= 40){
            this.qualidade -= 1;
        }

        this.qualidade = (this.qualidade < 0 ? 0 : this.qualidade);
    }

    public void executarTreinamento(){
        Random random = new Random();
        if (this.treinamento == false && this.partidaJogada == false){
            this.qualidade += random.nextInt(2)+1;
            this.treinamento = true;
        }
    }
}
