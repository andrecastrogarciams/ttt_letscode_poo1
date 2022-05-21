package exercicio_04;

public class Vampiro extends Personagem {

    public Vampiro(String nome, Integer vida) {
        super(nome, vida);
    }

    public Integer ataque(){
        System.out.println("Causou 20 de dano");
        System.out.println("seu personagem está sangrando");
        return 20;
    }

    public void apanhar(Integer dano, TipoDano tipoDano){
        if (tipoDano == TipoDano.PERFURANTE) {
            dano *= 2;
        }
        System.out.println("Recebeu "+ dano +" de dano");
        this.vida -= dano;
        this.vida = (this.vida <= 0 ? 0 : this.vida);
    }

    public void interagir(){
        System.out.println("O que é um homem");
    }
}
