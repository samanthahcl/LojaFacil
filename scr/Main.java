public class Main {
    public static void main(String[] args) {
        Cliente c = new Cliente("Maria", "9999-9999", "maria@gmail.com");
        Funcionario f = new Funcionario("João", "8888-8888", "Vendedor");

        System.out.println("Cliente: " + c.getNome());
        System.out.println("Funcionário: " + f.getNome() + " - " + f.getCargo());
    }
}
