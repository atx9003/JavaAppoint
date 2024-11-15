package Model;

import java.util.Date;

public class Agendamento {
    private String nomeCliente;
    private String celularCliente;
    private String emailCliente;
    private String tipoServico;
    private String funcionarioResponsavel;
    private String data;
    private String hora;

    public Agendamento(String nomeCliente, String celularCliente, String emailCliente, String tipoServico, String funcionarioResponsavel, String data, String hora) {
        this.nomeCliente = nomeCliente;
        this.celularCliente = celularCliente;
        this.emailCliente = emailCliente;
        this.tipoServico = tipoServico;
        this.funcionarioResponsavel = funcionarioResponsavel;
        this.data = data;
        this.hora = hora;
    }

    public Agendamento(Cliente cliente, Funcionario funcionario, Servico servico, Date data, String hora) {
    }

    // Getters e setters
    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getCelularCliente() {
        return celularCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public String getFuncionarioResponsavel() {
        return funcionarioResponsavel;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }
}