package exercicio_02;

public class Produto {
    private String nome;
    private String sessao;
    private String tipo;
    private String marca;
    private int quantidadeEstoque;
    private long id;
    private static long geradorId = 0;

    public Produto(String nome, String sessao, String tipo, String marca, int quantidadeEstoque) {
        this.nome = nome;
        this.sessao = sessao;
        this.tipo = tipo;
        this.marca = marca;
        this.quantidadeEstoque = quantidadeEstoque;
        this.id = incrementaGeradorId();
    }

    private static Long incrementaGeradorId(){
        return ++geradorId;
    }

    public String getNome() {
        return nome;
    }

    public String getSessao() {
        return sessao;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMarca() {
        return marca;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public Long getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSessao(String sessao) {
        this.sessao = sessao;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void incrementaEstoque(int quantidadeIncremento){
        this.quantidadeEstoque += quantidadeIncremento;
    }

    public void decrementaEstoque(int quantidadeDecremento){
        this.quantidadeEstoque -= quantidadeDecremento;
    }

    @Override
    public String toString(){
        return "Id: "+this.id+
                " - "+this.nome+
                " - Sessão: "+ this.sessao+
                " - Marca: "+ this.marca+
                " - Tipo: "+ this.tipo+
                " - QtdEstoque: "+ this.quantidadeEstoque;

    }
}
