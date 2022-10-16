package errors;

public class DuplicatedCnpjException extends RuntimeException {
    @Override
    public String getMessage() {
        return "CNPJ já em uso!";
    }
}
