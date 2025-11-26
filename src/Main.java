import controller.ClienteController;
import controller.ProdutoController;
import enums.StatusAtendimento;
import model.*;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ClienteController clienteController = new ClienteController();
        ProdutoController produtoController = new ProdutoController();

        Fornecedor fornecedorPadrao = new Fornecedor("Distribuidora Alfa", "1111-2222");

        int opcao;

        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - Atualizar e-mail de cliente");
            System.out.println("4 - Deletar cliente");
            System.out.println("5 - Cadastrar produto");
            System.out.println("6 - Listar produtos");
            System.out.println("7 - Atualizar preço do produto");
            System.out.println("8 - Deletar produto");
            System.out.println("9 - Rodar simulação completa (venda, nota, atendimento, marketing)");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Digite um número válido: ");
                scanner.next();
            }
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.println("\n=== CADASTRAR CLIENTE ===");
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("E-mail: ");
                    String email = scanner.nextLine();

                    Cliente cliente = new Cliente(nome, telefone, email);
                    clienteController.cadastrarCliente(cliente);
                }
                case 2 -> {
                    System.out.println("\n=== LISTA DE CLIENTES ===");
                    List<Cliente> clientes = clienteController.listarClientes();
                    if (clientes.isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado.");
                    } else {
                        for (Cliente c : clientes) {
                            System.out.println("- " + c.getNome() + " | " + c.getTelefone() + " | " + c.getEmail());
                        }
                    }
                }
                case 3 -> {
                    System.out.println("\n=== ATUALIZAR E-MAIL DO CLIENTE ===");
                    System.out.print("Nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Novo e-mail: ");
                    String novoEmail = scanner.nextLine();
                    clienteController.atualizarEmailCliente(nome, novoEmail);
                }
                case 4 -> {
                    System.out.println("\n=== DELETAR CLIENTE ===");
                    System.out.print("Nome do cliente: ");
                    String nome = scanner.nextLine();
                    clienteController.deletarCliente(nome);
                }
                case 5 -> {
                    System.out.println("\n=== CADASTRAR PRODUTO ===");
                    System.out.print("Nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Preço: ");
                    double preco = lerDouble(scanner);
                    System.out.print("Estoque inicial: ");
                    int estoque = lerInt(scanner);

                    Produto produto = new Produto(nome, preco, estoque, fornecedorPadrao);
                    produtoController.cadastrarProduto(produto);
                }
                case 6 -> {
                    System.out.println("\n=== LISTA DE PRODUTOS ===");
                    List<Produto> produtos = produtoController.listarProdutos();
                    if (produtos.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                    } else {
                        for (Produto p : produtos) {
                            System.out.println("- " + p.getNome()
                                    + " | Preço: " + p.getPreco()
                                    + " | Estoque: " + p.getEstoque());
                        }
                    }
                }
                case 7 -> {
                    System.out.println("\n=== ATUALIZAR PREÇO DO PRODUTO ===");
                    System.out.print("Nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Novo preço: ");
                    double novoPreco = lerDouble(scanner);
                    produtoController.atualizarPrecoProduto(nome, novoPreco);
                }
                case 8 -> {
                    System.out.println("\n=== DELETAR PRODUTO ===");
                    System.out.print("Nome do produto: ");
                    String nome = scanner.nextLine();
                    produtoController.deletarProduto(nome);
                }
                case 9 -> {
                    System.out.println("\n=== SIMULAÇÃO COMPLETA ===");
                    rodarSimulacaoCompleta(clienteController, produtoController);
                }
                case 0 -> System.out.println("\nEncerrando o sistema...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    private static double lerDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("Digite um número válido (ex: 10.5): ");
            scanner.next();
        }
        double valor = scanner.nextDouble();
        scanner.nextLine(); // consome \n
        return valor;
    }

    private static int lerInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Digite um número inteiro válido: ");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine(); // consome \n
        return valor;
    }

    private static void rodarSimulacaoCompleta(ClienteController clienteController,
                                               ProdutoController produtoController) {

        Cliente cliente;
        List<Cliente> clientes = clienteController.listarClientes();
        if (clientes.isEmpty()) {
            cliente = new Cliente("Cliente Padrão", "0000-0000", "padrao@email.com");
            clienteController.cadastrarCliente(cliente);
        } else {
            cliente = clientes.get(0); // pega o primeiro cadastrado
        }

        List<Produto> produtos = produtoController.listarProdutos();
        Fornecedor fornecedorSimulado = new Fornecedor("Distribuidora Simulação", "1111-2222");

        Produto p1;
        Produto p2;

        if (produtos.size() >= 2) {
            p1 = produtos.get(0);
            p2 = produtos.get(1);
        } else if (produtos.size() == 1) {
            p1 = produtos.get(0);
            p2 = new Produto("Produto Simulação", 10.0, 5, fornecedorSimulado);
        } else {
            p1 = new Produto("Produto A", 5.0, 10, fornecedorSimulado);
            p2 = new Produto("Produto B", 12.0, 5, fornecedorSimulado);
        }

        Funcionario funcionario = new Funcionario("João Vendedor", "8888-9999", "Vendedor");

        ItemVenda item1 = new ItemVenda(p1, 3);
        ItemVenda item2 = new ItemVenda(p2, 1);

        Venda venda = new Venda(cliente, funcionario, List.of(item1, item2));

        if (venda.confirmarVenda()) {
            System.out.println("\nVenda confirmada!");
            System.out.println("Total: R$ " + venda.getTotal());

            String nota = NotaFiscal.gerar(venda);
            System.out.println("\n📄 Nota Fiscal (JSON):\n" + nota);
        }

        System.out.println("\nEstoque depois da venda:");
        System.out.println(p1.getNome() + ": " + p1.getEstoque());
        System.out.println(p2.getNome() + ": " + p2.getEstoque());

        Atendimento atendimento = new Atendimento(cliente, "Dúvida sobre entrega");
        atendimento.mostrar();
        atendimento.atualizarStatus(StatusAtendimento.EM_ANDAMENTO);
        atendimento.mostrar();

        CampanhaMarketing camp = new CampanhaMarketing(
                "Promo Janeiro",
                "10% OFF em todos os produtos!"
        );
        camp.enviarParaClientes(new Cliente[]{cliente});

        System.out.println("\n=== Fim da simulação completa ===");
    }
}
