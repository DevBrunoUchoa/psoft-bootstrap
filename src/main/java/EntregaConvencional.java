public class EntregaConvencional implements Entrega {

    private static final double TARIFA_FIXA = 10.0;
    private static final double VALOR_POR_KM = 1.5;
    private static final int PRAZO_DIAS = 5;

    @Override
    public double calculaCusto(Pedido pedido) {
        return TARIFA_FIXA + VALOR_POR_KM * pedido.getDistancia();
    }

    @Override
    public int calculaPrazo(Pedido pedido) {
        return PRAZO_DIAS;
    }
}
