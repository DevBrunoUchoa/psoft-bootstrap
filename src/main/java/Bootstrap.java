public class Bootstrap {

    public static void main(String[] args) {
        CentralLogistica central = CentralLogistica.getInstance();

        Pedido pedido = central.criaPedido("Alice", "Campina Grande", "Joao Pessoa", 2.5, 120.0,
                new EntregaConvencional());
        central.acompanhaEntrega(pedido);

        central.setModalidadeEntrega(pedido, new EntregaExpressa());
        central.acompanhaEntrega(pedido);

        pedido.despachar();
        try {
            central.setModalidadeEntrega(pedido, new EntregaEconomica());
        } catch (IllegalStateException e) {
            System.out.println("Nao foi possivel trocar a modalidade: " + e.getMessage());
        }
        central.acompanhaEntrega(pedido);
    }
}
