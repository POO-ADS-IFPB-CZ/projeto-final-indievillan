package view;

import controller.AppController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class VisualizarFuncionarioPanel extends JPanel {
    private AppController controller;

    public VisualizarFuncionarioPanel(AppController controller){
        this.controller = controller;
        setLayout(new GridLayout(10, 2, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton btnVoltar = new JButton("Voltar");

        add(btnVoltar);

    }
}
