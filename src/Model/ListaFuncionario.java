package Model;

import java.util.ArrayList;

public class ListaFuncionario {
    private ArrayList<Funcionario> funcionarios;

    public ListaFuncionario() {
        this.funcionarios = new ArrayList<>();
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }
}