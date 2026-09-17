public class Bootstrap {

    public static void main(String[] args) {
        System.out.println("Projeto de Software");

        CadastroPessoas cadastro = new CadastroPessoas();
        Profissao profissao = new Profissao("Desenvolvedor", "Constroi sistemas");
        Pessoa pessoa = cadastro.criar("Joao Bruno", 22, "12345678909", "83999990000", profissao, Papel.CLIENTE);
        pessoa.adicionarEndereco(new Endereco("Rua das Flores", "123", "Centro", "Campina Grande", "PB", "58400-000"));

        System.out.println(pessoa);
    }
}
