package errors;

public class InvalidPhoneNumberException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Número de telefone inválido!";
    }
}
