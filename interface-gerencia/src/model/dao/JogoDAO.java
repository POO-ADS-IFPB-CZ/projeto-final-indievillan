package model.dao;

import model.Jogo;

import java.util.ArrayList;
import java.util.List;

public class JogoDAO {
    private static final String FILE_NAME = "Jogo.csv";

    // Gera o próximo ID automaticamente
    private int getNextId() {
        int maxId = 0;
        for (Jogo j : findAll()) {
            if (j.getId() > maxId) maxId = j.getId();
        }
        return maxId + 1;
    }

    // CREATE
    public void save(Jogo j) {
        if (j.getId() == 0) {
            j.setId(getNextId());
        }

        String line = j.getId() + ";" + j.getTitulo() + ";" + j.getDescricao() + ";" + j.getStatus() + ";" + j.getDepartamentoId();
        CSVUtils.writeLine(FILE_NAME, line, true);
    }

    // READ
    public List<Jogo> findAll() {
        List<String> lines = CSVUtils.readAllLines(FILE_NAME);
        List<Jogo> jogos = new ArrayList<>();

        for (String line : lines) {
            String[] parts = line.split(";");
            if (parts.length == 5) {
                Jogo j = new Jogo(
                        Integer.parseInt(parts[0]),
                        parts[1],
                        parts[2],
                        parts[3],
                        Integer.parseInt(parts[4])
                );
                jogos.add(j);
            }
        }

        return jogos;
    }

    // UPDATE
    public void update(Jogo jogo) {
        List<Jogo> jogos = findAll();
        List<String> newLines = new ArrayList<>();

        for (Jogo j : jogos) {
            if (j.getId() == jogo.getId()) {
                j = jogo;
            }
            String line = j.getId() + ";" + j.getTitulo() + ";" + j.getDescricao() + ";" + j.getStatus() + ";" + j.getDepartamentoId();
            newLines.add(line);
        }

        CSVUtils.overwriteFile(FILE_NAME, newLines);
    }

    // DELETE
    public void delete(int id) {
        List<Jogo> jogos = findAll();
        List<String> newLines = new ArrayList<>();

        for (Jogo j : jogos) {
            if (j.getId() != id) {
                String line = j.getId() + ";" + j.getTitulo() + ";" + j.getDescricao() + ";" + j.getStatus() + ";" + j.getDepartamentoId();
                newLines.add(line);
            }
        }

        CSVUtils.overwriteFile(FILE_NAME, newLines);
    }
}
