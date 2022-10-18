package errors;

public class DuplicatedProtocoloException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Protocolo de contrato duplicado!";
    }
}
