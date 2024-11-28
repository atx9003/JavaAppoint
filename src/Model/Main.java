package Model;

import Controller.AgendamentoController;
import View.AgendamentoView;

public class Main {
    public static void main(String[] args) {
        ListaFuncionario listaFuncionarios = new ListaFuncionario();
        AgendamentoView view = new AgendamentoView();
        AgendamentoController controller = new AgendamentoController(view, listaFuncionarios);
    }
}