import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Time {

    private int id;
    private ProdutoSoftware produto;
    private Pessoa gerente;
    private Map<String, Pessoa> desenvolvedores;
    private Map<Integer, Sprint> sprints;
    private int proximoSprintId;

    public Time(int id, ProdutoSoftware produto) {
        this.id = id;
        this.produto = produto;
        this.gerente = null;
        this.desenvolvedores = new HashMap<>();
        this.sprints = new HashMap<>();
        this.proximoSprintId = 1;
    }

    public String addDesenvolvedor(Pessoa pessoa) {
        if (pessoa.hasPapel(TipoPapel.GERENTE) || pessoa.hasPapel(TipoPapel.PRODUCT_OWNER)) {
            throw new IllegalArgumentException(
                    "Pessoa ja exerce papel exclusivo de gerente ou product owner: " + pessoa.getCpf());
        }
        if (!pessoa.hasPapel(TipoPapel.DESENVOLVEDOR)) {
            pessoa.addPapel(new Desenvolvedor());
        }
        desenvolvedores.put(pessoa.getCpf(), pessoa);
        return pessoa.getCpf();
    }

    public void promoverDevAGerente(String cpf) {
        if (this.gerente != null) {
            throw new IllegalStateException("Time ja possui um gerente: " + this.gerente.getCpf());
        }
        Pessoa pessoa = desenvolvedores.remove(cpf);
        if (pessoa == null) {
            throw new IllegalArgumentException("Desenvolvedor nao encontrado no time: " + cpf);
        }
        pessoa.removePapel(TipoPapel.DESENVOLVEDOR);
        pessoa.removePapel(TipoPapel.LIDER);
        pessoa.addPapel(new Gerente());

        this.gerente = pessoa;
    }

    public Sprint iniciaSprint(Date dataInicio, Date dataFim, String objetivo, String cpfLider) {
        Pessoa lider = desenvolvedores.get(cpfLider);
        if (lider == null) {
            throw new IllegalArgumentException("Desenvolvedor nao encontrado no time: " + cpfLider);
        }
        if (!lider.hasPapel(TipoPapel.LIDER)) {
            lider.addPapel(new Lider());
        }

        Sprint sprint = new Sprint(proximoSprintId, dataInicio, dataFim, objetivo, lider);
        sprints.put(proximoSprintId, sprint);
        proximoSprintId++;
        return sprint;
    }

    public void encerraSprint(int id) {
        Sprint sprint = sprints.get(id);
        if (sprint == null) {
            throw new IllegalArgumentException("Sprint nao encontrada: " + id);
        }

        sprint.encerra();
        Pessoa lider = sprint.getLider();
        if (lider != null) {
            lider.removePapel(TipoPapel.LIDER);
        }
    }

    public int getId() {
        return id;
    }

    public ProdutoSoftware getProduto() {
        return produto;
    }

    public Pessoa getGerente() {
        return gerente;
    }

    public Map<String, Pessoa> getDesenvolvedores() {
        return Collections.unmodifiableMap(desenvolvedores);
    }

    public Map<Integer, Sprint> getSprints() {
        return Collections.unmodifiableMap(sprints);
    }
}