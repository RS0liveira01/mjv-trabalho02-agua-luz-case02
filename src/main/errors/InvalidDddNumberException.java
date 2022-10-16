package errors;

public class InvalidDddNumberException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Número de DD inválido!";
    }
}
