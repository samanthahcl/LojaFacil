package controller;

import model.Cliente;
import service.ClienteService;

import java.util.List;

public class ClienteController {

    private ClienteService clienteService = new ClienteService();

    public void cadastrarCliente(Cliente cliente) {
        clienteService.cadastrarCliente(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    public void atualizarEmailCliente(String nome, String novoEmail) {
        clienteService.atualizarEmailCliente(nome, novoEmail);
    }

    public void deletarCliente(String nome) {
        clienteService.deletarCliente(nome);
    }
}

