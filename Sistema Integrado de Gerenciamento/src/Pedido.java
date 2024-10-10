package src;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<ItemDoPedido> itens;
    private List<Integer> opcoesPorcao;
    private boolean finalizado;

    public Pedido() {
        this.itens = new ArrayList<>();
        this.opcoesPorcao = new ArrayList<>();
        this.finalizado = false;
    }

    public void addItem(ItemDoPedido item, int opcaoPorcao) {
        if (!finalizado) {
            itens.add(item);
            opcoesPorcao.add(opcaoPorcao);
        } else {
            System.out.println("O pedido já foi finalizado e entregue.");
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < itens.size(); i++) {
            ItemDoPedido item = itens.get(i);
            int opcao = opcoesPorcao.get(i);
            total += item.getPreco(opcao);
        }
        return total;
    }

    public boolean ehFinalizado() {
        return finalizado;
    }

    public void finalizarPedido() {
        this.finalizado = true;
    }

    public List<ItemDoPedido> getItens() {
        return itens;
    }

    public String exibirDetalhesPedido() {
        StringBuilder detalhesPedido = new StringBuilder();
        for (int i = 0; i < itens.size(); i++) {
            ItemDoPedido item = itens.get(i);
            int opcao = opcoesPorcao.get(i);
            detalhesPedido.append(item.getNome()).append(" - R$ ").append(item.getPreco(opcao)).append("\n");
        }
        detalhesPedido.append("Total: R$ ").append(calcularTotal());
        return detalhesPedido.toString();
    }
}
