public class Lider implements Papel {

    @Override
    public TipoPapel getTipo() {
        return TipoPapel.LIDER;
    }

    @Override
    public String getDescricao() {
        return "Líder";
    }
}