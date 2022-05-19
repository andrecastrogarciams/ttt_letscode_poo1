package exercicio_03;

public abstract class Pessoa {
    protected String nome;
    protected String cpf;
    protected String rg;
    protected TipoPessoa tipo;

    public  Pessoa(){};

    public Pessoa(String nome, String cpf, String rg, TipoPessoa tipo) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.tipo = tipo;
    }

    public abstract String toString();

    public abstract void modificaPessoa();


}
