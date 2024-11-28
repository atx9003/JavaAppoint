package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FuncionarioView {
    private JFrame frame;
    private JTextField nomeField;
    private JButton adicionarButton;

    public FuncionarioView() {
        // Configurações da janela
        frame = new JFrame("Gerenciar Funcionários");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 200);
        frame.setLocationRelativeTo(null); // Centraliza a janela

        // Criando componentes
        nomeField = new JTextField(20);
        adicionarButton = new JButton("Adicionar Funcionário");

        // Configuração do botão
        adicionarButton.setBackground(new Color(0, 102, 204)); // Azul
        adicionarButton.setForeground(Color.WHITE);

        // Painel principal
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento

        // Adicionando rótulo e campo de texto
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Nome:"), gbc);

        gbc.gridx = 1;
        panel.add(nomeField, gbc);

        // Adicionando botão
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2; // O botão ocupará duas colunas
        panel.add(adicionarButton, gbc);

        // Configurando a borda do painel
        panel.setBorder(BorderFactory.createTitledBorder("Cadastro de Funcionário"));

        // Adicionando painel à janela
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    public String getNome() {
        return nomeField.getText();
    }

    public void addAdicionarButtonListener(ActionListener listener) {
        adicionarButton.addActionListener(listener);
    }

    public void mostrarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(frame, mensagem);
    }

    public JFrame getFrame() {
        return frame;
    }
}