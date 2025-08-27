// controller/JogoController.java
package controller;

import model.*;
import java.util.*;

public class JogoController {
    private JogoDAO dao = new JogoDAO();

    public void salvar(Jogo j) { dao.salvar(j); }
    public List<Jogo> listar() { return dao.listar(); }
    public Jogo buscarPorId(int id) { return dao.buscarPorId(id); }
    public void atualizar(Jogo j) { dao.atualizar(j); }
    public void excluir(int id) { dao.excluir(id); }
}
