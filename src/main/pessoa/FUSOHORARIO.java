package pessoa;

public enum FUSOHORARIO {
    BR("-3"),
    S("-4"),
    FR("+2");

    public final String valor;

    private FUSOHORARIO(String valor) {
        this.valor = valor;
    }
}
