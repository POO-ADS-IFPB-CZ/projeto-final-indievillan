// controller/DepartamentoController.java
package controller;

import model.*;
import java.util.*;

public class DepartamentoController {
    private DepartamentoDAO dao = new DepartamentoDAO();

    public void salvar(Departamento d) { dao.salvar(d); }
    public List<Departamento> listar() { return dao.listar(); }
    public Departamento buscarPorId(int id) { return dao.buscarPorId(id); }
    public void atualizar(Departamento d) { dao.atualizar(d); }
    public void excluir(int id) { dao.excluir(id); }
}
