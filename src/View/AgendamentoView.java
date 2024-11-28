package View;

import Model.Servico;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AgendamentoView {
    private JFrame frame;
    private JTextField txtNomeFuncionario;
    private JTextField txtNomeCliente;
    private JTextField txtData;
    private JTextField txtHora;
    private JTextField txtCelularCliente;
    private JTextField txtEmailCliente;
    private JButton btnAgendar;
    private JButton btnCadastrarFuncionario;
    private JButton btnCadastrarServico;
    private JComboBox<String> cboFuncionarios;
    private JComboBox<Servico> cboServicos;
    private JButton btnConsultarAgendamentos;

    public AgendamentoView() {
        frame = new JFrame("JavaAppoint");
        frame.setSize(400, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("CARLOS CABELEIREIRO");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(0, 102, 204));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        panel.add(new JLabel("Nome do Funcionário:"), gbc);

        txtNomeFuncionario = new JTextField(20);
        gbc.gridx = 1;
        panel.add(txtNomeFuncionario, gbc);

        btnCadastrarFuncionario = new JButton("Cadastrar Funcionário");
        btnCadastrarFuncionario.setBackground(new Color(0, 153, 0));
        btnCadastrarFuncionario.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(btnCadastrarFuncionario, gbc);

        btnCadastrarServico = new JButton("Cadastrar Serviço");
        btnCadastrarServico.setBackground(new Color(0, 153, 0));
        btnCadastrarServico.setForeground(Color.WHITE);
        gbc.gridy = 3;
        panel.add(btnCadastrarServico, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 4;
        panel.add(new JLabel("Nome do Cliente:"), gbc);

        txtNomeCliente = new JTextField(20);
        gbc.gridx = 1;
        panel.add(txtNomeCliente, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Celular Cliente:"), gbc);

        txtCelularCliente = new JTextField(20);
        gbc.gridx = 1;
        panel.add(txtCelularCliente, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(new JLabel("E-mail Cliente:"), gbc);

        txtEmailCliente = new JTextField(20);
        gbc.gridx = 1;
        panel.add(txtEmailCliente, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(new JLabel("Funcionário:"), gbc);

        cboFuncionarios = new JComboBox<>();
        gbc.gridx = 1;
        panel.add(cboFuncionarios, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(new JLabel("Serviço:"), gbc);

        cboServicos = new JComboBox<>();
        gbc.gridx = 1;
        panel.add(cboServicos, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        panel.add(new JLabel("Data (dd/MM/yyyy):"), gbc);

        txtData = new JTextField(20);
        gbc.gridx = 1;
        panel.add(txtData, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        panel.add(new JLabel("Hora:"), gbc);

        txtHora = new JTextField(20);
        gbc.gridx = 1;
        panel.add(txtHora, gbc);

        btnAgendar = new JButton("Agendar Serviço");
        btnAgendar.setBackground(new Color(0, 153, 0));
        btnAgendar.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 2;
        panel.add(btnAgendar, gbc);

        btnConsultarAgendamentos = new JButton("Consultar Agendamentos");
        btnConsultarAgendamentos.setBackground(new Color(255, 165, 0));
        btnConsultarAgendamentos.setForeground(Color.WHITE);
        gbc.gridy = 12;
        panel.add(btnConsultarAgendamentos, gbc);

        frame.add(panel);
        frame.setVisible(true);
    }

    public String getCliente() {
        return txtNomeCliente.getText();
    }

    public String getCelularCliente() {
        return txtCelularCliente.getText();
    }

    public String getEmailCliente() {
        return txtEmailCliente.getText();
    }

    public Servico getServicoSelecionado() {
        return (Servico) cboServicos.getSelectedItem();
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

    public void adicionarFuncionarioComboBox(String nomeFuncionario) {
        cboFuncionarios.addItem(nomeFuncionario);
    }

    public void adicionarServicoComboBox(Servico servico) {
        cboServicos.addItem(servico);
    }

    public void mostrarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(frame, mensagem);
    }

    public void addCadastrarFuncionarioListener(ActionListener listener) {
        btnCadastrarFuncionario.addActionListener(listener);
    }

    public void addAgendarButtonListener(ActionListener listener) {
        btnAgendar.addActionListener(listener);
    }

    public void addConsultarAgendamentosListener(ActionListener listener) {
        btnConsultarAgendamentos.addActionListener(listener);
    }

    public void addCadastrarServicoListener(ActionListener listener) {
        btnCadastrarServico.addActionListener(listener);
    }
}