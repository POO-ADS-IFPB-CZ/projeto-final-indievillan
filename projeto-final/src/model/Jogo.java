// model/Jogo.java
package model;

public class Jogo {
    private int id;
    private String titulo;
    private String descricao;
    private String status;
    private int departamentoId;

    public Jogo(int id, String titulo, String descricao, String status, int departamentoId) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.departamentoId = departamentoId;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public String getStatus() { return status; }
    public int getDepartamentoId() { return departamentoId; }

    @Override
    public String toString() {
        return id + ";" + titulo + ";" + descricao + ";" + status + ";" + departamentoId;
    }
}
