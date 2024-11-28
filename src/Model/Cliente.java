package Model;

import java.util.ArrayList;
import java.util.Date;

public class Cliente extends Pessoa {
    private ArrayList<Agendamento> agendamentos;

    public Cliente() {
        agendamentos = new ArrayList<>();
    }

    public ArrayList<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void solicitaAgendamento(Date data, String hora, Servico servico, Funcionario funcionario) {
        Agendamento agendamento = new Agendamento(this, funcionario, servico, data, hora);
        agendamentos.add(agendamento);
        funcionario.adicionarAgendamento(agendamento);
        System.out.println("Agendamento solicitado com sucesso!");
        System.out.println(agendamento.toString());
    }

    public void fazPagamento(Servico servico) {
        double preco = servico.getPreco();
        System.out.println("Pagamento de R$ " + preco + " pelo serviço de " + servico.getTipo() + " realizado com sucesso!");
    }
}