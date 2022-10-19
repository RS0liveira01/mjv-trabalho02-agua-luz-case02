package pessoa;

public enum TIPONOTIFICACAO {
    S("SMS"),
    W("WhatsApp");

    private String tipo;

    private TIPONOTIFICACAO(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
