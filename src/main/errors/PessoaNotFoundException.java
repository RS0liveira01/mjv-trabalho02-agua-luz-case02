package errors;

public class PessoaNotFoundException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Nenhuma pessoa foi encontrada com a informação fornecida!";
    }
}
