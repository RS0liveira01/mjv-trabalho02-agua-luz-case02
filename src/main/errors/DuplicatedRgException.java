package errors;

public class DuplicatedRgException extends RuntimeException {
    @Override
    public String getMessage() {
        return "RG já em uso!";
    }
}
