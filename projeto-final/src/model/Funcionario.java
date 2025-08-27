// model/Funcionario.java
package model;

public class Funcionario {
    private int id;
    private String cpf;
    private String genero;
    private String nome;
    private String telefone;
    private String dataAdmissao;
    private String dataSaida;
    private int departamentoId;

    public Funcionario(int id, String cpf, String genero, String nome,
                       String telefone, String dataAdmissao, String dataSaida, int departamentoId) {
        this.id = id;
        this.cpf = cpf;
        this.genero = genero;
        this.nome = nome;
        this.telefone = telefone;
        this.dataAdmissao = dataAdmissao;
        this.dataSaida = dataSaida;
        this.departamentoId = departamentoId;
    }

    // Getters e Setters
    public int getId() { return id; }
    public String getCpf() { return cpf; }
    public String getGenero() { return genero; }
    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }
    public String getDataAdmissao() { return dataAdmissao; }
    public String getDataSaida() { return dataSaida; }
    public int getDepartamentoId() { return departamentoId; }

    @Override
    public String toString() {
        return id + ";" + cpf + ";" + genero + ";" + nome + ";" + telefone + ";" +
                dataAdmissao + ";" + dataSaida + ";" + departamentoId;
    }
}
