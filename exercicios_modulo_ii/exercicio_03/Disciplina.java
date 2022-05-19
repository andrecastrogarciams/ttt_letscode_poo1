package exercicio_03;


public class Disciplina {
    private String nome;
    private Professor professor = new Professor();
    private Float nota;

    public Disciplina(String nome, Float nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }
}
