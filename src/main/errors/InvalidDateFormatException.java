package errors;

public class InvalidDateFormatException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Formato de data inválido para este país!";
    }
}
