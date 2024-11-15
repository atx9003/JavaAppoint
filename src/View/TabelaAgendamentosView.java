package View;

import javax.swing.*;
import java.awt.*;

public class TabelaAgendamentosView {
    private JFrame frame;
    private JTable tabelaAgendamentos;

    public TabelaAgendamentosView() {
        frame = new JFrame("Consulta de Agendamentos");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null); // Centraliza a janela

        // Configura a tabela
        tabelaAgendamentos = new JTable();
        JScrollPane scrollPane = new JScrollPane(tabelaAgendamentos);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    // Método para atualizar a tabela com dados de agendamentos
    public void atualizarTabelaAgendamentos(String[][] dados) {
        String[] colunas = {"Cliente", "Celular", "E-mail", "Serviço", "Funcionário", "Data", "Hora"};
        tabelaAgendamentos.setModel(new javax.swing.table.DefaultTableModel(dados, colunas));
    }

    public void mostrar() {
        frame.setVisible(true);
    }

    public void fechar() {
        frame.dispose();
    }
}