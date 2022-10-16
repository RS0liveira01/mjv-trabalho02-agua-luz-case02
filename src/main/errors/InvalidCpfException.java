package errors;

public class InvalidCpfException extends RuntimeException {
    @Override
    public String getMessage() {
        return "CPF utilizado inválido!";
    }
}
