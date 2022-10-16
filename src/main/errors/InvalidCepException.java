package errors;

public class InvalidCepException extends RuntimeException {
    @Override
    public String getMessage() {
        return "CEP Inválido!";
    }
}
