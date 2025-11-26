package service;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteService {

    private List<Cliente> clientes = new ArrayList<>();

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso: " + cliente.getNome());
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }

    public void atualizarEmailCliente(String nome, String novoEmail) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                cliente.setEmail(novoEmail);   // ← AGORA ATUALIZA MESMO
                System.out.println("Email atualizado com sucesso para: " + nome);
                return;
            }
        }
        System.out.println("Cliente não encontrado: " + nome);
    }

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
