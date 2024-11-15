package Controller;

import Model.Agendamento;
import Model.ListaFuncionario;
import Model.ListaServico;
import Model.Servico;
import View.AgendamentoView;
import View.TabelaAgendamentosView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoController {
    private AgendamentoView view;
    private List<Agendamento> agendamentos;
    private ListaServico listaServico;

    public AgendamentoController(AgendamentoView view, ListaFuncionario listaFuncionarios) {
        this.view = view;
        this.agendamentos = new ArrayList<>();
        this.listaServico = new ListaServico();

        view.addCadastrarFuncionarioListener(new CadastrarFuncionarioListener());
        view.addAgendarButtonListener(new AgendarServicoListener());
        view.addConsultarAgendamentosListener(new ConsultarAgendamentosListener());
        view.addCadastrarServicoListener(new CadastrarServicoListener());
    }

    class CadastrarFuncionarioListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nomeFuncionario = view.getNomeFuncionario();
            view.adicionarFuncionarioComboBox(nomeFuncionario);
            view.mostrarMensagem("Funcionário cadastrado com sucesso!");
        }
    }

    class CadastrarServicoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String tipo = JOptionPane.showInputDialog("Digite o tipo de serviço:");
            int duracao = Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de duração (em minutos):"));
            double preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do serviço:"));

            Servico servico = new Servico(tipo, duracao, preco);
            listaServico.adicionarServico(servico);
            view.adicionarServicoComboBox(servico);

            view.mostrarMensagem("Serviço cadastrado com sucesso!");
        }
    }

    class AgendarServicoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String cliente = view.getCliente();
                String celularCliente = view.getCelularCliente();
                String emailCliente = view.getEmailCliente();
                String funcionario = view.getFuncionarioSelecionado();
                Servico servico = view.getServicoSelecionado();
                String data = view.getData();
                String hora = view.getHora();

                Agendamento agendamento = new Agendamento(cliente, celularCliente, emailCliente, funcionario, servico, data, hora);
                agendamentos.add(agendamento);

                view.mostrarMensagem("Agendamento realizado com sucesso!");
            } catch (Exception ex) {
                view.mostrarMensagem("Erro ao agendar serviço. Verifique os dados e tente novamente.");
            }
        }
    }

    class ConsultarAgendamentosListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            TabelaAgendamentosView tabelaView = new TabelaAgendamentosView();
            tabelaView.exibirAgendamentos(agendamentos);
        }
    }
}
