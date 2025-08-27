// view/JogoView.java
package view;

import controller.JogoController;
import model.Jogo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class JogoView extends JFrame {
    private JogoController controller = new JogoController();
    private DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Título", "Descrição", "Status", "Dept ID"}, 0);

    public JogoView(JFrame telaPrincipal) {
        setTitle("Gestão de Jogos");
        setSize(700, 400);
        setLocationRelativeTo(null);

        JTextField txtId = new JTextField();
        JTextField txtTitulo = new JTextField();
        JTextField txtDescricao = new JTextField();
        JTextField txtStatus = new JTextField();
        JTextField txtDepto = new JTextField();

        JButton btnSalvar = new JButton("Salvar");
        JButton btnExcluir = new JButton("Excluir por ID");
        JButton btnVoltar = new JButton("Voltar");

        JTable tabela = new JTable(model);
        JScrollPane scroll = new JScrollPane(tabela);

        JPanel form = new JPanel(new GridLayout(6, 2, 5, 5));
        form.add(new JLabel("ID:")); form.add(txtId);
        form.add(new JLabel("Título:")); form.add(txtTitulo);
        form.add(new JLabel("Descrição:")); form.add(txtDescricao);
        form.add(new JLabel("Status:")); form.add(txtStatus);
        form.add(new JLabel("Departamento ID:")); form.add(txtDepto);
        form.add(btnSalvar); form.add(btnExcluir);

        add(form, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(btnVoltar, BorderLayout.SOUTH);

        atualizarTabela();

        btnSalvar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText());
                int dept = Integer.parseInt(txtDepto.getText());
                Jogo j = new Jogo(id, txtTitulo.getText(), txtDescricao.getText(), txtStatus.getText(), dept);
                controller.salvar(j);
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
        List<Jogo> lista = controller.listar();
        for (Jogo j : lista) {
            model.addRow(new Object[]{j.getId(), j.getTitulo(), j.getDescricao(), j.getStatus(), j.getDepartamentoId()});
        }
    }
}
