package view;
import controller.AppController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class EditarFuncionarioPanel extends JPanel {
    private AppController controller;

    public EditarFuncionarioPanel(AppController controller){
        this.controller = controller;
        setLayout(new GridLayout(10, 2, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField title = new JTextField("TABELA DE FUNCIONARIO", 20);
        JButton btnVoltar = new JButton("Voltar");

        add(title);
        add(btnVoltar);
    }
}
