package Model;

public class Servico {
    private String tipo;
    private int tempoDuracao;
    private double preco;

    public Servico(String tipo, int tempoDuracao, double preco) {
        this.tipo = tipo;
        this.tempoDuracao = tempoDuracao;
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getTempoDuracao() {
        return tempoDuracao;
    }

    public void setTempoDuracao(int tempoDuracao) {
        this.tempoDuracao = tempoDuracao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return tipo + " (" + tempoDuracao + " min - R$" + preco + ")";
    }
}