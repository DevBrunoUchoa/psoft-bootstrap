import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CentralLogistica {

    private static CentralLogistica instancia;

    private List<Pedido> pedidos;

    private CentralLogistica() {
        this.pedidos = new ArrayList<>();
    }

    public static CentralLogistica getInstance() {
        if (instancia == null) {
            instancia = new CentralLogistica();
        }
        return instancia;
    }

    public Pedido criaPedido(String cliente, String origem, String destino, double peso, double distancia,
            Entrega entrega) {
        Pedido pedido = new Pedido(cliente, origem, destino, peso, distancia, entrega);
        pedidos.add(pedido);
        return pedido;
    }

    public void setModalidadeEntrega(Pedido pedido, Entrega entrega) {
        pedido.setEntrega(entrega);
    }

    public void acompanhaEntrega(Pedido pedido) {
        System.out.println(pedido.getCliente() + ": custo " + pedido.calculaCusto() + ", prazo "
                + pedido.calculaPrazo() + " dias, despachado? " + pedido.isDespachada());
    }

    public List<Pedido> getPedidos() {
        return Collections.unmodifiableList(pedidos);
    }
}
