package Model;

import java.util.ArrayList;

public class ListaServico {
    private ArrayList<Servico> servicos;

    public ListaServico() {
        this.servicos = new ArrayList<>();
    }

    public void adicionarServico(Servico servico) {
        servicos.add(servico);
    }

    public ArrayList<Servico> getServicos() {
        return servicos;
    }
}