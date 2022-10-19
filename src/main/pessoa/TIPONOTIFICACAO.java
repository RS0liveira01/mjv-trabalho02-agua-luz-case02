package pessoa;

public enum TIPONOTIFICACAO {
    SMS("SMS"),
    WHATS("WhatsApp");

    private String tipo;

    private TIPONOTIFICACAO(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
