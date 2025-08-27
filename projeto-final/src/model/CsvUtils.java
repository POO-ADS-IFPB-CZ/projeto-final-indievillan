// model/CsvUtils.java
package model;

import java.io.*;
import java.util.*;

public class CsvUtils {
    public static List<String[]> read(String filePath) {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while((line = br.readLine()) != null) {
                data.add(line.split(";"));
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler CSV: " + e.getMessage());
        }
        return data;
    }

    public static void write(String filePath, List<String> lines) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String l : lines) {
                bw.write(l);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever CSV: " + e.getMessage());
        }
    }
}
