package errors;

public class IncoherentDataException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Dados fornecidos conflitam com o banco de dados!";
    }
}
