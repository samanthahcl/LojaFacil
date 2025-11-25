public class Produto {
    private String nome;
    private double preco;
    private int estoque;
    private Fornecedor fornecedor;

    public Produto(String nome, double preco, int estoque, Fornecedor fornecedor) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.fornecedor = fornecedor;
    }

    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getEstoque() { return estoque; }
    public Fornecedor getFornecedor() { return fornecedor; }

    public void reduzirEstoque(int quantidade) {
        this.estoque -= quantidade;
    }
}
