package errors;

public class InvalidRgException extends RuntimeException {
    @Override
    public String getMessage() {
        return "RG utilizado inválido!";
    }
}
