public class ProdutoSoftware {

    private String nome;
    private String descricao;

    public ProdutoSoftware(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}