public class Desenvolvedor implements Papel {

    @Override
    public TipoPapel getTipo() {
        return TipoPapel.DESENVOLVEDOR;
    }

    @Override
    public String getDescricao() {
        return "Desenvolvedor";
    }
}