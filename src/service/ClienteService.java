package service;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteService {

    private List<Cliente> clientes = new ArrayList<>();

    // criar
    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso: " + cliente.getNome());
    }

    // ler
    public List<Cliente> listarClientes() {
        return clientes;
    }

    // att
    public void atualizarEmailCliente(String nome, String novoEmail) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                // aqui você precisa ter um setEmail no Cliente
                // cliente.setEmail(novoEmail);
                System.out.println("Email atualizado com sucesso para: " + nome);
                return;
            }
        }
        System.out.println("Cliente não encontrado: " + nome);
    }

    // deletando
    public void deletarCliente(String nome) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getNome().equalsIgnoreCase(nome)) {
                clientes.remove(i);
                System.out.println("Cliente deletado com sucesso: " + nome);
                return;
            }
        }
        System.out.println("Cliente não encontrado: " + nome);
    }
}
