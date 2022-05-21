package exercicio_04;

public abstract class Personagem {
    protected String nome;
    protected Integer vida;

    public Personagem(String nome, Integer vida) {
        this.nome = nome;
        this.vida = vida;
    }

    public abstract Integer ataque();
    public abstract void apanhar(Integer dano, TipoDano tipoDano);
    public abstract void interagir();

}
