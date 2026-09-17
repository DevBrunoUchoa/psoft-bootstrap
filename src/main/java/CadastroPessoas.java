import java.util.ArrayList;
import java.util.List;

public class CadastroPessoas {

    private List<Pessoa> pessoas = new ArrayList<>();
    private long proximoId = 1;

    public Pessoa criar(String nome, int idade, String cpf, String telefone, Profissao profissao, Papel papel) {
        Pessoa pessoa = new Pessoa(proximoId++, nome, idade, cpf, telefone, profissao, papel);
        pessoas.add(pessoa);
        return pessoa;
    }

    public Pessoa buscarPorId(Long id) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getId().equals(id)) {
                return pessoa;
            }
        }
        return null;
    }

    public List<Pessoa> listarTodos() {
        return pessoas;
    }

    public Pessoa atualizar(Long id, int idade, String telefone, Profissao profissao) {
        Pessoa pessoa = buscarPorId(id);
        if (pessoa == null) {
            return null;
        }
        pessoa.setIdade(idade);
        pessoa.setTelefone(telefone);
        pessoa.setProfissao(profissao);
        return pessoa;
    }

    public void deletar(Long id) {
        pessoas.removeIf(p -> p.getId().equals(id));
    }
}
