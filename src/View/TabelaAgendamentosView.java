package View;

import Model.Agendamento;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.List;

public class TabelaAgendamentosView {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;

    public TabelaAgendamentosView() {
        frame = new JFrame("Consulta de Agendamentos");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Configura o modelo de tabela
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Cliente");
        tableModel.addColumn("Celular");
        tableModel.addColumn("Email");
        tableModel.addColumn("Funcionário");
        tableModel.addColumn("Serviço");
        tableModel.addColumn("Duração (min)");
        tableModel.addColumn("Preço (R$)");
        tableModel.addColumn("Data");
        tableModel.addColumn("Hora");

        // Cria e configura a tabela
        table = new JTable(tableModel);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(25);
        table.setGridColor(new Color(200, 200, 200)); // Define a cor das linhas de grade
        table.setSelectionBackground(new Color(173, 216, 230)); // Fundo para linhas selecionadas
        table.setSelectionForeground(Color.BLACK);

        // Configura o cabeçalho da tabela
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 16));
        header.setBackground(new Color(70, 130, 180)); // Cor azul suave no cabeçalho
        header.setForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margens internas para espaçamento

        // Layout do frame
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public void exibirAgendamentos(List<Agendamento> agendamentos) {
        tableModel.setRowCount(0); // Limpa a tabela

        for (Agendamento agendamento : agendamentos) {
            tableModel.addRow(new Object[]{
                    agendamento.getCliente(),
                    agendamento.getCelularCliente(),
                    agendamento.getEmailCliente(),
                    agendamento.getFuncionario(),
                    agendamento.getServico().getTipo(),
                    agendamento.getServico().getTempoDuracao(),
                    agendamento.getServico().getPreco(),
                    agendamento.getData(),
                    agendamento.getHora()
            });
        }
    }
}