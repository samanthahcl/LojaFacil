package model;

import enums.StatusAtendimento;

public class Atendimento {

    private Cliente cliente;
    private String descricao;
    private StatusAtendimento status;

    public Atendimento(Cliente cliente, String descricao) {
        this.cliente = cliente;
        this.descricao = descricao;
        this.status = StatusAtendimento.ABERTO;
    }

    public void atualizarStatus(StatusAtendimento novo) {
        this.status = novo;
    }

    public void mostrar() {
        System.out.println("\nmodel.Atendimento de " + cliente.getNome());
        System.out.println("Descrição: " + descricao);
        System.out.println("Status: " + status);
    }
}
