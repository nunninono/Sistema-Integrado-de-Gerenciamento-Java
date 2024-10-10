package src;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restaurante {
    private List<Mesa> mesas;
    private List<ItemDoPedido> menu;
    private double totalVendas;

    public Restaurante() {
        mesas = new ArrayList<>();
        menu = new ArrayList<>();
        inicializarMenu();
        inicializarMesas(15);
    }

    private void inicializarMesas(int quantidade) {
        for (int i = 1; i <= quantidade; i++) {
            mesas.add(new Mesa(i));
        }
    }

    public List<Mesa> getMesas() {
        return mesas;
    }    

    private void inicializarMenu() {
        menu.add(new ItemDoPedido("Galeto na Brasa", 28.00, 56.00, 112.00));
        menu.add(new ItemDoPedido("Carne de Sol", 25.00, 50.00, 100.00));
        menu.add(new ItemDoPedido("Picanha Argentina", 32.00, 64.00, 128.00));
        menu.add(new ItemDoPedido("Batata Frita", 11.00, 22.00, 44.00));
        menu.add(new ItemDoPedido("Refrigerante 1L", 8.00));
        menu.add(new ItemDoPedido("Refrigerante 2L", 12.00));
        menu.add(new ItemDoPedido("Copo de Suco", 5.00));
        menu.add(new ItemDoPedido("Jarra de Suco", 10.00));
    }

    public void exibirMenu() {
        System.out.println("\n----- Menu do Restaurante -----");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i).toString());
        }
    }
    
    public void fecharConta(int numeroMesa, Scanner scanner) {
        if (numeroMesa > 0 && numeroMesa <= mesas.size()) {
            Mesa mesa = mesas.get(numeroMesa - 1);
            if (!mesa.isOcupada()) {
                System.out.println("A Mesa " + numeroMesa + " não está ocupada.");
                return;
            }
    
            if (!mesa.pedidoFinalizado()) {
                double total = mesa.getTotalPedido();
                System.out.println("\n----- Pagamento -----");
                System.out.println("Total a pagar da Mesa " + numeroMesa + ": R$ " + total);
    
                if (total == 0) {
                    mesa.fecharConta();
                    System.out.println("Conta da Mesa " + numeroMesa + " finalizada com sucesso sem pagamento necessário!");
                } else {
                    System.out.print("Deseja finalizar a conta e realizar o pagamento? (1 - Sim | 2 - Não): ");
                    int opcao = scanner.nextInt();
                    if (opcao == 1) {
                        mesa.fecharConta();
                        totalVendas += total;
                        System.out.println("Conta da Mesa " + numeroMesa + " finalizada com sucesso!");
                    } else {
                        System.out.println("Pagamento não realizado. Conta não fechada.");
                    }
                }
            } else {
                System.out.println("A conta da Mesa " + numeroMesa + " já foi fechada.");
            }
        } else {
            System.out.println("Mesa inválida.");
        }
    }    

    public void fazerPedido(int numeroMesa, Scanner scanner) {
        if (numeroMesa > 0 && numeroMesa <= mesas.size()) {
            Mesa mesa = mesas.get(numeroMesa - 1);

            if (mesa.pedidoFinalizado()) {
                System.out.println("Não é possível adicionar mais itens. A conta já foi fechada.");
                return;
            }

            boolean adicionarItens = true;
            while (adicionarItens) {
                exibirMenu();
                System.out.print("Escolha o número do item ou 0 para sair: ");
                int numeroItem = scanner.nextInt();
    
                if (numeroItem == 0) {
                    adicionarItens = false;
                    System.out.println("Pedido finalizado.");
                } else if (numeroItem > 0 && numeroItem <= menu.size()) {
                    ItemDoPedido item = menu.get(numeroItem - 1);

                    if (item.ehUnitario()) {
                        System.out.println("Este produto é unitário. Item adicionado ao pedido.");
                        mesa.addPedido(item, 1);
                    } else {
                        System.out.println("1 - Individual, 2 - Duas pessoas, 3 - Quatro pessoas");
                        System.out.print("Escolha a porção: ");
                        int opcaoPorcao = scanner.nextInt();
    
                        if (opcaoPorcao < 1 || opcaoPorcao > 3) {
                            System.out.println("Porção inválida. Por favor, escolha entre 1, 2 ou 3.");
                        } else {
                            mesa.addPedido(item, opcaoPorcao);
                            System.out.println("Item adicionado ao pedido.");
                        }
                    }
                } else {
                    System.out.println("Item inválido.");
                }
            }
        } else {
            System.out.println("Mesa inválida.");
        }
    }

    public void verificarPedido(int numeroMesa) {
        if (numeroMesa > 0 && numeroMesa <= mesas.size()) {
            Mesa mesa = mesas.get(numeroMesa - 1);
            if (mesa.isOcupada()) {
                System.out.println("\n----- Pedido da Mesa " + numeroMesa + " -----");
                mesa.exibirPedido();
                System.out.println("\n----------------------");
                System.out.println("Total do pedido: R$ " + mesa.getTotalPedido());
            } else {
                System.out.println("A Mesa " + numeroMesa + " não está ocupada.");
            }
        } else {
            System.out.println("Mesa inválida.");
        }
    }    

    public void liberarMesa(int numeroMesa) {
        if (numeroMesa > 0 && numeroMesa <= mesas.size()) {
            Mesa mesa = mesas.get(numeroMesa - 1);
            if (mesa.isOcupada()) {
                if (mesa.pedidoFinalizado()) {
                    mesa.liberarMesa();
                    System.out.println("Mesa " + numeroMesa + " liberada com sucesso.");
                } else {
                    System.out.println("A conta da Mesa " + numeroMesa + " precisa ser fechada antes de liberar.");
                }
            } else {
                mesa.liberarMesa();
                System.out.println("Mesa " + numeroMesa + " já se encontra liberada.");
            }
        } else {
            System.out.println("Mesa inválida.");
        }
    }

    public void cancelarPedido(int numeroMesa, Scanner scanner) {
        if (numeroMesa > 0 && numeroMesa <= mesas.size()) {
            Mesa mesa = mesas.get(numeroMesa - 1);
            if (mesa.isOcupada()) {
                System.out.println("1. Cancelar item específico");
                System.out.println("2. Cancelar todos os pedidos");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                
                if (opcao == 1) {
                    mesa.exibirPedido();
                    System.out.print("Escolha o número do item a cancelar: ");
                    int indiceItem = scanner.nextInt() - 1;
                    mesa.cancelarItem(indiceItem);
                } else if (opcao == 2) {
                    mesa.cancelarPedido();
                } else {
                    System.out.println("Opção inválida.");
                }
            } else {
                System.out.println("Mesa " + numeroMesa + " não está ocupada.");
            }
        } else {
            System.out.println("Mesa inválida.");
        }
    }    
    
    public void gerarRelatorio() {
        double totalMesas = 0;
        System.out.println("----- Relatório de Pedidos -----");
        for (Mesa mesa : mesas) {
            if (mesa.isOcupada()) {
                mesa.exibirPedido();
                totalMesas += mesa.getTotalPedido();
                System.out.println("-------------------------");
            }
        }
        System.out.println("Total de vendas de todas as mesas no momento: R$ " + totalMesas);
        System.out.println("Total de vendas acumulado do dia: R$ " + totalVendas);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restaurante restaurante = new Restaurante();

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nMENU DE OPÇÕES:");
            System.out.println("1. Exibir Menu");
            System.out.println("2. Fazer Pedido");
            System.out.println("3. Fechar Conta");
            System.out.println("4. Buscar Pedido");
            System.out.println("5. Liberar Mesa");
            System.out.println("6. Cancelar Pedido");
            System.out.println("7. Gerar Relatório");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    restaurante.exibirMenu();
                    break;
                case 2:
                    System.out.print("\nNúmero da Mesa: ");
                    int numeroMesa = scanner.nextInt();
                    restaurante.fazerPedido(numeroMesa, scanner);
                    break;
                case 3:
                    System.out.print("\nNúmero da Mesa: ");
                    int mesa = scanner.nextInt();
                    restaurante.fecharConta(mesa, scanner);
                    break;
                case 4:
                    System.out.print("\nNúmero da Mesa: ");
                    int mesaVerificar = scanner.nextInt();
                    restaurante.verificarPedido(mesaVerificar);
                    break;
                case 5:
                    System.out.print("\nNúmero da Mesa a liberar: ");
                    int mesaLiberar = scanner.nextInt();
                    restaurante.liberarMesa(mesaLiberar);
                    break;
                case 6:
                    System.out.print("\nNúmero da Mesa para cancelar o pedido: ");
                    int MesaCancelar = scanner.nextInt();
                    restaurante.cancelarPedido(MesaCancelar, scanner);
                    break;
                case 7:
                    restaurante.gerarRelatorio();
                    break;
                case 8:
                    System.out.println("\nAgradecemos pela preferência!");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
}