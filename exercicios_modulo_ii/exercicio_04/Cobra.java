package exercicio_04;

public class Cobra extends Personagem{

    public Cobra(String nome, Integer vida) {
        super(nome, vida);
    }

    public Integer ataque(){
        System.out.println("Causou 10 de dano");
        System.out.println("seu personagem está envenenado");
        return 10;
    }

    public void apanhar(Integer dano, TipoDano tipoDano){
        if (tipoDano == TipoDano.PANCADA){
            dano *= 2;
        }
        System.out.println("Recebeu "+ dano +" de dano");
        this.vida -= dano;
        this.vida = (this.vida <= 0 ? 0 : this.vida);
    }

    public void interagir(){
        System.out.println("Se você acender a chama, a maldição acaba");
    }
}
