package Model;

public class Pessoa {
    private String nome;
    private String celular; // Alterado de int para String
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() { // Alterado para String
        return celular;
    }

    public void setCelular(String celular) { // Alterado para String
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}