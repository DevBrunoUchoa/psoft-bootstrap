public class EntregaEconomica implements Entrega {

    private static final double TARIFA_FIXA = 5.0;
    private static final double VALOR_POR_KM = 0.8;
    private static final int PRAZO_DIAS = 10;

    @Override
    public double calculaCusto(Pedido pedido) {
        return TARIFA_FIXA + VALOR_POR_KM * pedido.getDistancia();
    }

    @Override
    public int calculaPrazo(Pedido pedido) {
        return PRAZO_DIAS;
    }
}
