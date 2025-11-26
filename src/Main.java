import controller.ClienteController;
import controller.ProdutoController;
import enums.StatusAtendimento;
import model.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // CONTROLLERS (camada de controle)
        ClienteController clienteController = new ClienteController();
        ProdutoController produtoController = new ProdutoController();

        // === CADASTROS BÁSICOS (CRUD - CREATE) ===

        // Fornecedor
        Fornecedor forn = new Fornecedor("Distribuidora Alfa", "1111-2222");

        // Produtos
        Produto caneta = new Produto("Caneta Azul", 2.50, 10, forn);
        Produto caderno = new Produto("Caderno 100fls", 12.00, 5, forn);

        // Cadastrando produtos via controller (CRUD)
        produtoController.cadastrarProduto(caneta);
        produtoController.cadastrarProduto(caderno);

        // Cliente
        Cliente maria = new Cliente("Maria Silva", "9999-9999", "maria@gmail.com");

        // Cadastrando cliente via controller (CRUD)
        clienteController.cadastrarCliente(maria);

        // Funcionário
        Funcionario joao = new Funcionario("João Vendedor", "8888-9999", "Vendedor");

        // === LISTAGENS (CRUD - READ) ===
        System.out.println("\n=== Clientes cadastrados ===");
        for (Cliente c : clienteController.listarClientes()) {
            System.out.println("- " + c.getNome());
        }

        System.out.println("\n=== Produtos cadastrados ===");
        for (Produto p : produtoController.listarProdutos()) {
            System.out.println("- " + p.getNome() + " | Estoque: " + p.getEstoque());
        }

        // === MÓDULO DE VENDAS ===

        // Itens da venda
        ItemVenda item1 = new ItemVenda(caneta, 3);
        ItemVenda item2 = new ItemVenda(caderno, 1);

        Venda venda = new Venda(maria, joao, List.of(item1, item2));

        if (venda.confirmarVenda()) {
            System.out.println("\nVenda confirmada!");
            System.out.println("Total: R$ " + venda.getTotal());

            String nota = NotaFiscal.gerar(venda);
            System.out.println("\n📄 Nota Fiscal (JSON):\n" + nota);
        }

        // Estoque após a venda
        System.out.println("\nEstoque depois da venda:");
        System.out.println(caneta.getNome() + ": " + caneta.getEstoque());
        System.out.println(caderno.getNome() + ": " + caderno.getEstoque());

        // === ATENDIMENTO AO CLIENTE ===
        Atendimento atend = new Atendimento(maria, "Dúvida sobre entrega");
        atend.mostrar();
        atend.atualizarStatus(StatusAtendimento.EM_ANDAMENTO);
        atend.mostrar();

        // === MARKETING ===
        CampanhaMarketing camp = new CampanhaMarketing(
                "Promo Janeiro",
                "10% OFF em todos os produtos!"
        );
        camp.enviarParaClientes(new Cliente[]{maria});

        // (se quiser, depois a gente adiciona exemplos de UPDATE e DELETE usando os services)
    }
}
