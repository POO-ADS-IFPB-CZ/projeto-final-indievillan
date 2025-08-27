// view/FuncionarioView.java
package view;

import controller.FuncionarioController;
import model.Funcionario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class FuncionarioView extends JFrame {
    private FuncionarioController controller = new FuncionarioController();
    private DefaultTableModel model = new DefaultTableModel(
            new String[]{"ID", "CPF", "Gênero", "Nome", "Telefone", "Admissão", "Saída", "Dept ID"}, 0
    );

    public FuncionarioView(JFrame telaPrincipal) {
        setTitle("Gestão de Funcionários");
        setSize(800, 500);
        setLocationRelativeTo(null);

        // Campos do formulário
        JTextField txtId = new JTextField();
        JTextField txtCpf = new JTextField();
        JTextField txtGenero = new JTextField();
        JTextField txtNome = new JTextField();
        JTextField txtTelefone = new JTextField();
        JTextField txtAdmissao = new JTextField();
        JTextField txtSaida = new JTextField();
        JTextField txtDepto = new JTextField();

        JButton btnSalvar = new JButton("Salvar");
        JButton btnExcluir = new JButton("Excluir por ID");
        JButton btnVoltar = new JButton("Voltar");

        JTable tabela = new JTable(model);
        JScrollPane scroll = new JScrollPane(tabela);

        // Layout do formulário
        JPanel form = new JPanel(new GridLayout(9, 2, 5, 5));
        form.add(new JLabel("ID:")); form.add(txtId);
        form.add(new JLabel("CPF:")); form.add(txtCpf);
        form.add(new JLabel("Gênero:")); form.add(txtGenero);
        form.add(new JLabel("Nome:")); form.add(txtNome);
        form.add(new JLabel("Telefone:")); form.add(txtTelefone);
        form.add(new JLabel("Data Admissão:")); form.add(txtAdmissao);
        form.add(new JLabel("Data Saída:")); form.add(txtSaida);
        form.add(new JLabel("Departamento ID:")); form.add(txtDepto);
        form.add(btnSalvar); form.add(btnExcluir);

        add(form, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(btnVoltar, BorderLayout.SOUTH);

        atualizarTabela();

        // Ações
        btnSalvar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText());
                int dept = Integer.parseInt(txtDepto.getText());
                Funcionario f = new Funcionario(
                        id, txtCpf.getText(), txtGenero.getText(),
                        txtNome.getText(), txtTelefone.getText(),
                        txtAdmissao.getText(), txtSaida.getText(), dept
                );
                controller.salvar(f);
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
        List<Funcionario> lista = controller.listar();
        for (Funcionario f : lista) {
            model.addRow(new Object[]{
                    f.getId(), f.getCpf(), f.getGenero(), f.getNome(),
                    f.getTelefone(), f.getDataAdmissao(), f.getDataSaida(), f.getDepartamentoId()
            });
        }
    }
}
