package errors;

public class InvalidNomeException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Nome inválido!";
    }
}
