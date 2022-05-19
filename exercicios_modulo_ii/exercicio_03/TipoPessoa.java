package exercicio_03;

public enum TipoPessoa {
    ALUNO(1), PROFESSOR(2), FUNCIONARIO(3);

    private int valor;

    TipoPessoa(int valor){
        this.valor = valor;
    }

    public int getValor(){
        return valor;
    }
}
