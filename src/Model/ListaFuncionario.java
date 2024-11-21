package Model;

import java.util.ArrayList;

public class ListaFuncionario {
    private ArrayList<String> funcionarios;

    public ListaFuncionario() {
        this.funcionarios = new ArrayList<>();
    }

    public void adicionarFuncionario(String funcionario) {
        funcionarios.add(funcionario);
    }

    public ArrayList<String> getFuncionarios() {
        return funcionarios;
    }
}