package model;

public class CampanhaMarketing {

    private String nome;
    private String mensagem;

    public CampanhaMarketing(String nome, String mensagem) {
        this.nome = nome;
        this.mensagem = mensagem;
    }

    public void enviarParaClientes(Cliente[] clientes) {
        System.out.println("\n📢 Enviando campanha: " + nome);
        for (Cliente c : clientes) {
            System.out.println("Enviado para " + c.getNome() + ": " + mensagem);
        }
    }
}
