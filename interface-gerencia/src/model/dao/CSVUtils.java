package model.dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {

    // Escreve uma linha no arquivo (append = true adiciona, false sobrescreve)
    public static void writeLine(String fileName, String line, boolean append) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, append))) {
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao escrever no arquivo: " + fileName, e);
        }
    }

    // Lê todas as linhas do arquivo
    public static List<String> readAllLines(String fileName) {
        List<String> lines = new ArrayList<>();
        File file = new File(fileName);

        if (!file.exists()) return lines; // se não existe, retorna vazio

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler o arquivo: " + fileName, e);
        }

        return lines;
    }

    // Sobrescreve o arquivo com novas linhas
    public static void overwriteFile(String fileName, List<String> lines) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao sobrescrever arquivo: " + fileName, e);
        }
    }
}
