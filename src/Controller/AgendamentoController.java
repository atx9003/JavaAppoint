package Controller;

import Model.Agendamento;
import Model.Funcionario;
import Model.ListaFuncionario;
import View.AgendamentoView;
import View.TabelaAgendamentosView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AgendamentoController {
    private AgendamentoView view;
    private ListaFuncionario listaFuncionarios;
    private ArrayList<Agendamento> agendamentos;

    public AgendamentoController(AgendamentoView view, ListaFuncionario listaFuncionarios) {
        this.view = view;
        this.listaFuncionarios = listaFuncionarios;
        this.agendamentos = new ArrayList<>();

        this.view.addCadastrarFuncionarioListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarFuncionario();
            }
        });

        this.view.addAgendarButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agendarServico();
            }
        });

        this.view.addConsultarAgendamentosListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarAgendamentos();
            }
        });
    }

    private void cadastrarFuncionario() {
        String nomeFuncionario = view.getNomeFuncionario();
        if (!nomeFuncionario.isEmpty()) {
            Funcionario funcionario = new Funcionario();
            funcionario.setNome(nomeFuncionario);
            listaFuncionarios.adicionarFuncionario(funcionario);
            view.adicionarFuncionarioComboBox(nomeFuncionario);
            view.mostrarMensagem("Funcionário cadastrado com sucesso!");
        } else {
            view.mostrarMensagem("Por favor, preencha o nome do funcionário.");
        }
    }

    private void agendarServico() {
        String cliente = view.getCliente();
        String celularCliente = view.getCelularCliente();
        String emailCliente = view.getEmailCliente();
        String servico = view.getServico();
        String funcionario = view.getFuncionarioSelecionado();
        String data = view.getData();
        String hora = view.getHora();

        if (cliente.isEmpty() || celularCliente.isEmpty() || servico.isEmpty() || funcionario == null || data.isEmpty() || hora.isEmpty()) {
            view.mostrarMensagem("Todos os campos são obrigatórios, exceto o email.");
        } else {
            Agendamento agendamento = new Agendamento(cliente, celularCliente, emailCliente, servico, funcionario, data, hora);
            agendamentos.add(agendamento);
            view.mostrarMensagem("Agendamento realizado com sucesso!");
        }
    }

    private void consultarAgendamentos() {
        String[][] dados = new String[agendamentos.size()][7];
        for (int i = 0; i < agendamentos.size(); i++) {
            Agendamento agendamento = agendamentos.get(i);
            dados[i][0] = agendamento.getNomeCliente();
            dados[i][1] = agendamento.getCelularCliente();
            dados[i][2] = agendamento.getEmailCliente();
            dados[i][3] = agendamento.getTipoServico();
            dados[i][4] = agendamento.getFuncionarioResponsavel();
            dados[i][5] = agendamento.getData();
            dados[i][6] = agendamento.getHora();
        }
        TabelaAgendamentosView tabelaAgendamentosView = new TabelaAgendamentosView();
        tabelaAgendamentosView.atualizarTabelaAgendamentos(dados);
        tabelaAgendamentosView.mostrar();
    }
}