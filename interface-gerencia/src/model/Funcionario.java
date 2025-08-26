package model;

import java.util.Date;

public class Funcionario {
    private int id;
    private String cpf;
    private String genero;
    private String nome;
    private String telefone;
    private Date dataAdmissao;
    private Date dataSaida; // Não será exibido, mas faz parte do modelo, vou deixar por enquanto
    private int departamentoId;

    public Funcionario(int id, String cpf, String genero, String nome, String telefone, Date dataAdmissao, Date dataSaida, int departamentoId) {
        this.id = id;
        this.cpf = cpf;
        this.genero = genero;
        this.nome = nome;
        this.telefone = telefone;
        this.dataAdmissao = dataAdmissao;
        this.dataSaida = dataSaida;
        this.departamentoId = departamentoId;
    }

    //Getters e Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }
    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Date getDataSaida() {
        return dataSaida;
    }
    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public int getDepartamentoId() {
        return departamentoId;
    }
    public void setDepartamentoId(int departamentoId) {
        this.departamentoId = departamentoId;
    }

    // toString
    @Override
    public String toString() {
        return id + " - " + nome;
    }
}
