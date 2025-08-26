package view;

import controller.AppController;
import model.Funcionario;
import model.dao.FuncionarioDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AdicionarFuncionarioPanel extends JPanel {

    private AppController controller;
    private JTextField txtId, txtCpf, txtNome, txtTelefone, txtDataAdmissao, txtEmail;
    private JComboBox<String> cmbGenero, idDepartamento;
    private JTextArea txtEmails;

    public AdicionarFuncionarioPanel(AppController controller) {
        this.controller = controller;
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel formPanel = new JPanel(new GridLayout(10, 2, 10, 10));

        txtId = new JTextField();
        txtCpf = new JTextField();
        txtNome = new JTextField();
        txtTelefone = new JTextField();
        txtDataAdmissao = new JTextField("AAAA-MM-DD");
        cmbGenero = new JComboBox<>(new String[]{"Masculino", "Feminino", "Outro"});


        formPanel.add(new JLabel("Matrícula:"));
        formPanel.add(txtId);
        formPanel.add(new JLabel("CPF:"));
        formPanel.add(txtCpf);
        formPanel.add(new JLabel("Nome:"));
        formPanel.add(txtNome);
        formPanel.add(new JLabel("Gênero:"));
        formPanel.add(cmbGenero);
        formPanel.add(new JLabel("Telefone:"));
        formPanel.add(txtTelefone);
        formPanel.add(new JLabel("Data de Admissão:"));
        formPanel.add(txtDataAdmissao);


        // Adiciona os painéis ao painel principal
        add(formPanel, BorderLayout.CENTER);

        // Botões de ação
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnSalvar = new JButton("Salvar");
        JButton btnVoltar = new JButton("Voltar");
        buttonPanel.add(btnSalvar);
        buttonPanel.add(btnVoltar);
        add(buttonPanel, BorderLayout.SOUTH);


        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.salvarFuncionario(
                            Integer.parseInt(txtId.getText()),
                            txtCpf.getText(),
                            cmbGenero.getSelectedItem().toString(),
                            txtNome.getText(),
                            txtTelefone.getText(),
                            txtDataAdmissao.getText(),
                            0
                    );

                    // Limpa os campos após o salvamento
                    limparCampos();
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Formato de data inválido. Use AAAA-MM-DD.");
                }
            }
        });

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.showGestaoFuncionarioMenu();
            }
        });
    }

    private void limparCampos() {
        txtId.setText("");
        txtCpf.setText("");
        txtNome.setText("");
        txtTelefone.setText("");
        txtDataAdmissao.setText("AAAA-MM-DD");
        cmbGenero.setSelectedIndex(0);
    }
}