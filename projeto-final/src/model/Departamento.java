// model/Departamento.java
package model;

public class Departamento {
    private int id;
    private String nome;
    private String dataCriacao;

    public Departamento(int id, String nome, String dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.dataCriacao = dataCriacao;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getDataCriacao() { return dataCriacao; }

    @Override
    public String toString() {
        return id + ";" + nome + ";" + dataCriacao;
    }
}
