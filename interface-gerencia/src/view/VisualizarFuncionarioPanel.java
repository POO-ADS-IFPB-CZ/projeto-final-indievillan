package view;

import controller.AppController;
import model.Funcionario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class VisualizarFuncionarioPanel extends JPanel {
    private AppController controller;
    private JTable funcionarioTable;
    private DefaultTableModel tableModel;

    public VisualizarFuncionarioPanel(AppController controller) {
        this.controller = controller;
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Define os cabeçalhos da tabela
        String[] columnNames = {"ID", "Nome", "Data de Admissão", "Departamento"};
        tableModel = new DefaultTableModel(columnNames, 0);
        funcionarioTable = new JTable(tableModel);

        // Cria o painel de rolagem para a tabela
        JScrollPane scrollPane = new JScrollPane(funcionarioTable);
        add(scrollPane, BorderLayout.CENTER);

        JButton btnVoltar = new JButton("Voltar");
        add(btnVoltar, BorderLayout.SOUTH);

        btnVoltar.addActionListener(e -> controller.showGestaoFuncionarioMenu());

        // Carrega os dados na tabela ao inicializar o painel
        carregarDadosNaTabela();
    }

    private void carregarDadosNaTabela() {
        // Limpa a tabela antes de carregar novos dados
        tableModel.setRowCount(0);

        // Chama o controlador para obter a lista de funcionários do modelo
        List<Funcionario> funcionarios = controller.getFuncionarios();

        // Itera sobre a lista e adiciona cada funcionário como uma linha na tabela
        for (Funcionario f : funcionarios) {
            Object[] rowData = {
                    f.getId(), // Assumindo que a classe Funcionario agora tem um getId()
                    f.getNome(),
                    f.getDepartamento() != null ? f.getDepartamento() : "N/A", // Verificação para evitar NullPointer
                    f.getDataAdmissao()
            };
            tableModel.addRow(rowData);
        }
    }
}
