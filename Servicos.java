package model;

public class Servicos {
    private String nome;
    private double preco;

    public Servicos(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    // Getters and setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    // Método toString()

    @Override
    public String toString() {
        return "Servico{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }
}
