import java.util.ArrayList;
import java.util.List;

public class Pessoa {

    private Long id;
    private String nome;
    private int idade;
    private String cpf;
    private String telefone;
    private Profissao profissao;
    private Papel papel;
    private List<Endereco> enderecos = new ArrayList<>();

    public Pessoa(Long id, String nome, int idade, String cpf, String telefone, Profissao profissao, Papel papel) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.telefone = telefone;
        this.profissao = profissao;
        this.papel = papel;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Profissao getProfissao() {
        return profissao;
    }

    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }

    public Papel getPapel() {
        return papel;
    }

    public void setPapel(Papel papel) {
        this.papel = papel;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void adicionarEndereco(Endereco endereco) {
        enderecos.add(endereco);
    }

    public void removerEndereco(Endereco endereco) {
        enderecos.remove(endereco);
    }

    @Override
    public String toString() {
        return "Pessoa " + id + ": " + nome + ", " + idade + " anos, cpf " + cpf + ", tel " + telefone
                + ", profissao " + profissao + ", papel " + papel + ", enderecos " + enderecos;
    }
}
