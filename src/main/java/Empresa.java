import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Empresa {

    private Pessoa productOwner;
    private Map<Integer, Time> times;
    private int proximoTimeId;

    public Empresa(Pessoa productOwner) {
        if (!productOwner.hasPapel(TipoPapel.PRODUCT_OWNER)) {
            productOwner.addPapel(new ProductOwner());
        }
        this.productOwner = productOwner;
        this.times = new HashMap<>();
        this.proximoTimeId = 1;
    }

    public Time criaTime(ProdutoSoftware produto) {
        Time time = new Time(proximoTimeId, produto);
        times.put(proximoTimeId, time);
        proximoTimeId++;
        return time;
    }

    public void promoveGerente(int idTime) {
        Time time = times.get(idTime);
        if (time == null) {
            throw new IllegalArgumentException("Time nao encontrado: " + idTime);
        }

        Pessoa gerente = time.getGerente();
        if (gerente == null) {
            throw new IllegalArgumentException("Time ainda nao possui gerente: " + idTime);
        }

        productOwner.removePapel(TipoPapel.PRODUCT_OWNER);
        gerente.removePapel(TipoPapel.GERENTE);
        gerente.addPapel(new ProductOwner());
        this.productOwner = gerente;
    }

    public Pessoa getProductOwner() {
        return productOwner;
    }

    public Map<Integer, Time> getTimes() {
        return Collections.unmodifiableMap(times);
    }
}