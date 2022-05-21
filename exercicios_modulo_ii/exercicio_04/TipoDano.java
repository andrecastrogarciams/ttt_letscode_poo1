package exercicio_04;

public enum TipoDano {
    PERFURANTE(1), PANCADA(2), FOGO(3);

    public int idDano;

    TipoDano(int idDano){
        this.idDano = idDano;
    }
}
