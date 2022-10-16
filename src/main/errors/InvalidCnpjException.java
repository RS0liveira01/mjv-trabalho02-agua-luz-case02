package errors;

public class InvalidCnpjException extends RuntimeException {
    @Override
    public String getMessage() {
        return "CNPJ utilizado inválido!";
    }
}
