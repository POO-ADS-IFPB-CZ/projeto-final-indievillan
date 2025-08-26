package model.dao;

import model.Funcionario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FuncionarioDAO {
    private static final String FILE_NAME = "Funcionario.csv";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    // Gera o próximo ID automaticamente
    private int getNextId() {
        int maxId = 0;
        for (Funcionario f : findAll()) {
            if (f.getId() > maxId) maxId = f.getId();
        }
        return maxId + 1;
    }

    // CREATE
    public void save(Funcionario f) {
        if (f.getId() == 0) {
            f.setId(getNextId());
        }

        String dataAdmissao = f.getDataAdmissao() != null ? DATE_FORMAT.format(f.getDataAdmissao()) : "";
        String dataSaida = f.getDataSaida() != null ? DATE_FORMAT.format(f.getDataSaida()) : "";

        String line = f.getId() + ";" + f.getCpf() + ";" + f.getGenero() + ";" + f.getNome() + ";" +
                f.getTelefone() + ";" + dataAdmissao + ";" + dataSaida + ";" + f.getDepartamentoId();

        CSVUtils.writeLine(FILE_NAME, line, true);
    }

    // READ
    public List<Funcionario> findAll() {
        List<String> lines = CSVUtils.readAllLines(FILE_NAME);
        List<Funcionario> funcionarios = new ArrayList<>();

        for (String line : lines) {
            String[] parts = line.split(";");
            if (parts.length == 8) {
                try {
                    Date dataAdmissao = parts[5].isEmpty() ? null : DATE_FORMAT.parse(parts[5]);
                    Date dataSaida = parts[6].isEmpty() ? null : DATE_FORMAT.parse(parts[6]);

                    Funcionario f = new Funcionario(
                            Integer.parseInt(parts[0]),
                            parts[1],
                            parts[2],
                            parts[3],
                            parts[4],
                            dataAdmissao,
                            dataSaida,
                            Integer.parseInt(parts[7])
                    );
                    funcionarios.add(f);
                } catch (ParseException e) {
                    e.printStackTrace(); // erro de parsing, ignora a linha
                }
            }
        }

        return funcionarios;
    }

    // UPDATE
    public void update(Funcionario funcionario) {
        List<Funcionario> funcionarios = findAll();
        List<String> newLines = new ArrayList<>();

        for (Funcionario f : funcionarios) {
            if (f.getId() == funcionario.getId()) {
                f = funcionario;
            }
            String dataAdmissao = f.getDataAdmissao() != null ? DATE_FORMAT.format(f.getDataAdmissao()) : "";
            String dataSaida = f.getDataSaida() != null ? DATE_FORMAT.format(f.getDataSaida()) : "";

            String line = f.getId() + ";" + f.getCpf() + ";" + f.getGenero() + ";" + f.getNome() + ";" +
                    f.getTelefone() + ";" + dataAdmissao + ";" + dataSaida + ";" + f.getDepartamentoId();
            newLines.add(line);
        }

        CSVUtils.overwriteFile(FILE_NAME, newLines);
    }

    // DELETE
    public void delete(int id) {
        List<Funcionario> funcionarios = findAll();
        List<String> newLines = new ArrayList<>();

        for (Funcionario f : funcionarios) {
            if (f.getId() != id) {
                String dataAdmissao = f.getDataAdmissao() != null ? DATE_FORMAT.format(f.getDataAdmissao()) : "";
                String dataSaida = f.getDataSaida() != null ? DATE_FORMAT.format(f.getDataSaida()) : "";

                String line = f.getId() + ";" + f.getCpf() + ";" + f.getGenero() + ";" + f.getNome() + ";" +
                        f.getTelefone() + ";" + dataAdmissao + ";" + dataSaida + ";" + f.getDepartamentoId();
                newLines.add(line);
            }
        }

        CSVUtils.overwriteFile(FILE_NAME, newLines);
    }
}
