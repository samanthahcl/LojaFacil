package model;

import java.util.List;

public class Venda {

    private Cliente cliente;
    private Funcionario funcionario;
    private List<ItemVenda> itens;
    private double total;

    public Venda(Cliente cliente, Funcionario funcionario, List<ItemVenda> itens) {
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.itens = itens;
        calcularTotal();
    }

    private void calcularTotal() {
        total = 0;
        for (ItemVenda item : itens) {
            total += item.getSubtotal();
        }
    }

    public boolean confirmarVenda() {
        // validação do estoque
        for (ItemVenda item : itens) {
            if (item.getQuantidade() > item.getProduto().getEstoque()) {
                System.out.println("Estoque insuficiente para: " + item.getProduto().getNome());
                return false;
            }
        }

        // atualização de estoque
        for (ItemVenda item : itens) {
            item.getProduto().reduzirEstoque(item.getQuantidade());
        }

        // cálculo total
        return true;
    }

    public double getTotal() { return total; }
    public Cliente getCliente() { return cliente; }
    public Funcionario getFuncionario() { return funcionario; }
    public List<ItemVenda> getItens() { return itens; }
}
