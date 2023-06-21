package repository;

import model.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static Concessionaria concessionaria;
    private static List<Cliente> clientes;
    private static List<Carro> carros;
    private static SPC spc;

    public static void main(String[] args) {
        exibirMensagemBoasVindas();

        concessionaria = new Concessionaria("Concessionária de Luxo");
        clientes = new ArrayList<>();
        carros = new ArrayList<>();
        spc = new SPC();

        exibirMenu();
    }

    private static void exibirMensagemBoasVindas() {
        JOptionPane.showMessageDialog(null, "Bem-vindo a Premium Cars",
                "Mensagem de Boas-vindas", JOptionPane.INFORMATION_MESSAGE);
    }

    /* private static void chamaMenuCadastros() throws SQLException, ClassNotFoundException {
        String[] opcoesMenuCadastro = {"Pessoa", "Seguradora", "Seguro", "Voltar"};
        int menuCadastro = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Menu Cadastros",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuCadastro, opcoesMenuCadastro[0]);

        switch (menuCadastro) {
            case 0: //Pessoa
                Pessoa pessoa = chamaCadastroPessoa();
                if (pessoa != null) getPessoaDAO().salvar(pessoa);
                chamaMenuCadastros();
                break;
            case 1: //Seguradoras
                Seguradora seguradora = chamaCadastroSeguradora();
                if (seguradora != null) getSeguradoraDAO().salvar(seguradora);
                chamaMenuCadastros();
                break;
            case 2: //Seguro
                Seguro seguro = chamaCadastroSeguro();
                if (seguro != null) getSeguroDAO().salvar(seguro);
                chamaMenuCadastros();
                break;
            case 3: //Voltar
                chamaMenuPrincipal();
                break;
        }
    }*/




    private static void exibirMenu() {
        boolean sair = false;

        while (!sair) {
            String opcao = JOptionPane.showInputDialog(
                    "Selecione uma opção:\n" +
                            "1 - Cadastrar Cliente\n" +
                            "2 - Adicionar Carro ao Estoque\n" +
                            "3 - Exibir Estoque\n" +
                            "4 - Realizar Venda\n" +
                            "5 - Sair");

            switch (opcao) {
                case "1":
                    cadastrarCliente();
                    break;
                case "2":
                    adicionarCarroEstoque();
                    break;
                case "3":
                    exibirEstoque();
                    break;
                case "4":
                    realizarVenda();
                    break;
                case "5":
                    sair = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }
        }
    }

    private static void cadastrarCliente() {
        String nome = JOptionPane.showInputDialog("Informe o nome do cliente:");
        String endereco = JOptionPane.showInputDialog("Informe o endereço do cliente:");
        String telefone = JOptionPane.showInputDialog("Informe o telefone do cliente:");

        Cliente cliente = new Cliente(nome, endereco, telefone);
        clientes.add(cliente);

        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
    }

    private static void adicionarCarroEstoque() {
        String marca = JOptionPane.showInputDialog("Informe a marca do carro:");
        String modelo = JOptionPane.showInputDialog("Informe o modelo do carro:");
        int ano = Integer.parseInt(JOptionPane.showInputDialog("Informe o ano do carro:"));
        String cor = JOptionPane.showInputDialog("Informe a cor do carro:");
        double preco = Double.parseDouble(JOptionPane.showInputDialog("Informe o preço do carro:"));
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do carro:"));

        Carro carro = new Carro(marca, modelo, ano, cor, preco, codigo);
        carros.add(carro);

        JOptionPane.showMessageDialog(null, "Carro adicionado ao estoque com sucesso!");
    }

    private static void exibirEstoque() {
        StringBuilder estoque = new StringBuilder();
        estoque.append("Estoque:\n");

        for (Carro carro : carros) {
            estoque.append(carro.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(null, estoque.toString());
    }

    private static void realizarVenda() {
        int codigoCarro = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do carro que deseja vender:"));
        Carro carroSelecionado = null;

        for (Carro carro : carros) {
            if (carro.getCodigo() == codigoCarro) {
                carroSelecionado = carro;
                break;
            }
        }

        if (carroSelecionado == null) {
            JOptionPane.showMessageDialog(null, "Carro não encontrado no estoque!");
            return;
        }

        int indiceCliente = Integer.parseInt(JOptionPane.showInputDialog("Informe o índice do cliente que está comprando o carro:"));

        if (indiceCliente >= 0 && indiceCliente < clientes.size()) {
            Cliente cliente = clientes.get(indiceCliente);

            boolean clienteNegativado = spc.verificarClienteNegativado(cliente);

            if (clienteNegativado) {
                JOptionPane.showMessageDialog(null, "Cliente negativado no SPC. Venda não pode ser realizada!");
            } else {
                MetodoPagamento metodoPagamento = MetodoPagamento.valueOf(
                        JOptionPane.showInputDialog("Informe o método de pagamento (FINANCIAMENTO ou PAGAMENTO_A_VISTA):"));

                concessionaria.realizarVenda(carroSelecionado, cliente, metodoPagamento);

                JOptionPane.showMessageDialog(null, "Venda realizada com sucesso!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Índice de cliente inválido!");
        }
    }
}
