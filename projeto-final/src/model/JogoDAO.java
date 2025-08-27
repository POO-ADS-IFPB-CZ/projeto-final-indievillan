// model/JogoDAO.java
package model;

import java.util.*;

public class JogoDAO {
    private String file = "jogos.csv";

    public void salvar(Jogo j) {
        List<Jogo> jogos = listar();
        jogos.add(j);
        escreverArquivo(jogos);
    }

    public List<Jogo> listar() {
        List<String[]> registros = CsvUtils.read(file);
        List<Jogo> jogos = new ArrayList<>();
        for (String[] r : registros) {
            if (r.length < 5) continue;
            jogos.add(new Jogo(
                    Integer.parseInt(r[0]), r[1], r[2], r[3], Integer.parseInt(r[4])
            ));
        }
        return jogos;
    }

    public Jogo buscarPorId(int id) {
        for (Jogo j : listar()) {
            if (j.getId() == id) return j;
        }
        return null;
    }

    public void atualizar(Jogo atualizado) {
        List<Jogo> jogos = listar();
        List<Jogo> novos = new ArrayList<>();
        for (Jogo j : jogos) {
            if (j.getId() == atualizado.getId()) {
                novos.add(atualizado);
            } else {
                novos.add(j);
            }
        }
        escreverArquivo(novos);
    }

    public void excluir(int id) {
        List<Jogo> jogos = listar();
        List<Jogo> novos = new ArrayList<>();
        for (Jogo j : jogos) {
            if (j.getId() != id) novos.add(j);
        }
        escreverArquivo(novos);
    }

    private void escreverArquivo(List<Jogo> jogos) {
        List<String> linhas = new ArrayList<>();
        for (Jogo j : jogos) {
            linhas.add(j.toString());
        }
        CsvUtils.write(file, linhas);
    }
}
