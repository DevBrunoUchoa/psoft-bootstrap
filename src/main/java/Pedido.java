public class Pedido {

    private String cliente;
    private String origem;
    private String destino;
    private double peso;
    private double distancia;
    private Entrega entrega;
    private boolean despachada;

    public Pedido(String cliente, String origem, String destino, double peso, double distancia, Entrega entrega) {
        this.cliente = cliente;
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
        this.distancia = distancia;
        this.entrega = entrega;
        this.despachada = false;
    }

    public void setEntrega(Entrega entrega) {
        if (despachada) {
            throw new IllegalStateException("Pedido ja despachado: " + cliente);
        }
        this.entrega = entrega;
    }

    public void despachar() {
        this.despachada = true;
    }

    public boolean isDespachada() {
        return despachada;
    }

    public double calculaCusto() {
        return entrega.calculaCusto(this);
    }

    public int calculaPrazo() {
        return entrega.calculaPrazo(this);
    }

    public String getCliente() {
        return cliente;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public double getPeso() {
        return peso;
    }

    public double getDistancia() {
        return distancia;
    }

    public Entrega getEntrega() {
        return entrega;
    }
}
