package errors;

public class InvalidPaisException extends RuntimeException{
    @Override
    public String getMessage() {
        return "País inválido!";
    }
}
