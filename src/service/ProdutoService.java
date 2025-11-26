package service;

import model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoService {

    private List<Produto> produtos = new ArrayList<>();

    // criar
    public void cadastrarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println("Produto cadastrado: " + produto.getNome());
    }

    // ler
    public List<Produto> listarProdutos() {
        return produtos;
    }

    // att
    public void atualizarPrecoProduto(String nome, double novoPreco) {
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                // precisa ter setPreco no Produto
                // produto.setPreco(novoPreco);
                System.out.println("Preço atualizado para produto: " + nome);
                return;
            }
        }
        System.out.println("Produto não encontrado: " + nome);
    }

    // deletar
    public void deletarProduto(String nome) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getNome().equalsIgnoreCase(nome)) {
                produtos.remove(i);
                System.out.println("Produto removido: " + nome);
                return;
            }
        }
        System.out.println("Produto não encontrado: " + nome);
    }
}
