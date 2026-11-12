public class EntregaExpressa implements Entrega {

    private static final double TARIFA_BASE = 20.0;
    private static final double VALOR_POR_KM = 2.0;
    private static final double ADICIONAL_PRIORIDADE = 15.0;
    private static final int PRAZO_DIAS = 1;

    @Override
    public double calculaCusto(Pedido pedido) {
        return TARIFA_BASE + VALOR_POR_KM * pedido.getDistancia() + ADICIONAL_PRIORIDADE;
    }

    @Override
    public int calculaPrazo(Pedido pedido) {
        return PRAZO_DIAS;
    }
}
