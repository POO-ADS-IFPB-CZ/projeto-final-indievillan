// view/MainView.java
package view;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    public MainView() {
        setTitle("Tela Principal");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton btnFuncionarios = new JButton("Gestão de Funcionários");
        JButton btnProjetos = new JButton("Gestão de Projetos");
        JButton btnAdministrativo = new JButton("Administrativo");

        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.add(btnFuncionarios);
        panel.add(btnProjetos);
        panel.add(btnAdministrativo);

        add(panel);

        btnFuncionarios.addActionListener(e -> new FuncionarioView(this));
        btnProjetos.addActionListener(e -> new JogoView(this));
        btnAdministrativo.addActionListener(e -> new DepartamentoView(this));

        setVisible(true);
    }
}
