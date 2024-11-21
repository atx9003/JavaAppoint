package Controller;

import Model.Funcionario;
import Model.ListaFuncionario;
import View.FuncionarioView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FuncionarioController {
    private FuncionarioView view;
    private ListaFuncionario model;

    public FuncionarioController(FuncionarioView view, ListaFuncionario model) {
        this.view = view;
        this.model = model;

        this.view.addAdicionarButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarFuncionario();
            }
        });
    }

    private void adicionarFuncionario() {
        String nome = view.getNome();
        if (!nome.isEmpty()) {
            Funcionario funcionario = new Funcionario();
            funcionario.setNome(nome);
            model.adicionarFuncionario(String.valueOf(funcionario));
            view.mostrarMensagem("Funcionário adicionado com sucesso!");
            view.getFrame().repaint(); // Atualiza a janela
        } else {
            view.mostrarMensagem("Nome não pode ser vazio!");
        }
    }
}