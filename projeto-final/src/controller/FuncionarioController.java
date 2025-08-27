// controller/FuncionarioController.java
package controller;

import model.*;
import java.util.*;

public class FuncionarioController {
    private String file = "funcionarios.csv";

    public void salvar(Funcionario f) {
        List<String[]> registros = CsvUtils.read(file);
        List<String> linhas = new ArrayList<>();
        for (String[] r : registros) linhas.add(String.join(";", r));
        linhas.add(f.toString());
        CsvUtils.write(file, linhas);
    }

    public List<Funcionario> listar() {
        List<String[]> registros = CsvUtils.read(file);
        List<Funcionario> funcionarios = new ArrayList<>();
        for (String[] r : registros) {
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

    public void excluir(int id) {
        List<Funcionario> funcionarios = listar();
        List<String> linhas = new ArrayList<>();
        for (Funcionario f : funcionarios) {
            if (f.getId() != id) linhas.add(f.toString());
        }
        CsvUtils.write(file, linhas);
    }
}
