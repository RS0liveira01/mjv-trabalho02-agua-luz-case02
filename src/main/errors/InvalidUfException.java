package errors;

public class InvalidUfException extends RuntimeException {
    @Override
    public String getMessage() {
        return "UF inválida!";
    }
}
