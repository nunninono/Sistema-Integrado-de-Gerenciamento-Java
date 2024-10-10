package src;
import java.util.ArrayList;
import java.util.List;

public class Mesa {
    private int numero;
    private List<ItemDoPedido> pedidos;
    private List<Integer> opcoesPorcao;
    private boolean ocupada;
    private boolean pedidoFinalizado;

    public Mesa(int numero) {
        this.numero = numero;
        this.pedidos = new ArrayList<>();
        this.opcoesPorcao = new ArrayList<>();
        this.ocupada = false;
        this.pedidoFinalizado = false;
    }

    public void addPedido(ItemDoPedido item, int opcaoPorcao) {
        if (!ocupada) {
            ocupada = true;
        }
        pedidos.add(item);
        opcoesPorcao.add(opcaoPorcao);
    }

    public double fecharConta() {
        double total = getTotalPedido();
        pedidoFinalizado = true;
        return total;
    }

    public boolean pedidoFinalizado() {
        return pedidoFinalizado;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public List<ItemDoPedido> getPedidos() {
        return pedidos;
    }

    public int getNumero() {
        return numero;
    }
    
    public double getTotalPedido() {
        double total = 0;
        for (int i = 0; i < pedidos.size(); i++) {
            ItemDoPedido item = pedidos.get(i);
            int opcao = opcoesPorcao.get(i);
            total += item.getPreco(opcao);
        }
        return total;
    }

    public void exibirPedido() {
        System.out.println("Mesa " + numero + " - Itens do Pedido:");
        for (int i = 0; i < pedidos.size(); i++) {
            ItemDoPedido item = pedidos.get(i);
            int opcao = opcoesPorcao.get(i);
            System.out.println((i + 1) + ". " + item.getNome() + " - R$ " + item.getPreco(opcao));
        }
    }

    public void liberarMesa() {
        pedidos.clear();
        opcoesPorcao.clear();
        ocupada = false;
        pedidoFinalizado = false;
    }

    public void cancelarItem(int indice) {
        if (indice >= 0 && indice < pedidos.size() && !pedidoFinalizado) {
            pedidos.remove(indice);
            opcoesPorcao.remove(indice);
            System.out.println("Item " + (indice + 1) + " cancelado com sucesso.");
        } else {
            System.out.println("Cancelamento não pode ser realizado. Verifique o índice ou se a conta já foi fechada.");
        }
    }
    
    public void cancelarPedido() {
        if (pedidos.isEmpty()) {
            System.out.println("Não há pedidos para cancelar.");
        } else {
            pedidos.clear();
            System.out.println("Todos os pedidos da mesa " + numero + " foram cancelados.");
        }
    }
}
