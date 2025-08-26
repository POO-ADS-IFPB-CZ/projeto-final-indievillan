import controller.AppController;
import view.MenuPrincipalPanel;

import javax.swing.*;

public class MainApp {

    private JFrame frame;
    private JTabbedPane tabbedPane;

    public MainApp() {
        frame = new JFrame("Sistema de Gestão");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        tabbedPane = new JTabbedPane();

        // Adiciona a primeira aba
        tabbedPane.addTab("Menu Principal", new MenuPrincipalPanel(new AppController()));

        frame.add(tabbedPane);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Método para mudar a aba
    public void switchPanel(String title, JPanel panel) {
        // Encontra o index da aba e remove
        int index = tabbedPane.indexOfTab(title);
        if (index != -1) {
            tabbedPane.removeTabAt(index);
        }

        // Adiciona a nova aba e seleciona ela
        tabbedPane.addTab(title, panel);
        tabbedPane.setSelectedComponent(panel);
    }

    // Método para voltar para o menu principal
    public void voltarParaMenuPrincipal() {
        for (int i = tabbedPane.getTabCount() - 1; i > 0; i--) {
            tabbedPane.removeTabAt(i);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AppController();
        });
    }
}