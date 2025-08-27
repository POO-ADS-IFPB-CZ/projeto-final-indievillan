// model/FuncionarioDAO.java
package model;

import java.util.*;

public class FuncionarioDAO {
    private String file = "funcionarios.csv";

    public void salvar(Funcionario f) {
        List<Funcionario> funcionarios = listar();
        funcionarios.add(f);
        escreverArquivo(funcionarios);
    }

    public List<Funcionario> listar() {
        List<String[]> registros = CsvUtils.read(file);
        List<Funcionario> funcionarios = new ArrayList<>();
        for (String[] r : registros) {
            if (r.length < 8) continue;
            funcionarios.add(new Funcionario(
                    Integer.parseInt(r[0]), r[1], r[2], r[3], r[4], r[5], r[6], Integer.parseInt(r[7])
            ));
        }
        return funcionarios;
    }

    public Funcionario buscarPorId(int id) {
        for (Funcionario f : listar()) {
            if (f.getId() == id) return f;
        }
        return null;
    }

    public void atualizar(Funcionario atualizado) {
        List<Funcionario> funcionarios = listar();
        List<Funcionario> novos = new ArrayList<>();
        for (Funcionario f : funcionarios) {
            if (f.getId() == atualizado.getId()) {
                novos.add(atualizado);
            } else {
                novos.add(f);
            }
        }
        escreverArquivo(novos);
    }

    public void excluir(int id) {
        List<Funcionario> funcionarios = listar();
        List<Funcionario> novos = new ArrayList<>();
        for (Funcionario f : funcionarios) {
            if (f.getId() != id) novos.add(f);
        }
        escreverArquivo(novos);
    }

    private void escreverArquivo(List<Funcionario> funcionarios) {
        List<String> linhas = new ArrayList<>();
        for (Funcionario f : funcionarios) {
            linhas.add(f.toString());
        }
        CsvUtils.write(file, linhas);
    }
}
