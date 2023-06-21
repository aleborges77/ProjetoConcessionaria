package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Concessionaria {
    private final String nome;
    private final List<Carro> estoque;
    private Funcionario funcionario;

    // Constructor
    public Concessionaria(String nome) {
        this.nome = nome;
        this.estoque = new ArrayList<>();
    }

    // Methods
    public void adicionarCarro(Carro carro) {
        estoque.add(carro);
    }

    public void exibirEstoque() {
        System.out.println("Estoque da Concessionária " + nome + ":");
        for (Carro carro : estoque) {
            System.out.println(carro.getMarca() + " " + carro.getModelo() + " " + carro.getAno());
        }
    }

    public void realizarVenda(Carro carro, Cliente cliente) {
        if (estoque.contains(carro)) {
            estoque.remove(carro);
            System.out.println("Venda realizada: " + carro.getMarca() + " " + carro.getModelo() +
                    " " + carro.getAno() + " para o cliente " + cliente.getNome());
        } else {
            System.out.println("Desculpe, o carro não está disponível no momento.");
        }
    }

    public void contratarFuncionario(Funcionario funcionario1) {
        funcionario = funcionario1;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void exibirFuncionarios() {
    }

    public boolean realizarVenda(Carro carro1, Cliente cliente1, MetodoPagamento metodoPagamento1) {
        return false;
    }

    public Object[] getEstoque() {
        return new Object[0];
    }

    public Iterable<? extends Funcionario> getFuncionarios() {
        return null;
    }

    public Collection<Object> getClientes() {
        return null;
    }
}





