import java.util.Date;

public class Sprint {

    private int id;
    private String objetivo;
    private Date dataInicio;
    private Date dataFim;
    private boolean concluida;
    private Pessoa lider;

    public Sprint(int id, Date dataInicio, Date dataFim, String objetivo, Pessoa lider) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.objetivo = objetivo;
        this.lider = lider;
        this.concluida = false;
    }

    public void setLider(Pessoa lider) {
        this.lider = lider;
    }

    public void encerra() {
        this.concluida = true;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public int getId() {
        return id;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public Pessoa getLider() {
        return lider;
    }
}