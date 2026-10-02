public class Gerente implements Papel {

    @Override
    public TipoPapel getTipo() {
        return TipoPapel.GERENTE;
    }

    @Override
    public String getDescricao() {
        return "Gerente";
    }
}