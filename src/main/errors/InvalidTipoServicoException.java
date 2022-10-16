package errors;

public class InvalidTipoServicoException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Serviço inválido!";
    }
}
