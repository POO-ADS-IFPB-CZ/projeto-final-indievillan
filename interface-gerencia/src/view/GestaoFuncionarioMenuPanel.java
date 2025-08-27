package view;

import controller.AppController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class GestaoFuncionarioMenuPanel extends JPanel {

    private AppController controller;

    public GestaoFuncionarioMenuPanel(AppController controller) {
        this.controller = controller;
        setLayout(new GridLayout(10, 2, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton btnAdicionar = new JButton("Adicionar Funcionário");
        JButton btnVisualizar = new JButton("Visualizar Funcionários");
        JButton btnEditar = new JButton("Editar Cadastro");
        JButton btnVoltar = new JButton("Voltar");

        add(btnAdicionar);
        add(btnVisualizar);
        add(btnEditar);
        add(btnVoltar);

        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.showAdicionarFuncionarioForm();
            }
        });

        btnVisualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.showVisualizarFuncionarioForm();
            }
        });

        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.showEditarFuncionarioForm();
            }
        });

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.showMainMenu();
            }
        });
    }
}