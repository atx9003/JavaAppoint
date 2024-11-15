package View;

import Model.Agendamento;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TabelaAgendamentosView {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;

    public TabelaAgendamentosView() {
        frame = new JFrame("Consulta de Agendamentos");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

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

        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
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
