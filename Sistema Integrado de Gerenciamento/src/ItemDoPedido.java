package src;
public class ItemDoPedido {
    private String nome;
    private double preco;
    private double precoDuasPessoas;
    private double precoQuatroPessoas;

    public ItemDoPedido(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
        this.precoDuasPessoas = 0;
        this.precoQuatroPessoas = 0;
    }

    public ItemDoPedido(String nome, double preco, double precoDuasPessoas, double precoQuatroPessoas) {
        this.nome = nome;
        this.preco = preco;
        this.precoDuasPessoas = precoDuasPessoas;
        this.precoQuatroPessoas = precoQuatroPessoas;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public double getPreco(int opcaoPorcao) {
        switch (opcaoPorcao) {
            case 1: return preco;
            case 2: return precoDuasPessoas;
            case 3: return precoQuatroPessoas;
            default: return 0;
        }
    }

    public boolean ehUnitario() {
        return precoDuasPessoas == 0 && precoQuatroPessoas == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(nome).append(" - R$ ").append(preco);
        if (!ehUnitario()) {
            sb.append(" -- R$ ").append(precoDuasPessoas).append(" (2 pessoas) -- R$ ").append(precoQuatroPessoas).append(" (4 pessoas)");
        }
        return sb.toString();
    }
}