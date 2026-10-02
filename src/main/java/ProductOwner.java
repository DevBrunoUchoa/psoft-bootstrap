public class ProductOwner implements Papel {

    @Override
    public TipoPapel getTipo() {
        return TipoPapel.PRODUCT_OWNER;
    }

    @Override
    public String getDescricao() {
        return "Product Owner";
    }
}