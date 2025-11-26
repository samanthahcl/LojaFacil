package controller;

import model.Produto;
import service.ProdutoService;

import java.util.List;

public class ProdutoController {

    private ProdutoService produtoService = new ProdutoService();

    public void cadastrarProduto(Produto produto) {
        produtoService.cadastrarProduto(produto);
    }

    public List<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }

    public void atualizarPrecoProduto(String nome, double novoPreco) {
        produtoService.atualizarPrecoProduto(nome, novoPreco);
    }

    public void deletarProduto(String nome) {
        produtoService.deletarProduto(nome);
    }
}
