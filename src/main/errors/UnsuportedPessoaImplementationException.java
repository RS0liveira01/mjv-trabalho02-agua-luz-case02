package errors;

public class UnsuportedPessoaImplementationException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Implementação de pessoa utilizada não é suportada por este banco de dados!";
    }
}
