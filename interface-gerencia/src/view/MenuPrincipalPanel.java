package view;

import controller.AppController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class MenuPrincipalPanel extends JPanel {

    private AppController controller;

    public MenuPrincipalPanel(AppController controller) {
        this.controller = controller;
        setLayout(new GridLayout(10, 2, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton btnGestaoFuncionarios = new JButton("Gestão de Funcionários");
        JButton btnGestaoProjetos = new JButton("Gestão de Projetos");
        JButton btnAdministrativo = new JButton("Administrativo");

        add(btnGestaoFuncionarios);
        add(btnGestaoProjetos);
        add(btnAdministrativo);

        btnGestaoFuncionarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.showGestaoFuncionarioMenu();
            }
        });
    }
}