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
    private ListaFuncionario listaFuncionario;

    public AgendamentoController(AgendamentoView view, ListaFuncionario listaFuncionarios) {
        this.view = view;
        this.agendamentos = new ArrayList<>();
        this.listaServico = new ListaServico();
        this.listaFuncionario = listaFuncionarios;

        view.addCadastrarFuncionarioListener(new CadastrarFuncionarioListener());
        view.addAgendarButtonListener(new AgendarServicoListener());
        view.addConsultarAgendamentosListener(new ConsultarAgendamentosListener());
        view.addCadastrarServicoListener(new CadastrarServicoListener());
    }

    class CadastrarFuncionarioListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String nomeFuncionario = view.getNomeFuncionario();
                if (nomeFuncionario.isEmpty()) {
                    throw new Exception("O nome do funcionário não pode estar vazio.");
                }
                // Adiciona o funcionário na lista e na combobox
                listaFuncionario.adicionarFuncionario(nomeFuncionario);
                view.adicionarFuncionarioComboBox(nomeFuncionario);
                view.mostrarMensagem("Funcionário cadastrado com sucesso!");
            } catch (Exception ex) {
                view.mostrarMensagem("Erro ao cadastrar funcionário. " + ex.getMessage());
            }
        }
    }

    class CadastrarServicoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String tipo = JOptionPane.showInputDialog("Digite o tipo de serviço:");
                if (tipo == null || tipo.isEmpty()) {
                    throw new Exception("O tipo de serviço não pode estar vazio.");
                }

                String duracaoStr = JOptionPane.showInputDialog("Digite o tempo de duração (em minutos):");
                int duracao = Integer.parseInt(duracaoStr);

                if (duracao <= 0) {
                    throw new Exception("A duração do serviço deve ser um número positivo.");
                }

                String precoStr = JOptionPane.showInputDialog("Digite o preço do serviço:");
                double preco = Double.parseDouble(precoStr);
                if (preco <= 0) {
                    throw new Exception("O preço do serviço deve ser um número positivo.");
                }

                Servico servico = new Servico(tipo, duracao, preco);
                listaServico.adicionarServico(servico);
                view.adicionarServicoComboBox(servico);
                view.mostrarMensagem("Serviço cadastrado com sucesso!");
            } catch (Exception ex) {
                view.mostrarMensagem("Erro ao cadastrar serviço. " + ex.getMessage());
            }
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

                // Verificar se os campos obrigatórios estão preenchidos (exceto email)
                if (cliente.isEmpty() || celularCliente.isEmpty() || funcionario == null || servico == null || data.isEmpty() || hora.isEmpty()) {
                    throw new Exception("Todos os campos obrigatórios devem ser preenchidos.");
                }

                // Se não houver exceção, cria o agendamento
                Agendamento agendamento = new Agendamento(cliente, celularCliente, emailCliente, funcionario, servico, data, hora);
                agendamentos.add(agendamento);

                view.mostrarMensagem("Agendamento realizado com sucesso!");
            } catch (Exception ex) {
                // Exibir a mensagem de erro caso algum campo obrigatório não seja preenchido
                view.mostrarMensagem("Erro ao agendar serviço. " + ex.getMessage());
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