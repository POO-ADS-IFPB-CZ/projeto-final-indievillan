package model.dao;

import model.Departamento;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DepartamentoDAO {
    private static final String FILE_NAME = "Departamento.csv";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    // Gera o próximo ID automaticamente
    private int getNextId() {
        int maxId = 0;
        for (Departamento d : findAll()) {
            if (d.getId() > maxId) maxId = d.getId();
        }
        return maxId + 1;
    }

    // CREATE
    public void save(Departamento d) {
        if (d.getId() == 0) {
            d.setId(getNextId());
        }

        String dataCriacao = d.getDataCriacao() != null ? DATE_FORMAT.format(d.getDataCriacao()) : "";

        String line = d.getId() + ";" + d.getNome() + ";" + dataCriacao;
        CSVUtils.writeLine(FILE_NAME, line, true);
    }

    // READ
    public List<Departamento> findAll() {
        List<String> lines = CSVUtils.readAllLines(FILE_NAME);
        List<Departamento> departamentos = new ArrayList<>();

        for (String line : lines) {
            String[] parts = line.split(";");
            if (parts.length == 3) {
                try {
                    Date dataCriacao = parts[2].isEmpty() ? null : DATE_FORMAT.parse(parts[2]);
                    Departamento d = new Departamento(
                            Integer.parseInt(parts[0]),
                            parts[1],
                            dataCriacao
                    );
                    departamentos.add(d);
                } catch (ParseException e) {
                    e.printStackTrace(); // erro de parsing, ignora a linha
                }
            }
        }

        return departamentos;
    }

    // UPDATE
    public void update(Departamento departamento) {
        List<Departamento> departamentos = findAll();
        List<String> newLines = new ArrayList<>();

        for (Departamento d : departamentos) {
            if (d.getId() == departamento.getId()) {
                d = departamento;
            }

            String dataCriacao = d.getDataCriacao() != null ? DATE_FORMAT.format(d.getDataCriacao()) : "";
            String line = d.getId() + ";" + d.getNome() + ";" + dataCriacao;
            newLines.add(line);
        }

        CSVUtils.overwriteFile(FILE_NAME, newLines);
    }

    // DELETE
    public void delete(int id) {
        List<Departamento> departamentos = findAll();
        List<String> newLines = new ArrayList<>();

        for (Departamento d : departamentos) {
            if (d.getId() != id) {
                String dataCriacao = d.getDataCriacao() != null ? DATE_FORMAT.format(d.getDataCriacao()) : "";
                String line = d.getId() + ";" + d.getNome() + ";" + dataCriacao;
                newLines.add(line);
            }
        }

        CSVUtils.overwriteFile(FILE_NAME, newLines);
    }
}
