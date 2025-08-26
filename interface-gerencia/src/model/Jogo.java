package model;

public class Jogo {
    private int id;
    private String titulo;
    private String descricao;
    private String status;
    private int departamentoId; // FK

    public Jogo() {}

    public Jogo(int id, String titulo, String descricao, String status, int departamentoId) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.departamentoId = departamentoId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public int getDepartamentoId() { return departamentoId; }
    public void setDepartamentoId(int departamentoId) { this.departamentoId = departamentoId; }

    @Override
    public String toString() {
        return id + " - " + titulo;
    }
}
