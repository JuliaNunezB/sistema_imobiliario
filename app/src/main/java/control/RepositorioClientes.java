package control;
import model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class RepositorioClientes {
    private List<Cliente> clientes;

    // Construtor
    public RepositorioClientes() {
        clientes = new ArrayList<>();
    }

    // Métodos para gerenciar clientes
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void removerCliente(String id) {
        clientes.removeIf(cliente -> cliente.getId().equals(id));
    }

    public Cliente buscarClientePorId(String id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }

    public List<Cliente> listarTodos() {
        return new ArrayList<>(clientes);
    }
}

