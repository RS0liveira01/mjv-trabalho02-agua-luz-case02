package pessoa;

public enum PAIS {
    BR("Brasil"),
    US("Estados Unidos"),
    FR("França");

    public final String valor;

    private PAIS(String valor) {
        this.valor = valor;
    }
}
