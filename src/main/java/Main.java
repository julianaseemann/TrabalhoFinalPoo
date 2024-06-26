import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CRM crm = new CRM();
        int opcao;

        do {
            System.out.println("\n--- Menu CRM ---");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Buscar Cliente");
            System.out.println("4. Modificar Cliente");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Insira o nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Insira o email: ");
                    String email = scanner.nextLine();
                    System.out.print("Insira o telefone: ");
                    String telefone = scanner.nextLine();
                    crm.adicionarCliente(nome, email, telefone);
                }
                case 2 -> crm.listarClientes();
                case 3 -> {
                    System.out.print("Insira o Email do cliente que deseja buscar: ");
                    String emailBusca = scanner.nextLine();
                    crm.buscarCliente(emailBusca);
                }
                case 4 -> {
                    System.out.print("Insira o Email do cliente que deseja modificar: ");
                    String emailModifica = scanner.nextLine();
                    System.out.print("Insira o novo nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Insira o novo email: ");
                    String novoEmail = scanner.nextLine();
                    System.out.print("Insira o novo telefone: ");
                    String novoTelefone = scanner.nextLine();
                    crm.modificarCliente(emailModifica, novoNome, novoEmail, novoTelefone);
                }
                case 5 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }
}