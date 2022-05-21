package exercicio_04;

public class Generico extends Personagem{

    public Generico(String nome, Integer vida) {
        super(nome, vida);
    }

    public Integer ataque(){
        System.out.println("Causou 10 de dano");
        return 10;
    }

    public void apanhar(Integer dano, TipoDano tipoDano){
        System.out.println("Recebeu "+ dano +" de dano");
        this.vida -= dano;
        this.vida = (this.vida <= 0 ? 0 : this.vida);
    }

    public void interagir(){
        System.out.println("Porque eu responderia meu inimigo");
    }

}
