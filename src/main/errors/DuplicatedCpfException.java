package errors;

public class DuplicatedCpfException extends RuntimeException {
    @Override
    public String getMessage() {
        return "CPF já em uso!";
    }
}
