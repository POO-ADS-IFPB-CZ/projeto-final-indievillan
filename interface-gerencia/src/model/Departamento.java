package model;

import java.util.Date;

public class Departamento {
    private int id;
    private String nome;
    private Date dataCriacao;

    public Departamento() {}

    public Departamento(int id, String nome, Date dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.dataCriacao = dataCriacao;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Date getDataCriacao() {
        return dataCriacao;
    }
    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public String toString() {
        return id + " - " + nome;
    }
}
