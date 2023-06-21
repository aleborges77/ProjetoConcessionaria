package dao;

import model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {
    private Connection connection;

    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserir(Cliente cliente) throws SQLException {
        String query = "INSERT INTO clientes (nome, cpf, endereco) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getCpf());
            statement.setString(3, cliente.getEndereco());
            statement.executeUpdate();
        }
    }

    public Cliente buscarPorCpf(String cpf) throws SQLException {
        String query = "SELECT nome, endereco FROM clientes WHERE cpf = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, cpf);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String nome = resultSet.getString("nome");
                    String endereco = resultSet.getString("endereco");
                    return new Cliente(nome, cpf, endereco);
                }
            }
        }
        return null;
    }

    public void atualizar(Cliente cliente) throws SQLException {
        String query = "UPDATE clientes SET nome = ?, endereco = ? WHERE cpf = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getEndereco());
            statement.setString(3, cliente.getCpf());
            statement.executeUpdate();
        }
    }

    public void excluir(String cpf) throws SQLException {
        String query = "DELETE FROM clientes WHERE cpf = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, cpf);
            statement.executeUpdate();
        }
    }
}

