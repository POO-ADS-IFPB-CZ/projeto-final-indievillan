// view/DepartamentoView.java
package view;

import controller.DepartamentoController;
import model.Departamento;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class DepartamentoView extends JFrame {
    private DepartamentoController controller = new DepartamentoController();
    private DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Nome", "Data Criação"}, 0);

    public DepartamentoView(JFrame telaPrincipal) {
        setTitle("Gestão de Departamentos");
        setSize(600, 400);
        setLocationRelativeTo(null);

        JTextField txtId = new JTextField();
        JTextField txtNome = new JTextField();
        JTextField txtData = new JTextField();

        JButton btnSalvar = new JButton("Salvar");
        JButton btnExcluir = new JButton("Excluir por ID");
        JButton btnVoltar = new JButton("Voltar");

        JTable tabela = new JTable(model);
        JScrollPane scroll = new JScrollPane(tabela);

        JPanel form = new JPanel(new GridLayout(4, 2, 5, 5));
        form.add(new JLabel("ID:")); form.add(txtId);
        form.add(new JLabel("Nome:")); form.add(txtNome);
        form.add(new JLabel("Data Criação:")); form.add(txtData);
        form.add(btnSalvar); form.add(btnExcluir);

        add(form, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(btnVoltar, BorderLayout.SOUTH);

        atualizarTabela();

        btnSalvar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText());
                Departamento d = new Departamento(id, txtNome.getText(), txtData.getText());
                controller.salvar(d);
                atualizarTabela();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
            }
        });

        btnExcluir.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText());
                controller.excluir(id);
                atualizarTabela();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
            }
        });

        btnVoltar.addActionListener(e -> {
            dispose();
            telaPrincipal.setVisible(true);
        });

        setVisible(true);
    }

    private void atualizarTabela() {
        model.setRowCount(0);
        List<Departamento> lista = controller.listar();
        for (Departamento d : lista) {
            model.addRow(new Object[]{d.getId(), d.getNome(), d.getDataCriacao()});
        }
    }
}
