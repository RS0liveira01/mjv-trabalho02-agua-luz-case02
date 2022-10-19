package pessoa;

public enum TIPONOTIFICACAO {
    SMS("SMS"),
    WHATS("WhatsApp");

    public final String valor;

    private TIPONOTIFICACAO(String valor) {
        this.valor = valor;
    }
}
