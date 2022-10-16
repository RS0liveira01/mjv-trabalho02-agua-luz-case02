package pessoa;

protected enum DDI{
    BR("+55"),
    US("+1"),
    FR("+33");

    public final String valor;

    private DDI(String valor) {
        this.valor = valor;
    }
}
