package controller;

import model.Funcionario;
import model.dao.FuncionarioDAO;
import view.AdicionarFuncionarioPanel;
import view.GestaoFuncionarioMenuPanel;
import view.MenuPrincipalPanel;
import view.VisualizarFuncionarioPanel;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class AppController {

    private JFrame frame;
    private JTabbedPane tabbedPane;
    private FuncionarioDAO fdao = new FuncionarioDAO();

    public AppController() {
        frame = new JFrame("Sistema de Gestão - MVC");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        tabbedPane = new JTabbedPane();

        // O controlador inicia a primeira View e a adiciona ao frame
        showMainMenu();

        frame.add(tabbedPane);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    // Métodos para gerenciar as visualizações (abas)
    public void showMainMenu() {
        tabbedPane.removeAll();
        tabbedPane.addTab("Menu Principal", new MenuPrincipalPanel(this));
    }

    public void showGestaoFuncionarioMenu() {
        tabbedPane.removeAll();
        tabbedPane.addTab("Gestão de Funcionários", new GestaoFuncionarioMenuPanel(this));
    }

    public void showAdicionarFuncionarioForm() {
        tabbedPane.removeAll();
        tabbedPane.addTab("Adicionar Funcionário", new AdicionarFuncionarioPanel(this));
    }

    public void showVisualizarFuncionarioForm(){
        tabbedPane.removeAll();
        tabbedPane.addTab("Ver Funcionários", new VisualizarFuncionarioPanel(this));
    }

    // Método para salvar um funcionário (interação com o Model)
    public void salvarFuncionario(Integer id, String cpf, String genero, String nome, String telefone, String dataAdmissaoStr, Integer departamentoId) throws ParseException {
        Funcionario funcionario = new Funcionario(
                id,
                cpf,
                genero,
                nome,
                telefone,
                new SimpleDateFormat("yyyy-MM-dd").parse(dataAdmissaoStr),
                null,
                departamentoId
        );

        fdao.save(funcionario);
        JOptionPane.showMessageDialog(null, "Funcionário salvo com sucesso!");
    }

    public List<Funcionario> listarFuncionario(){
        return fdao.findAll();
    }

    public void atualizarFuncionario(Funcionario f){
        fdao.update(f);
    }

    // Futuras lógicas de buscar, editar e deletar também estariam aqui
}