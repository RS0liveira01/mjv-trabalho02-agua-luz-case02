package errors;

public class InvalidDadosContratoException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Falta dados para o registro de contrato!";
    }
}
