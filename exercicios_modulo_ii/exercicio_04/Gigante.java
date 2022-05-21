package exercicio_04;

public class Gigante extends Personagem{

    public Gigante(String nome, Integer vida) {
        super(nome, vida);
    }

    public Integer ataque(){
        System.out.println("Causou 25 de dano");
        System.out.println("seu personagem está atordoado");
        return 25;
    }

    public void apanhar(Integer dano, TipoDano tipoDano){
        if (tipoDano == TipoDano.FOGO){
            dano *= 2;
        }
        System.out.println("Recebeu "+ dano +" de dano");
        this.vida -= dano;
        this.vida = (this.vida <= 0 ? 0 : this.vida);
    }

    public void interagir(){
        System.out.println("Me desculpe");
    }
}
