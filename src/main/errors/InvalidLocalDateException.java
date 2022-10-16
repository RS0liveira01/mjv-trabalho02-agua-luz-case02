package errors;

public class InvalidLocalDateException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Data inválida!";
    }
}
