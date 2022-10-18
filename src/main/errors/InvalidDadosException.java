package errors;

public class InvalidDadosException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Falta dados para o registro de contrato!";
    }
}
