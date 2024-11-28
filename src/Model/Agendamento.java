package Model;

import java.util.Date;

public class Agendamento {
    private String cliente;
    private String celularCliente;
    private String emailCliente;
    private String funcionario;
    private Servico servico;
    private String data;
    private String hora;

    public Agendamento(String cliente, String celularCliente, String emailCliente, String funcionario, Servico servico, String data, String hora) {
        this.cliente = cliente;
        this.celularCliente = celularCliente;
        this.emailCliente = emailCliente;
        this.funcionario = funcionario;
        this.servico = servico;
        this.data = data;
        this.hora = hora;
    }

    public Agendamento(Cliente cliente, Funcionario funcionario, Servico servico, Date data, String hora) {
    }

    public String getCliente() {
        return cliente;
    }

    public String getCelularCliente() {
        return celularCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public Servico getServico() {
        return servico;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    @Override
    public String toString() {
        return "Agendamento{" +
                "cliente='" + cliente + '\'' +
                ", celularCliente='" + celularCliente + '\'' +
                ", emailCliente='" + emailCliente + '\'' +
                ", funcionario='" + funcionario + '\'' +
                ", servico=" + servico +
                ", data='" + data + '\'' +
                ", hora='" + hora + '\'' +
                '}';
    }
}