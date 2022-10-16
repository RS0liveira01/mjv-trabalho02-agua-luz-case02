package errors;

public class InvalidNumberException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Número Inválido!";
    }
}
