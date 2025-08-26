package model;

public class Jogo {
    private int id;
    private String titulo;
    private int departamentoId; // FK

    public Jogo() {}

    public Jogo(int id, String titulo, int departamentoId) {
        this.id = id;
        this.titulo = titulo;
        this.departamentoId = departamentoId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public int getDepartamentoId() { return departamentoId; }
    public void setDepartamentoId(int departamentoId) { this.departamentoId = departamentoId; }

    @Override
    public String toString() {
        return id + " - " + titulo;
    }
}
