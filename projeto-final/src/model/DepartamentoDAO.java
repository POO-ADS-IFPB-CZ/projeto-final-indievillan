// model/DepartamentoDAO.java
package model;

import java.util.*;

public class DepartamentoDAO {
    private String file = "departamentos.csv";

    public void salvar(Departamento d) {
        List<Departamento> departamentos = listar();
        departamentos.add(d);
        escreverArquivo(departamentos);
    }

    public List<Departamento> listar() {
        List<String[]> registros = CsvUtils.read(file);
        List<Departamento> departamentos = new ArrayList<>();
        for (String[] r : registros) {
            if (r.length < 3) continue;
            departamentos.add(new Departamento(
                    Integer.parseInt(r[0]), r[1], r[2]
            ));
        }
        return departamentos;
    }

    public Departamento buscarPorId(int id) {
        for (Departamento d : listar()) {
            if (d.getId() == id) return d;
        }
        return null;
    }

    public void atualizar(Departamento atualizado) {
        List<Departamento> departamentos = listar();
        List<Departamento> novos = new ArrayList<>();
        for (Departamento d : departamentos) {
            if (d.getId() == atualizado.getId()) {
                novos.add(atualizado);
            } else {
                novos.add(d);
            }
        }
        escreverArquivo(novos);
    }

    public void excluir(int id) {
        List<Departamento> departamentos = listar();
        List<Departamento> novos = new ArrayList<>();
        for (Departamento d : departamentos) {
            if (d.getId() != id) novos.add(d);
        }
        escreverArquivo(novos);
    }

    private void escreverArquivo(List<Departamento> departamentos) {
        List<String> linhas = new ArrayList<>();
        for (Departamento d : departamentos) {
            linhas.add(d.toString());
        }
        CsvUtils.write(file, linhas);
    }
}
