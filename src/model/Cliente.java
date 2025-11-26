package model;

public class Cliente extends Pessoa {

    private String email;

    public Cliente(String nome, String telefone, String email) {
        super(nome, telefone);
        this.email = email;
    }

    public String getEmail() { return email; }
}
