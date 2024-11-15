package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AgendamentoView {
    private JFrame frame;
    private JTextField txtNomeFuncionario;
    private JTextField txtNomeCliente;
    private JTextField txtServico;
    private JTextField txtData;
    private JTextField txtHora;
    private JTextField txtCelularCliente;
    private JTextField txtEmailCliente;
    private JButton btnAgendar;
    private JButton btnCadastrarFuncionario;
    private JComboBox<String> cboFuncionarios;
    private JButton btnConsultarAgendamentos;

    public AgendamentoView() {
        frame = new JFrame("JavaAppoint");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centraliza a janela

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento

        // Título
        JLabel titleLabel = new JLabel("CARLOS CABELEIREIRO");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(0, 102, 204)); // Azul personalizado
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        // Campos para cadastro de funcionário
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        panel.add(new JLabel("Nome do Funcionário:"), gbc);

        txtNomeFuncionario = new JTextField(20);
        gbc.gridx = 1;
        panel.add(txtNomeFuncionario, gbc);

        // Botão para cadastrar funcionário
        btnCadastrarFuncionario = new JButton("Cadastrar Funcionário");
        btnCadastrarFuncionario.setBackground(new Color(0, 153, 0)); // Verde
        btnCadastrarFuncionario.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(btnCadastrarFuncionario, gbc);

        // Campos para agendamento
        gbc.gridwidth = 1;
        gbc.gridy = 3;
        panel.add(new JLabel("Nome do Cliente:"), gbc);

        txtNomeCliente = new JTextField(20);
        gbc.gridx = 1;
        panel.add(txtNomeCliente, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Celular Cliente:"), gbc);

        txtCelularCliente = new JTextField(20);
        gbc.gridx = 1;
        panel.add(txtCelularCliente, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("E-mail Cliente:"), gbc);

        txtEmailCliente = new JTextField(20);
        gbc.gridx = 1;
        panel.add(txtEmailCliente, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(new JLabel("Funcionário:"), gbc);

        // ComboBox para selecionar funcionário
        cboFuncionarios = new JComboBox<>();
        gbc.gridx = 1;
        panel.add(cboFuncionarios, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(new JLabel("Serviço:"), gbc);

        txtServico = new JTextField(20);
        gbc.gridx = 1;
        panel.add(txtServico, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(new JLabel("Data (dd/MM/yyyy):"), gbc);

        txtData = new JTextField(20);
        gbc.gridx = 1;
        panel.add(txtData, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        panel.add(new JLabel("Hora:"), gbc);

        txtHora = new JTextField(20);
        gbc.gridx = 1;
        panel.add(txtHora, gbc);

        // Botão para agendar
        btnAgendar = new JButton("Agendar Serviço");
        btnAgendar.setBackground(new Color(0, 153, 0)); // Verde
        btnAgendar.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 2;
        panel.add(btnAgendar, gbc);

        // Botão para consultar agendamentos
        btnConsultarAgendamentos = new JButton("Consultar Agendamentos");
        btnConsultarAgendamentos.setBackground(new Color(255, 165, 0)); // Laranja
        btnConsultarAgendamentos.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 2;
        panel.add(btnConsultarAgendamentos, gbc);

        frame.add(panel);
        frame.setVisible(true);
    }

    // Métodos para acessar os dados dos campos
    public String getCliente() {
        return txtNomeCliente.getText();
    }

    public String getCelularCliente() {
        return txtCelularCliente.getText();
    }

    public String getEmailCliente() {
        return txtEmailCliente.getText();
    }

    public String getServico() {
        return txtServico.getText();
    }

    public String getFuncionarioSelecionado() {
        return (String) cboFuncionarios.getSelectedItem();
    }

    public String getData() {
        return txtData.getText();
    }

    public String getHora() {
        return txtHora.getText();
    }

    public String getNomeFuncionario() {
        return txtNomeFuncionario.getText();
    }

    // Atualiza a lista de funcionários na ComboBox
    public void adicionarFuncionarioComboBox(String nomeFuncionario) {
        cboFuncionarios.addItem(nomeFuncionario);
    }

    // Exibe uma mensagem de alerta
    public void mostrarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(frame, mensagem);
    }

    // Adiciona listeners aos botões
    public void addCadastrarFuncionarioListener(ActionListener listener) {
        btnCadastrarFuncionario.addActionListener(listener);
    }

    public void addAgendarButtonListener(ActionListener listener) {
        btnAgendar.addActionListener(listener);
    }

    public void addConsultarAgendamentosListener(ActionListener listener) {
        btnConsultarAgendamentos.addActionListener(listener);
    }
}