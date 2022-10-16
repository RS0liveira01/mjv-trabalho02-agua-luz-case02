package errors;

public class InvalidProtocolException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Número de protocolo inválido!";
    }
}
