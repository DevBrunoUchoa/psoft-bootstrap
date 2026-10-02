import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pessoa {

    private String nome;
    private String cpf;
    private List<Papel> papeis;

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.papeis = new ArrayList<>();
    }

    public void addPapel(Papel papel) {
        papeis.add(papel);
    }

    public void removePapel(TipoPapel tipo) {
        papeis.removeIf(papel -> papel.getTipo() == tipo);
    }

    public boolean hasPapel(TipoPapel tipo) {
        return papeis.stream().anyMatch(papel -> papel.getTipo() == tipo);
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public List<Papel> getPapeis() {
        return Collections.unmodifiableList(papeis);
    }
}