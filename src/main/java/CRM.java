import java.util.HashMap;
import java.util.Map;

public class CRM {
    private final Map<String, Cliente> clientes;

    public CRM() {
        this.clientes = new HashMap<>();
    }

    public void adicionarCliente(String nome, String email, String telefone) {
        // Verifica se o email já existe no mapa
        if (clientes.containsKey(email.toLowerCase())) {
            System.out.println("Erro: Email já cadastrado para outro cliente.");
        } else {
            Cliente cliente = new Cliente(nome, email, telefone);
            clientes.put(email.toLowerCase(), cliente);
            System.out.println("Cliente adicionado com sucesso!");
        }
    }

    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println("Lista de clientes:");
            for (Cliente cliente : clientes.values()) {
                System.out.println(cliente);
            }
        }
    }

    public void buscarCliente(String email) {
        Cliente cliente = clientes.get(email.toLowerCase());
        if (cliente != null) {
            System.out.println(cliente);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public void modificarCliente(String emailAntigo, String novoNome, String novoEmail, String novoTelefone) {
        Cliente clienteExistente = clientes.get(novoEmail.toLowerCase());
        // Verifica se o novo email já está em uso por outro cliente
        if (clienteExistente != null && !clienteExistente.getEmail().equalsIgnoreCase(emailAntigo)) {
            System.out.println("Erro: Novo email já cadastrado para outro cliente.");
        } else {
            Cliente cliente = clientes.get(emailAntigo.toLowerCase());
            if (cliente != null) {
                cliente.setNome(novoNome);
                cliente.setEmail(novoEmail);
                cliente.setTelefone(novoTelefone);
                // Atualiza a chave do cliente no mapa se o email foi alterado
                if (!emailAntigo.equalsIgnoreCase(novoEmail)) {
                    clientes.remove(emailAntigo.toLowerCase());
                    clientes.put(novoEmail.toLowerCase(), cliente);
                }
                System.out.println("Cliente modificado com sucesso!");
            } else {
                System.out.println("Cliente não encontrado para modificar.");
            }
        }
    }
}
