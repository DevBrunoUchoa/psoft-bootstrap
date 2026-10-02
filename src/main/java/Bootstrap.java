import java.util.Date;

public class Bootstrap {

    public static void main(String[] args) {
        Pessoa alice = new Pessoa("Alice", "111");
        Empresa empresa = new Empresa(alice);

        ProdutoSoftware produto = new ProdutoSoftware("CampusLiving", "Plataforma de alugueis");
        Time time = empresa.criaTime(produto);

        Pessoa bob = new Pessoa("Bob", "222");
        time.addDesenvolvedor(bob);

        Sprint sprint = time.iniciaSprint(new Date(), new Date(), "Entregar busca de imoveis", bob.getCpf());
        System.out.println(bob.getNome() + " e lider? " + bob.hasPapel(TipoPapel.LIDER));
        time.encerraSprint(sprint.getId());
        System.out.println(bob.getNome() + " e lider apos a sprint? " + bob.hasPapel(TipoPapel.LIDER));

        time.promoverDevAGerente(bob.getCpf());
        System.out.println(bob.getNome() + " e gerente? " + bob.hasPapel(TipoPapel.GERENTE));

        empresa.promoveGerente(time.getId());
        System.out.println(bob.getNome() + " e Product Owner? " + bob.hasPapel(TipoPapel.PRODUCT_OWNER));
        System.out.println(alice.getNome() + " ainda e Product Owner? " + alice.hasPapel(TipoPapel.PRODUCT_OWNER));
    }
}
